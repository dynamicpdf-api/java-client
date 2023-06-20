package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.FloatJsonSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents a GS1DataBar barcode element.
 * 
 * <p>This class can be used to place a GS1DataBar barcode on a page.</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class Gs1DataBarBarcodeElement extends TextBarcodeElement {

	private Gs1DataBarType type;
	private float height;

	/**
	 * Initializes a new instance of the <code>Gs1DataBarBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param height The height of the barcode.
	 * @param type The GS1DataBarType of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.   
	 */
	public Gs1DataBarBarcodeElement(String value, ElementPlacement placement, float height, Gs1DataBarType type, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
		this.type = type;
		this.height = height;
	}
	
	/**
	 * Initializes a new instance of the <code>Gs1DataBarBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param height The height of the barcode.
	 * @param type The GS1DataBarType of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.   
	 */
	public Gs1DataBarBarcodeElement(String value, float height, Gs1DataBarType type, float xOffset, float yOffset) {
		super(value, ElementPlacement.TOPLEFT, xOffset, yOffset);
		this.type = type;
		this.height = height;
	}

	/**
	 * Initializes a new instance of the <code>Gs1DataBarBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param height The height of the barcode.
	 * @param type The GS1DataBarType of the barcode.
	 */
	public Gs1DataBarBarcodeElement(String value, ElementPlacement placement, float height, Gs1DataBarType type) {
		this(value, placement, height, type, 0, 0);
	}
	
	/**
	 * Initializes a new instance of the <code>Gs1DataBarBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param height The height of the barcode.
	 * @param type The GS1DataBarType of the barcode.
	 */
	public Gs1DataBarBarcodeElement(String value, float height, Gs1DataBarType type) {
		this(value, ElementPlacement.TOPLEFT, height, type, 0, 0);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.GS1DATABARBARCODE;
	}

	@JsonProperty("gs1DataBarType")
	Gs1DataBarType getGs1DataBarType() {
		return type;
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
