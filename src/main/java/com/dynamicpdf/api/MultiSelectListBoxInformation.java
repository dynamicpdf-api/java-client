package com.dynamicpdf.api;

/**
 * Represents information of a MultiSelectListBox.
 */

public class MultiSelectListBoxInformation {

	private String name;
	private String[] values;
	private String[] defaultValues;
	private String[] exportValues;
	private String[] items;
	private String[] itemsExportValues;

	/**
	 * Gets the name of a MultiSelectListBox.
	 * @return  The name of a MultiSelectListBox.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of a MultiSelectListBox.
	 * @param value The name of a MultiSelectListBox.
	 */
	public void setName(String value) {
		name = value;
	}

	/**
	 * Gets a collection of values of the MultiSelectListBox.
	 * @return A collection of values of the MultiSelectListBox.
	 */
	public String[] getValues() {
		return values;
	}

	/**
	 * Sets a collection of values of the MultiSelectListBox.
	 * @param value A collection of values of the MultiSelectListBox.
	 */
	public void setValues(String[] value) {
		values = value;
	}

	/**
	 * Gets a collection of default values of the MultiSelectListBox.
	 * @return A collection of default values of the MultiSelectListBox.
	 */
	public String[] getDefaultValues() {
		return defaultValues;
	}

	/**
	 * Sets a collection of default values of the MultiSelectListBox.
	 * @param value A collection of default values of the MultiSelectListBox.
	 */
	public void setDefaultValues(String[] value) {
		defaultValues = value;
	}

	/**
	 * Gets a collection of export values of the MultiSelectListBox.
	 * @return A collection of export values of the MultiSelectListBox.
	 */
	public String[] getExportValues() {
		return exportValues;
	}

	/**
	 * Sets a collection of export values of the MultiSelectListBox.
	 * @param value A collection of export values of the MultiSelectListBox.
	 */
	public void setExportValues(String[] value) {
		exportValues = value;
	}

	/**
	 * Gets a collection of items of the MultiSelectListBox.
	 * @return A collection of items of the MultiSelectListBox.
	 */
	public String[] getItems() {
		return items;
	}

	/**
	 * Sets a collection of items of the MultiSelectListBox.
	 * @param value A collection of items of the MultiSelectListBox.
	 */
	public void setItems(String[] value) {
		items = value;
	}

	/**
	 * Gets a collection of export values of the MultiSelectListBox.
	 * @return A collection of export values of the MultiSelectListBox.
	 */
	public String[] getItemsExportValues() {
		return itemsExportValues;
	}

	/**
	 * Sets a collection of export values of the MultiSelectListBox.
	 * @param value A collection of export values of the MultiSelectListBox.
	 */
	public void setItemsExportValues(String[] value) {
		itemsExportValues = value;
	}
}
