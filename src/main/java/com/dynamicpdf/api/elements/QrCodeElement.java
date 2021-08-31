package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents a QR code barcode element.
 * 
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class QrCodeElement extends Dim2BarcodeElement {

	private QrCodeFnc1 fnc1 = null;
	private int version;

	/**
	 * Initializes a new instance of the <code>QrCodeElement</code> class.
	 * 
	 * @param value The value of the QR code.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the QR code.
	 * @param yOffset The Y coordinate of the QR code.
	 */
	public QrCodeElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
	}

	/**
	 * Initializes a new instance of the <code>QrCodeElement</code> class.
	 * 
	 * @param value The value of the QR code.
	 * @param placement The placement of the barcode on the page.
	 */
	public QrCodeElement(String value, ElementPlacement placement) {
		this(value, placement, 0, 0);
	}

	/**
	 * Initializes a new instance of the <code>QrCodeElement</code> class.
	 * 
	 * @param value The value of the QR code.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the QR code.
	 * @param yOffset The Y coordinate of the QR code.
	 */
	public QrCodeElement(byte[] value, ElementPlacement placement, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
	}

	/**
	 * Initializes a new instance of the <code>QrCodeElement</code> class.
	 * 
	 * @param value The value of the QR code.
	 * @param placement The placement of the barcode on the page.
	 */
	public QrCodeElement(byte[] value, ElementPlacement placement) {
		this(value, placement, 0, 0);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.QRCODE;
	}

	/**
	 * Gets FNC1 mode.
	 * @return FNC1 mode.
	 */
	@JsonProperty("fnc1")
	public QrCodeFnc1 getFnc1() {
		return fnc1;
	}

	/**
	 * Sets FNC1 mode.
	 * @param value FNC1 mode.
	 */
	public void setFnc1(QrCodeFnc1 value) { 
		fnc1 = value;
	}

	/**
	 * Gets the QR code version.
	 * @return the QR code version.
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Sets the QR code version.
	 * @param value The QR code version.
	 */
	public void setVersion(int value) {
		version = value;
	}
}
