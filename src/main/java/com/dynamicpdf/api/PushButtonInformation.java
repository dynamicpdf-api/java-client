package com.dynamicpdf.api;

/**
 * Represents information of a PushButton field.
 */
public class PushButtonInformation {

	private String name;
	private String label;

	/**
	 * Gets the name of a PushButton field.
	 * @return The name of a PushButton field.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of a PushButton field.
	 * @param value The name of a PushButton field.
	 */
	public void setName(String value) {
		name = value;
	}

	/**
	 * Gets the label of a PushButton field.
	 * @return The label of a PushButton field.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label of a PushButton field.
	 * @param value The label of a PushButton field.
	 */
	public void setLabel(String value) {
		label = value;
	}
}
