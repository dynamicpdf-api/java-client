package com.dynamicpdf.api;

/**
 * Represents the information of a choice field in interactive forms.
 * A choice field contains several text items,
 * one or more of which may be selected as the field value.
 */
public class ChoiceFieldInformation {

	private String name;
	private ChoiceFieldType type;
	private String value;
	private String defaultValue;
	private String exportValue;
	private String[] items;
	private String[] itemExportValues;

	/**
	 * Gets the name of the choice field.
	 * @return The name of the form field.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the choice field.
	 * @param value The name of the form field.
	 */
	public void setName(String value) {
		name = value;
	}

	/**
	 * Gets the <code>ChoiceFieldType</code> . ex: ListBox, ComboBox etc.
	 * @return The type of the form field.
	 */
	public ChoiceFieldType getType() {
		return type;
	}

	/**
	 * Sets the <code>ChoiceFieldType</code> . ex: ListBox, ComboBox etc.
	 * @param value The type of the form field.
	 */
	public void setType(ChoiceFieldType value) {
		type = value;
	}

	/**
	 ** Gets the value of the choice field.
	 * @return The value of the form field.
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 ** sets the value of the choice field.
	 * @param value The value of the form field.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the default value of the choice field.
	 * @return The Default value of the form field.
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the default value of the choice field.
	 * @param value The Default value of the form field.
	 */
	public void setDefaultValue(String value) {
		defaultValue = value;
	}

	/**
	 * Gets the export value.
	 * @return The export value of the form field.
	 */
	public String getExportValue() {
		return exportValue;
	}

	/**
	 * Sets the export value.
	 * @param value The export value of the form field.
	 */
	public void setExportValue(String value) {
		exportValue = value;
	}

	/**
	 * Gets the collection of items.
	 * @return The collection of items in the form field.
	 */
	public String[] getItems() {
		return items;
	}

	/**
	 * Sets the collection of items.
	 * @param value The collection of items for the form field.
	 */
	public void setItems(String[] value) {
		items = value;
	}

	/**
	 * Gets the collection of export values of the items present in the choice field.
	 * @return The collection of export values of the items in the form field.
	 */
	public String[] getItemExportValues() {
		return itemExportValues;
	}

	/**
	 * Sets the collection of export values of the items present in the choice field.
	 * @param value The collection of export values of the items for the form field.
	 */
	public void setItemExportValues(String[] value) {
		itemExportValues = value;
	}
}
