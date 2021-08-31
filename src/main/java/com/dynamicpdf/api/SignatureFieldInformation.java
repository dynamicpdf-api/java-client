package com.dynamicpdf.api;

/**
 * Represents information of a signature field.
 */
public class SignatureFieldInformation {

	private String name;
	private boolean signed;

	/**
	 * Gets the name of a signature field.
	 * @return The name of a signature field.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of a signature field.
	 * @param value The name of a signature field.
	 */
	public void setName(String value) {
		name = value;
	}

	/**
	 * Gets the boolean, indicating the field signed or not.
	 * @return The boolean, indicating the field signed or not.
	 */
	public boolean getSigned() {
		return signed;
	}

	/**
	 * Sets the boolean, indicating the field signed or not.
	 * @param value The boolean, indicating the field signed or not.
	 */
	public void setSigned(boolean value) {
		signed = value;
	}
}
