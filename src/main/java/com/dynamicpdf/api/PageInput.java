package com.dynamicpdf.api;

import com.dynamicpdf.api.elements.Element;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a page input.
 */

@JsonInclude(Include.NON_DEFAULT)
public class PageInput extends Input {

	private float pageWidth = 0;
	private float pageHeight = 0;

	private List<Element> elements = null;

	/**
	 * Initializes a new instance of the <code>PageInput</code> class.
	 * @param pageWidth The width of the page.
	 * @param pageHeight The height of the page.
	 */

	public PageInput(float pageWidth, float pageHeight) {
		this.pageWidth = pageWidth;
		this.pageHeight = pageHeight;
	}

	/**
	 * Initializes a new instance of the <code>PageInput</code> class.
	 */

	public PageInput() {
		super();
	}

	@JsonInclude
	@JsonProperty("type")
	InputType getType() {
		return InputType.PAGE;
	}

	/**
	 * Gets the width of the page.
	 * @return The width of the page.
	 */
	public float getPageWidth() {
		return pageWidth;
	}

	/**
	 * Sets the width of the page.
	 * @param value The width of the page.
	 */
	public void setPageWidth(float value) {
		pageWidth = value;
	}

	/**
	 * Gets the height of the page.
	 * @return The height of the page.
	 */
	public float getPageHeight() {
		return pageHeight;
	}

	/**
	 * Sets the height of the page.
	 * @param value The height of the page.
	 */
	public void setPageHeight(float value) {
		pageHeight = value;
	}

	/**
	 * Gets or sets the elements of the page.
	 * @return The elements of the page.
	 */
	public List<Element> getElements() {
		if (elements == null) {
			elements = new ArrayList<Element>();
		}
		return elements;
	}
}
