package com.dynamicpdf.api;

/**
 *  Represents information of a text field.
 */
public class TextFieldInformation {

	private String name;
	private String value;
	private String defaultValue;

	/**
	 * Gets the name of the Text field.
	 * @return The name of the Text field.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Text field.
	 * @param value The name of the Text field.
	 */
	public void setName(String value) {
		name = value;
	}

	/**
	 * Gets the value of the Text field.
	 * @return The value of the Text field.
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Sets the value of the Text field.
	 * @param value The value of the Text field.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the default value of the Text field.
	 * @return The default value of the Text field.
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the default value of the Text field.
	 * @param value The default value of the Text field.
	 */
	public void setDefaultValue(String value) {
		defaultValue = value;
	}
}
