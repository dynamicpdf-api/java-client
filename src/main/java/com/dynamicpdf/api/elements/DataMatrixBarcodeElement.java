package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents a Data Matrix  barcode element.
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class DataMatrixBarcodeElement extends Dim2BarcodeElement {

	private boolean processTilde;
	private DataMatrixSymbolSize dataMatrixSymbolSize;
	private DataMatrixEncodingType dataMatrixEncodingType;
	private DataMatrixFunctionCharacter dataMatrixFunctionCharacter;

	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 * @param symbolSize The symbol size of the barcode.
	 * @param encodingType The encoding type of the barcode.
	 * @param functionCharacter The function character of the barcode.
	 */
	public DataMatrixBarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset, DataMatrixSymbolSize symbolSize, DataMatrixEncodingType encodingType, DataMatrixFunctionCharacter functionCharacter) {
		super(value, placement, xOffset, yOffset);

		this.dataMatrixSymbolSize = symbolSize;
		this.dataMatrixEncodingType = encodingType;
		this.dataMatrixFunctionCharacter = functionCharacter;
	}

	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 */
	public DataMatrixBarcodeElement(String value, ElementPlacement placement) {
		this(value, placement, 0, 0, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.NONE);
	}

	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 */
	public DataMatrixBarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
		this(value, placement, xOffset, yOffset, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.NONE);
	}
	
	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 */
	public DataMatrixBarcodeElement(String value, float xOffset, float yOffset) {
		this(value, ElementPlacement.TOPLEFT, xOffset, yOffset, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.NONE);
	}

	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 * @param symbolSize The symbol size of the barcode.
	 */
	public DataMatrixBarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset, DataMatrixSymbolSize symbolSize) {
		this(value, placement, xOffset, yOffset, symbolSize, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.NONE);
	}

	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 * @param symbolSize The symbol size of the barcode.
	 * @param encodingType The encoding type of the barcode.
	 */
	public DataMatrixBarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset, DataMatrixSymbolSize symbolSize, DataMatrixEncodingType encodingType) {
		this(value, placement, xOffset, yOffset, symbolSize, encodingType, DataMatrixFunctionCharacter.NONE);
	}

	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 * @param symbolSize The symbol size of the barcode.
	 * @param encodingType The encoding type of the barcode.
	 * @param functionCharacter The function character of the barcode.
	 */
	public DataMatrixBarcodeElement(byte[] value, ElementPlacement placement, float xOffset, float yOffset, DataMatrixSymbolSize symbolSize, DataMatrixEncodingType encodingType, DataMatrixFunctionCharacter functionCharacter) {
		super(value, placement, xOffset, yOffset);

		this.dataMatrixSymbolSize = symbolSize;
		this.dataMatrixEncodingType = encodingType;
		this.dataMatrixFunctionCharacter = functionCharacter;
	}

	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 */
	public DataMatrixBarcodeElement(byte[] value, ElementPlacement placement) {
		this(value, placement, 0, 0, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.NONE);
	}

	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 */
	public DataMatrixBarcodeElement(byte[] value, ElementPlacement placement, float xOffset, float yOffset) {
		this(value, placement, xOffset, yOffset, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.NONE);
	}
	
	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 */
	public DataMatrixBarcodeElement(byte[] value, float xOffset, float yOffset) {
		this(value, ElementPlacement.TOPLEFT, xOffset, yOffset, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.NONE);
	}

	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 * @param symbolSize The symbol size of the barcode.
	 */
	public DataMatrixBarcodeElement(byte[] value, ElementPlacement placement, float xOffset, float yOffset, DataMatrixSymbolSize symbolSize) {
		this(value, placement, xOffset, yOffset, symbolSize, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.NONE);
	}

	/**
	 * Initializes a new instance of the <code>DataMatrixBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 * @param symbolSize The symbol size of the barcode.
	 * @param encodingType The encoding type of the barcode.
	 */
	public DataMatrixBarcodeElement(byte[] value, ElementPlacement placement, float xOffset, float yOffset, DataMatrixSymbolSize symbolSize, DataMatrixEncodingType encodingType) {
		this(value, placement, xOffset, yOffset, symbolSize, encodingType, DataMatrixFunctionCharacter.NONE);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.DATAMATRIXBARCODE;
	}

	/**
	 * Gets whether to process tilde character.
	 * 
	 * <p>Setting <b>true</b> will check for ~ character and processes it for FNC1 or ECI characters.
	 * @return Whether to process tilde character.
	 */
	public boolean getProcessTilde() {
		return processTilde;
	}

	/**
	 * Sets whether to process tilde character.
	 * 
	 * <p>Setting <b>true</b> will check for ~ character and processes it for FNC1 or ECI characters.
	 * @param value Whether to process tilde character.
	 */
	public void setProcessTilde(boolean value) {
		processTilde = value;
	}

	@JsonProperty("dataMatrixSymbolSize")
	DataMatrixSymbolSize getDataMatrixSymbolSize() {
		return dataMatrixSymbolSize;
	}

	void setDataMatrixSymbolSize(DataMatrixSymbolSize value) {
		dataMatrixSymbolSize = value;
	}

	@JsonProperty("dataMatrixEncodingType")
	DataMatrixEncodingType getDataMatrixEncodingType() {
		return dataMatrixEncodingType;
	}

	void setDataMatrixEncodingType(DataMatrixEncodingType value) {
		dataMatrixEncodingType = value;
	}

	@JsonProperty("dataMatrixFunctionCharacter")
	DataMatrixFunctionCharacter getDataMatrixFunctionCharacter() {
		return dataMatrixFunctionCharacter;
	}

	void setDataMatrixFunctionCharacter(DataMatrixFunctionCharacter value) {
		dataMatrixFunctionCharacter = value;
	}

}
