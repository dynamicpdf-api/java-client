package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)

/**
 * Represents a form field in the PDF document.
 */

public class FormField {

	private String name;
	private String value = null;
	private boolean flatten;
	private boolean remove;

	/**
	 * Initializes a new instance of the <code>FormField</code> class 
	 * using the name of the form field as a parameter.
	 * @param name The name of the form field.
	 */

	public FormField(String name) {
		this.name = name;
	}

	/**
	 * Initializes a new instance of the <code>FormField</code> class 
	 * using the name and the value of the form field as parameters.
	 * @param name The name of the form field.
	 * @param value The value of the form field.
	 */

	public FormField(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Gets name of the form field.
	 * @return Name of the form field.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name of the form field.
	 * @param value Name of the form field.
	 */
	public void setName(String value) {
		name = value;
	}

	/**
	 * Gets value of the form field.
	 * @return Value of the form field.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets value of the form field.
	 * @param value Value of the form field.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets a boolean indicating whether to flatten the form field.
	 * @return A boolean indicating whether to flatten the form field.
	 */
	public boolean getFlatten() {
		return flatten;
	}

	/**
	 * Sets a boolean indicating whether to flatten the form field.
	 * @param value A boolean indicating whether to flatten the form field.
	 */
	public void setFlatten(boolean value) {
		flatten = value;
	}

	/**
	 * Gets a boolean indicating whether to remove the form field.
	 * @return A boolean indicating whether to remove the form field.
	 */
	public boolean getRemove() {
		return remove;
	}

	/**
	 * Sets a boolean indicating whether to remove the form field.
	 * @param value A boolean indicating whether to remove the form field.
	 */
	public void setRemove(boolean value) {
		remove = value;
	}

}
