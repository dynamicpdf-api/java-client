package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents an Aztec barcode element.
 * 
 * <p>With some of the .Net runtimes (example: .Net Core 2.0) the ECI values 20, 28, 29 and 30 will give the error "No data is available 
 * for encoding 'code page number'. For information on defining a custom encoding, see the documentation for the Encoding.RegisterProvider method.".</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class AztecBarcodeElement extends Dim2BarcodeElement {

	private boolean processTilde;
	private AztecSymbolSize aztecSymbolSize;
	private int errorCorrection;
	private boolean readerInitializationSymbol;

	/**
	 *  Initializes a new instance of the <code>AztecBarcodeElement</code> class.
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 */
	public AztecBarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
	}

	/**
	 * Initializes a new instance of the <code>AztecBarcodeElement</code> class.
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 */
	public AztecBarcodeElement(String value, ElementPlacement placement) {
		this(value, placement, 0, 0);
	}

	/**
	 * Initializes a new instance of the <code>AztecBarcodeElement</code> class.
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode.
	 */
	public AztecBarcodeElement(byte[] value, ElementPlacement placement, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
	}

	/**
	 * Initializes a new instance of the <code>AztecBarcodeElement</code> class.
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 */
	public AztecBarcodeElement(byte[] value, ElementPlacement placement) {
		this(value, placement, 0, 0);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.AZTECBARCODE;
	}

	/**
	 * Gets a boolean indicating whether to process tilde symbol in the input.
	 * 
	 * <p>Setting <b>true</b> will check for ~ character and processes it for FNC1 or ECI characters.
	 * @return A boolean indicating whether to process tilde symbol in the input.
	 */
	public boolean getProcessTilde() {
		return processTilde;
	}

	/**
	 * Sets a boolean indicating whether to process tilde symbol in the input.
	 * 
	 * <p>Setting <b>true</b> will check for ~ character and processes it for FNC1 or ECI characters.
	 * @param value A boolean indicating whether to process tilde symbol in the input.
	 */
	public void setProcessTilde(boolean value) {
		processTilde = value;
	}

	/**
	 * Gets the barcode size, @see AztecSymbolSize.
	 * @return The barcode size, @see AztecSymbolSize.
	 */
	@JsonProperty("symbolSize")
	public AztecSymbolSize getSymbolSize() {
		return aztecSymbolSize;
	}

	/**
	 * Sets the barcode size, @see AztecSymbolSize.
	 * @param value The barcode size, @see AztecSymbolSize.
	 */
	public void setSymbolSize(AztecSymbolSize value) {
		aztecSymbolSize = value;
	}

	/**
	 * Gets the error correction value.
	 * 
	 * <p> Error correction value may be between 5% to 95%.</p>
	 * @return The error correction value.
	 */
	public int getAztecErrorCorrection() {
		return errorCorrection;
	}

	/**
	 * Sets the error correction value.
	 *
	 * <p> Error correction value may be between 5% to 95%.</p>
	 * @param value The error correction value.
	 */
	public void setAztecErrorCorrection(int value) {
		errorCorrection = value;
	}

	/**
	 * Gets a boolean representing if the barcode is a reader initialization symbol. 
	 * 
	 * <p>Setting <b>true</b> will mark the symbol as reader initialization symbol
	 * and the size of the symbol should be one of the following, R15xC15 Compact, R19xC19, R23xC23, R27xC27, R31xC31, R37xC37, R41xC41, R45xC45, R49xC49, R53xC53, R57xC57, R61xC61, R67xC67, R71xC71, R75xC75,
	 * R79xC79, R83xC83, R87xC87, R91xC91, R95xC95, R101xC101, R105xC105, R109xC109, however it is recommended to set Auto.</p>
	 * @return A boolean representing if the barcode is a reader initialization symbol. 
	 */
	public boolean getReaderInitializationSymbol() {
		return readerInitializationSymbol;
	}

	/**
	 * Sets a boolean representing if the barcode is a reader initialization symbol. 
	 * 
	 * <p>Setting <b>true</b> will mark the symbol as reader initialization symbol
	 * and the size of the symbol should be one of the following, R15xC15 Compact, R19xC19, R23xC23, R27xC27, R31xC31, R37xC37, R41xC41, R45xC45, R49xC49, R53xC53, R57xC57, R61xC61, R67xC67, R71xC71, R75xC75,
	 * R79xC79, R83xC83, R87xC87, R91xC91, R95xC95, R101xC101, R105xC105, R109xC109, however it is recommended to set Auto.</p>
	 * @param value A boolean representing if the barcode is a reader initialization symbol. 
	 */
	public void setReaderInitializationSymbol(boolean value) {
		readerInitializationSymbol = value;
	}

}
