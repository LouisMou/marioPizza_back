/**
 *
 */
package com.ecf3.marioPizza.security.Dto;

/**
 *
 */
public class SignUpRequest {

	/**
	 * lastname.
	 */
	private String lastname;

	/**
	 * firstname.
	 */

	private String firstname;

	/**
	 * pwd.
	 */
	private String password;

	/**
	 * address.
	 */
	private String address;

	/**
	 * username.
	 */
	private String username;

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param pLastname the lastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param pFirstname the firstname to set
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
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

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param pUsername the username to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

}
