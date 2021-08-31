package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents a Code 2 of 5 barcode element.
 * 
 * <p> This class can be used to place a Code 2 of 5 barcode on a page.</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class Code25BarcodeElement extends TextBarcodeElement {

	private float height;

	/**
	 * Initializes a new instance of the <code>Code25BarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param height The height of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 */
	public Code25BarcodeElement(String value, ElementPlacement placement, float height, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
		this.height = height;
	}

	/**
	 * Initializes a new instance of the <code>Code25BarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param height The height of the barcode.
	 */
	public Code25BarcodeElement(String value, ElementPlacement placement, float height) {
		this(value, placement, height, 0, 0);

	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.CODE25BARCODE;
	}

	/**
	 * Gets the height of the barcode.
	 * @return The height of the barcode.
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Sets the height of the barcode.
	 * @param value The height of the barcode.
	 */
	public void setHeight(float value) {
		height = value;
	}
}
