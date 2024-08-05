package com.dynamicpdf.api;

import java.util.UUID;

/**
 * Represents the base class for response.
 */
public class Response {

	private boolean isSuccessful;
	private String errorJson;
	private String errorMessage;
	private UUID errorId = null;
	private int statusCode;

	/**
	 * Gets the boolean, indicating the response's status.
	 * @return The boolean, indicating the response's status.
	 */
	public boolean getIsSuccessful() {
		return isSuccessful;
	}

	public void setIsSuccessful(boolean value) {
		isSuccessful = value;
	}

	/**
	 * Gets the error message.
	 * @return The error message.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String value) {
		errorMessage = value;
	}

	/**
	 * Gets the error id.
	 * @return The error id.
	 */
	public UUID getErrorId() {
		return errorId;
	}

	public void setErrorId(UUID value) {
		errorId = value;
	}

	/**
	 * Gets the status code.
	 * @return The status code.
	 */
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int value) {
		statusCode = value;
	}

	/**
	 * Gets the error json.
	 * @return The error json.
	 */
	public String getErrorJson() {
		return errorJson;
	}

	public void setErrorJson(String value) {
		errorJson = value;
	}
}
