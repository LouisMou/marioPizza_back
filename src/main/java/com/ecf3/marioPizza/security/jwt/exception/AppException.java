/**
 *
 */
package com.ecf3.marioPizza.security.jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {
	/**
	 *
	 * @param message
	 */
	public AppException(final String message) {
		super(message);
	}

	/**
	 *
	 * @param message
	 * @param cause
	 */
	public AppException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
