package com.ecf3.marioPizza.security.controller;

import java.net.URI;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecf3.marioPizza.security.Dto.ApiResponse;
import com.ecf3.marioPizza.security.Dto.JwtResponse;
import com.ecf3.marioPizza.security.Dto.LoginRequest;
import com.ecf3.marioPizza.security.Dto.SignUpRequest;
import com.ecf3.marioPizza.security.Dto.TokenRefreshRequest;
import com.ecf3.marioPizza.security.Dto.TokenRefreshResponse;
import com.ecf3.marioPizza.security.Dto.UserDto;
import com.ecf3.marioPizza.security.jwt.JwtProvider;
import com.ecf3.marioPizza.security.jwt.exception.AppException;
import com.ecf3.marioPizza.security.jwt.exception.TokenRefreshException;
import com.ecf3.marioPizza.security.models.RefreshToken;
import com.ecf3.marioPizza.security.models.Role;
import com.ecf3.marioPizza.security.models.RoleName;
import com.ecf3.marioPizza.security.models.User;
import com.ecf3.marioPizza.security.repository.RoleRepository;
import com.ecf3.marioPizza.security.repository.UserRepository;
import com.ecf3.marioPizza.security.service.IRefreshTokenService;
import com.ecf3.marioPizza.security.service.impl.UserDetailsServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 * Classe permettant de gérer la sécurité.
 *
 * @author piot
 *
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = { "http://localhost:3000" })
public final class AuthController {

	/** token header to use in JWT. */
	@Value("${app.jwtTokenHeader}")
	private String tokenHeader;

	/** import authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * link.
	 */
	@Autowired
	private UserRepository userRepository;

	/** import jwtprovider. */
	@Autowired
	private JwtProvider tokenProvider;
	/**
	 * link.
	 */
	@Autowired
	private RoleRepository roleRepository;
	/**
	 * link.
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/** import refreshToken service. */
	@Autowired
	private IRefreshTokenService refreshTokenService;

	/** import user service. */
	@Autowired
	private UserDetailsServiceImpl userService;

	/**
	 *
	 * @param request a login + password couple
	 * @return a response with the jwt
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody final LoginRequest request) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(request.getUsername());

		User user = userService.loadUserDetails(request.getUsername());

		refreshTokenService.deleteExpired();
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());

		return ResponseEntity.ok(new JwtResponse(tokenHeader + " " + jwt, tokenProvider.getExpiryDate(jwt),
				new UserDto(user), refreshToken.getToken()));
	}

	/**
	 * method to signup.
	 *
	 * @param signUpRequest
	 * @return the freshly created user.
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody final SignUpRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use"), HttpStatus.BAD_REQUEST);
		}

		User user = new User(signUpRequest.getLastname(), signUpRequest.getFirstname(), signUpRequest.getAddress(),
				signUpRequest.getUsername(), signUpRequest.getPassword());

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role userRole = roleRepository.findByName(RoleName.USER)
				.orElseThrow(() -> new AppException("User Role not set"));

		user.setRoles(Collections.singleton(userRole));

		User result = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
				.buildAndExpand(result.getUsername()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}

	/**
	 * Get a new token.
	 *
	 * @param request a valid refresh token
	 * @return a new token
	 */
	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@Valid @RequestBody final TokenRefreshRequest request) {
		String requestRefreshToken = request.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken).map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUser).map(user -> {
					String jwt = tokenProvider.generateToken(user.getUsername());
					RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getId());
					return ResponseEntity.ok(new TokenRefreshResponse(tokenHeader + " " + jwt,
							tokenProvider.getExpiryDate(jwt), refreshToken.getToken()));
				})
				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	}

	/**
	 *
	 * @param userDto a userDto containing at least a username and a list of
	 *                settings
	 * @param request the http request
	 * @return the updated user
	 */
	@PostMapping(value = "/updateSettings")
	public UserDto updateSettings(final @RequestBody UserDto userDto, final HttpServletRequest request) {
		User user = userService.loadUserDetails(userDto.getUsername());

		return new UserDto(userService.update(user));

	}
}
