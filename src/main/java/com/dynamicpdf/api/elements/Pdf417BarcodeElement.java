package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.FloatJsonSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents Pdf417 barcode element.
 * 
 * <p>This class can be used to generate Pdf417 barcode symbol.</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class Pdf417BarcodeElement extends Dim2BarcodeElement {

	private int columns;
	private float yDimension;
	private boolean processTilde;
	private boolean compactPdf417;
	private ErrorCorrection errorCorrection;
	private Compaction compaction;

	/**
	 * Initializes a new instance of the <code>Pdf417BarcodeElement</code> class.
	 * 
	 * @param value String to be encoded.
	 * @param placement The placement of the barcode on the page.
	 * @param columns Columns of the PDF417 barcode.
	 * @param xOffset The X coordinate of the PDF417 barcode.
	 * @param yOffset The Y coordinate of the PDF417 barcode.
	 */
	public Pdf417BarcodeElement(String value, ElementPlacement placement, int columns, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
		this.columns = columns;
	}
	
	/**
	 * Initializes a new instance of the <code>Pdf417BarcodeElement</code> class.
	 * 
	 * @param value String to be encoded.
	 * @param columns Columns of the PDF417 barcode.
	 * @param xOffset The X coordinate of the PDF417 barcode.
	 * @param yOffset The Y coordinate of the PDF417 barcode.
	 */
	public Pdf417BarcodeElement(String value, int columns, float xOffset, float yOffset) {
		super(value, ElementPlacement.TOPLEFT, xOffset, yOffset);
		this.columns = columns;
	}

	/**
	 * Initializes a new instance of the <code>Pdf417BarcodeElement</code> class.
	 * 
	 * @param value String to be encoded.
	 * @param placement The placement of the barcode on the page.
	 * @param columns Columns of the PDF417 barcode.
	 */
	public Pdf417BarcodeElement(String value, ElementPlacement placement, int columns) {
		this(value, placement, columns, 0, 0);
	}
	
	/**
	 * Initializes a new instance of the <code>Pdf417BarcodeElement</code> class.
	 * 
	 * @param value String to be encoded.
	 * @param columns Columns of the PDF417 barcode.
	 */
	public Pdf417BarcodeElement(String value, int columns) {
		this(value, ElementPlacement.TOPLEFT, columns, 0, 0);
	}

	/**
	 * Initializes a new instance of the <code>Pdf417BarcodeElement</code> class.
	 * 
	 * @param value String to be encoded.
	 * @param placement The placement of the barcode on the page.
	 * @param columns Columns of the PDF417 barcode.
	 * @param xOffset The X coordinate of the PDF417 barcode.
	 * @param yOffset The Y coordinate of the PDF417 barcode.
	 */
	public Pdf417BarcodeElement(byte[] value, ElementPlacement placement, int columns, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
		this.columns = columns;
	}

	/**
	 * Initializes a new instance of the <code>Pdf417BarcodeElement</code> class.
	 * 
	 * @param value String to be encoded.
	 * @param columns Columns of the PDF417 barcode.
	 * @param xOffset The X coordinate of the PDF417 barcode.
	 * @param yOffset The Y coordinate of the PDF417 barcode.
	 */
	public Pdf417BarcodeElement(byte[] value, int columns, float xOffset, float yOffset) {
		super(value, ElementPlacement.TOPLEFT, xOffset, yOffset);
		this.columns = columns;
	}
	
	/**
	 * Initializes a new instance of the <code>Pdf417BarcodeElement</code> class.
	 * 
	 * @param value String to be encoded.
	 * @param placement The placement of the barcode on the page.
	 * @param columns Columns of the PDF417 barcode.
	 */
	public Pdf417BarcodeElement(byte[] value, ElementPlacement placement, int columns) {
		this(value, placement, columns, 0, 0);
	}
	
	/**
	 * Initializes a new instance of the <code>Pdf417BarcodeElement</code> class.
	 * 
	 * @param value String to be encoded.
	 * @param columns Columns of the PDF417 barcode.
	 */
	public Pdf417BarcodeElement(byte[] value, int columns) {
		this(value, ElementPlacement.TOPLEFT, columns, 0, 0);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.PDF417BARCODE;
	}

	/**
	 * Gets the columns of the barcode.
	 * @return The columns of the barcode.
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * Sets the columns of the barcode.
	 * @param value The columns of the barcode.
	 */
	public void setColumns(int value) {
		columns = value;
	}

	/**
	 * Gets the YDimension of the barcode.
	 * @return The YDimension of the barcode.
	 */
	@JsonProperty("yDimension")
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getYDimension() {
		return yDimension;
	}

	/**
	 * Sets the YDimension of the barcode.
	 * @param value The YDimension of the barcode.
	 */
	public void setYDimension(float value) {
		yDimension = value;
	}

	/**
	 * Gets a boolean indicating whether to process the tilde character.
	 * @return A boolean indicating whether to process the tilde character.
	 */
	public boolean getProcessTilde() {
		return processTilde;
	}

	/**
	 * Sets a boolean indicating whether to process the tilde character.
	 * @param value A boolean indicating whether to process the tilde character.
	 */
	public void setProcessTilde(boolean value) {
		processTilde = value;
	}

	/**
	 * Gets the Compact Pdf417.
	 * @return The Compact Pdf417.
	 */
	public boolean getCompactPdf417() {
		return compactPdf417;
	}

	/**
	 * Sets the Compact Pdf417.
	 * @param value The Compact Pdf417.
	 */
	public void setCompactPdf417(boolean value) {
		compactPdf417 = value;
	}

	/**
	 * Gets the error correction level for the PDF417 barcode.
	 *
	 * @return Returns a <code>ErrorCorrection</code> object.
	 */
	@JsonProperty("errorCorrection")
	public ErrorCorrection getErrorCorrection() {
		return errorCorrection;
	}

	/**
	 * Sets the error correction level for the PDF417 barcode.
	 * @param value The error correction level for the PDF417 barcode.
	 */
	public void setErrorCorrection(ErrorCorrection value) {
		errorCorrection = value;
	}

	/**
	 * Gets the type of compaction.
	 *
	 * @return a <code>Compaction</code> object.
	 */
	@JsonProperty("compaction")
	public Compaction getCompaction() {
		return compaction;
	}

	/**
	 * Sets the type of compaction.
	 * @param value The type of compaction.
	 */
	public void setCompaction(Compaction value) {
		compaction = value;
	}
}
