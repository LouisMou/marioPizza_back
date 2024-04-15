package com.ecf3.marioPizza.security.Dto;

public class ApiResponse {
	/**
	 *
	 */
	private Boolean success;
	/**
	 *
	 */
	private String message;

	/**
	 *
	 * @param pSuccess
	 * @param pMessage
	 */
	public ApiResponse(final Boolean pSuccess, final String pMessage) {
		this.success = pSuccess;
		this.message = pMessage;
	}

	/**
	 *
	 * @return success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 *
	 * @param pSuccess
	 */
	public void setSuccess(final Boolean pSuccess) {
		this.success = pSuccess;
	}

	/**
	 *
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 *
	 * @param pMessage
	 */
	public void setMessage(final String pMessage) {
		this.message = pMessage;
	}
}
