package com.ecf3.marioPizza.security.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	/** technical id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/** username aka login. */
	@Column(name = "phonenumber")
	private String username = "...";

	/** password. */
	@Column(name = "password")
	private String password = "...";

	/** firstname. */
	@Column(name = "firstname")
	private String firstname = "...";

	/** lastname. */
	@Column(name = "lastname")
	private String lastname = "...";

	/**
	 * address.
	 */
	@Column(name = "address")
	private String address = "...";

	/** roles of the user. */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	/**
	 * Default constructor.
	 */
	public User() {
	}

	/**
	 * Construct a new User.
	 *
	 * @param pUsername the username
	 * @param pPassword the password
	 * @param pAddress  the address
	 */
	public User(final String pUsername, final String pAddress, final String pPassword) {
		this.username = pUsername;
		this.password = pPassword;
		this.address = pAddress;
	}

	/**
	 *
	 * @param pLastname2
	 * @param pFirstname2
	 * @param pAddress2
	 * @param pUsername2
	 * @param pPassword2
	 */
	public User(final String pLastname2, final String pFirstname2, final String pAddress2, final String pUsername2,
			final String pPassword2) {
		this.lastname = pLastname2;
		this.firstname = pFirstname2;
		this.address = pAddress2;
		this.username = pUsername2;
		this.password = pPassword2;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @return the name of the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param pFirstname the firstname to set
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Long pId) {
		this.id = pId;
	}

	/**
	 * @param pLastname the lastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * @param pRoles the roles to set
	 */
	public void setRoles(final Set<Role> pRoles) {
		this.roles = pRoles;
	}

	/**
	 * @param pUsername the username to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param pAddress the address to set
	 */
	public void setAddress(final String pAddress) {
		this.address = pAddress;
	}

}
