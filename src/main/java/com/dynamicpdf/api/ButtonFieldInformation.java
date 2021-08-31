package com.dynamicpdf.api;

/**
 * Represents information of a button field.
 */
public class ButtonFieldInformation {

	private String name;
	private ButtonFieldType type;
	private String value;
	private String defaultValue;
	private String exportValue;
	private String[] exportValues;

	/**
	 * Gets the name of the button field.
	 * @return The name of the form field.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the button field.
	 * @param value Name of the form field.
	 */
	public void setName(String value) {
		name = value;
	}

	/**
	 * Gets the type of the button field, ex: RadioButton, CheckBox etc.
	 * @return The name of the form field.
	 */
	public ButtonFieldType getType() {
		return type;
	}

	/**
	 * sets the type of the button field, ex: RadioButton, CheckBox etc.
	 * @param value Type of the field
	 */
	public void setType(ButtonFieldType value) {
		type = value;
	}

	/**
	 * Gets the value of the button field.
	 * @return The value of form field
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * sets the value of the button field.
	 * @param value The value of form field
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the default value of the button field.
	 * @return The Default value of the form field.
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the default value of the button field.
	 * @param value The default value of the form field.
	 */
	public void setDefaultValue(String value) {
		defaultValue = value;
	}

	/**
	 * Gets the export value. These values will be exported when submitting the form.
	 * <p> To create a set of mutually exclusive radio buttons
	 * (i.e., where only one can be selected at a time),
	 * create the fields with the same name but different export values. </p>
	 * @return The Export Value of the form field.
	 */
	public String getExportValue() {
		return exportValue;
	}

	/**
	 * Sets the export value. These values will be exported when submitting the form.
	 * <p> To create a set of mutually exclusive radio buttons
	 * (i.e., where only one can be selected at a time),
	 * create the fields with the same name but different export values. </p>
	 * @param value The export value of the form field.
	 */
	public void setExportValue(String value) {
		exportValue = value;
	}

	/**
	 * Gets the collection of export value.
	 * @return The exportValues array of the form field.
	 */
	public String[] getExportValues() {
		return exportValues;
	}

	/**
	 * Sets the collection of export value.
	 * @param value The exportValues array of the form field.
	 */
	public void setExportValues(String[] value) {
		exportValues = value;
	}
}
