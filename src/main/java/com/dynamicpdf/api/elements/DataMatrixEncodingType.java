package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies EncodingType for Datamatrix barcodes.
 */
public enum DataMatrixEncodingType {

	/**
	 * Calculates Encoding based on Value.
	 */
	@JsonProperty("auto")
	AUTO,

	/**
	 * Calculates ASCII Encoding based on Value.
	 */
	@JsonProperty("autoAscii")
	AUTOASCII,

	/**
	 * ASCII Encoding.
	 */
	@JsonProperty("ascii")
	ASCII,

	/**
	 * Extended ASCII Encoding.
	 */
	@JsonProperty("extendedAscii")
	EXTENDEDASCII,

	/**
	 * Double digit Encoding.
	 */
	@JsonProperty("doubleDigit")
	DOUBLEDIGIT,

	/**
	 * C40 Encoding.
	 */
	@JsonProperty("c40")
	C40,

	/**
	 * Text Encoding.
	 */
	@JsonProperty("text")
	TEXT,

	/**
	 * ANSI X12 Encoding.
	 */
	@JsonProperty("ansiX12")
	ANSIX12,

	/**
	 * EDIFACT Encoding.
	 */
	@JsonProperty("edifact")
	EDIFACT,

	/**
	 * Base256 Encoding.
	 */
	@JsonProperty("base256")
	BASE256
}
