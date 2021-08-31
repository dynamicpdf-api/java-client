package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents page element type.
 */
public enum ElementType {

	/**
	 * Image element.
	 */
	@JsonProperty("image")
	IMAGE,

	/**
	 * Text element.
	 */
	@JsonProperty("text")
	TEXT,

	/**
	 * Page numbering element.
	 */
	@JsonProperty("pageNumbering")
	PAGENUMBERING,

	/**
	 * Code 128 barcode element.
	 */
	@JsonProperty("code128Barcode")
	CODE128BARCODE,

	/**
	 * Code 39 barcode element.
	 */
	@JsonProperty("code39Barcode")
	CODE39BARCODE,

	/**
	 * Code 2 of 5 barcode element.
	 */
	@JsonProperty("code25Barcode")
	CODE25BARCODE,

	/**
	 * Code 93 barcode element.
	 */
	@JsonProperty("code93Barcode")
	CODE93BARCODE,

	/**
	 * Code 11 barcode element.
	 */
	@JsonProperty("code11Barcode")
	CODE11BARCODE,

	/**
	 * GS1 databar barcode element.
	 */
	@JsonProperty("gs1DataBarBarcode")
	GS1DATABARBARCODE,

	/**
	 * IATA 25 barcode element.
	 */
	@JsonProperty("iata25Barcode")
	IATA25BARCODE,

	/**
	 * MSI barcode element.
	 */
	@JsonProperty("msiBarcode")
	MSIBARCODE,

	/**
	 * Stacked GS1 databar barcode element.
	 */
	@JsonProperty("stackedGs1DataBarBarcode")
	STACKEDGS1DATABARBARCODE,

	/**
	 * Aztec barcode element.
	 */
	@JsonProperty("aztecBarcode")
	AZTECBARCODE,

	/**
	 * QR Code barcode element.
	 */
	@JsonProperty("qrCode")
	QRCODE,

	/**
	 * PDF417 barcode element.
	 */
	@JsonProperty("pdf417Barcode")
	PDF417BARCODE,

	/**
	 * Data Matrix barcode element.
	 */
	@JsonProperty("dataMatrixBarcode")
	DATAMATRIXBARCODE,

	/**
	 * Rectangle element.
	 */
	@JsonProperty("rectangle")
	RECTANGLE,

	/**
	 * Line element.
	 */
	@JsonProperty("line")
	LINE
}
