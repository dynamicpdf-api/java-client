package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.FloatJsonSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents a Code 128 barcode element.
 * 
 * <p> This class can be used to place a Code 128 barcode on a page.</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class Code128BarcodeElement extends TextBarcodeElement {

	private float height;
	private boolean uccEan128;
	private boolean processTilde;

	/**
	 * Initializes a new instance of the <code>Code128BarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param height The height of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 * 
	 * <p>Code sets can be specified along with data, in order to do this <code>ProcessTilde</code> property needs to be set to <b>true</b>.
	 * Example value: "~BHello ~AWORLD 1~C2345", where ~A, ~B and ~C representing code sets A, B and C respectively.
	 * However if any inline code set has invalid characters it will be shifted to an appropriate code set.</p>
	 */
	public Code128BarcodeElement(String value, ElementPlacement placement, float height, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
		this.height = height;
	}
	
	/**
	 * Initializes a new instance of the <code>Code128BarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param height The height of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 * 
	 * <p>Code sets can be specified along with data, in order to do this <code>ProcessTilde</code> property needs to be set to <b>true</b>.
	 * Example value: "~BHello ~AWORLD 1~C2345", where ~A, ~B and ~C representing code sets A, B and C respectively.
	 * However if any inline code set has invalid characters it will be shifted to an appropriate code set.</p>
	 */
	public Code128BarcodeElement(String value, float height, float xOffset, float yOffset) {
		super(value, ElementPlacement.TOPLEFT, xOffset, yOffset);
		this.height = height;
	}

	/**
	 * Initializes a new instance of the <code>Code128BarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param height The height of the barcode.
	 */
	public Code128BarcodeElement(String value, ElementPlacement placement, float height) {
		this(value, placement, height, 0, 0);
	}
	
	/**
	 * Initializes a new instance of the <code>Code128BarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param height The height of the barcode.
	 */
	public Code128BarcodeElement(String value, float height) {
		this(value, ElementPlacement.TOPLEFT, height, 0, 0);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.CODE128BARCODE;
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

	/**
	 * Gets a boolean representing if the barcode is a UCC / EAN Code 128 barcode.
	 * 
	 * <p>If <b>true</b> an FNC1 code will be the first character in the barcode.</p>
	 * @return A boolean representing if the barcode is a UCC / EAN Code 128 barcode.
	 */
	public boolean getUccEan128() {
		return uccEan128;
	}

	/**
	 * Sets a boolean representing if the barcode is a UCC / EAN Code 128 barcode.
	 * 
	 * <p>If <b>true</b> an FNC1 code will be the first character in the barcode.</p>
	 * @param value A boolean representing if the barcode is a UCC / EAN Code 128 barcode.
	 */
	public void setUccEan128(boolean value) {
		uccEan128 = value;
	}

	/**
	 * Gets a boolean indicating whether to process the tilde character.
	 * 
	 * <p>If <b>true</b> checks for fnc1 (~1) character in the barcode Value and checks for the inline code sets if present in the data to process.
	 * Example value: "~BHello ~AWORLD 1~C2345", where ~A, ~B and ~C representing code sets A, B and C respectively.
	 * However if any inline code set has invalid characters it will be shifted to an appropriate code set.
	 * "\" is used as an escape character to add ~.</p> 
	 * @return A boolean indicating whether to process the tilde character.
	 */
	public boolean getProcessTilde() {
		return processTilde;
	}

	/**
	 * Sets a boolean indicating whether to process the tilde character.
	 * 
	 * <p>If <b>true</b> checks for fnc1 (~1) character in the barcode Value and checks for the inline code sets if present in the data to process.
	 * Example value: "~BHello ~AWORLD 1~C2345", where ~A, ~B and ~C representing code sets A, B and C respectively.
	 * However if any inline code set has invalid characters it will be shifted to an appropriate code set.
	 * @param value A boolean indicating whether to process the tilde character.
	 */
	public void setProcessTilde(boolean value) {
		processTilde = value;
	}
}
