package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MSI Barcode check digit modes.
 */
public enum MsiBarcodeCheckDigitMode {

	/**
	 * No check digit.
	 */
	@JsonProperty("none")
	NONE,

	/**
	 * check digit of mod 10.
	 */
	@JsonProperty("mod10")
	MOD10,

	/**
	 * check digit of mod 11.
	 */
	@JsonProperty("mod11")
	MOD11,

	/**
	 * check digit of mod 1010.
	 */
	@JsonProperty("mod1010")
	MOD1010,

	/**
	 * check digit of mod 1110.
	 */
	@JsonProperty("mod1110")
	MOD1110
}
