package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.FloatJsonSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents an IATA 2 of 5 barcode element.
 *
 * <p>This class can be used to place an IATA 2 of 5 barcode on a page.</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class Iata25BarcodeElement extends TextBarcodeElement {

	private boolean includeCheckDigit;
	private float height;

	/**
	 * Initializes a new instance of the <code>Iata25BarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param height The height of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 */
	public Iata25BarcodeElement(String value, ElementPlacement placement, float height, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
		this.height = height;
	}
	
	/**
	 * Initializes a new instance of the <code>Iata25BarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param height The height of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 */
	public Iata25BarcodeElement(String value, float height, float xOffset, float yOffset) {
		super(value, ElementPlacement.TOPLEFT, xOffset, yOffset);
		this.height = height;
	}

	/**
	 * Initializes a new instance of the <code>Iata25BarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param height The height of the barcode.
	 */
	public Iata25BarcodeElement(String value, ElementPlacement placement, float height) {
		this(value, placement, height, 0, 0);
	}
	
	/**
	 * Initializes a new instance of the <code>Iata25BarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param height The height of the barcode.
	 */
	public Iata25BarcodeElement(String value, float height) {
		this(value, ElementPlacement.TOPLEFT, height, 0, 0);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.IATA25BARCODE;
	}

	/**
	 * Gets a value indicating if the check digit should be added to the value.
	 * @return A value indicating if the check digit should be added to the value.
	 */
	public boolean getIncludeCheckDigit() {
		return includeCheckDigit;
	}

	/**
	 * Sets a value indicating if the check digit should be added to the value.
	 * @param value A value indicating if the check digit should be added to the value.
	 */
	public void setIncludeCheckDigit(boolean value) {
		includeCheckDigit = value;
	}

	/**
	 * Gets the height of the barcode.
	 * @return The height of the barcode.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
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
