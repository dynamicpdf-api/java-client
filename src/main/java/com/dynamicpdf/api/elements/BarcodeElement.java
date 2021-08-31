package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Color;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base class from which barcode page elements are derived.
 */
public abstract class BarcodeElement extends Element {

	private Color color;
	private String colorName;
	private float xDimension;

	BarcodeElement() {
	}

	BarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
	}

	@JsonProperty("color")
	String getColorName() {
		return colorName;
	}

	void ColorName(String value) {
		colorName = value;
	}

	/**
	 *  Gets the Color of the barcode.
	 * @return The Color of the barcode.
	 */
	@JsonIgnore
	public Color getColor() {
		return color;
	}

	/**
	 *  Sets the Color of the barcode.
	 * @param value The Color of the barcode.
	 */
	public void setColor(Color value) {
		color = value;
		colorName = color.getColorString();
	}

	/**
	 * Gets the XDimension of the barcode.
	 * @return The XDimension of the barcode.
	 */
	@JsonProperty("xDimension")
	public float getXDimension() {
		return xDimension;
	}

	/**
	 * Sets the XDimension of the barcode.
	 * @param value The XDimension of the barcode.
	 */
	public void setXDimension(float value) {
		xDimension = value;
	}

	/**
	 * Gets the value of the barcode.
	 * @return The value of the barcode.
	 */
	public String getValue() {
		return getInputValue();

	}

	/**
	 * Sets the value of the barcode.
	 * @param value The value of the barcode.
	 */
	public void setValue(String value) {
		setInputValue(value);
	}

}
