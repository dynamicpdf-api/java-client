package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The level of error correction to use in a barcode.
 */
public enum ErrorCorrection {

	/**
	 * Error Correction Level 0.
	 */
	@JsonProperty("level0")
	LEVEL0,

	/**
	 * Error Correction Level 1.
	 */
	@JsonProperty("level1")
	LEVEL1,

	/**
	 * Error Correction Level 2.
	 */
	@JsonProperty("level2")
	LEVEL2,

	/**
	 * Error Correction Level 3.
	 */
	@JsonProperty("level3")
	LEVEL3,

	/**
	 * Error Correction Level 4.
	 */
	@JsonProperty("level4")
	LEVEL4,

	/**
	 * Error Correction Level 5.
	 */
	@JsonProperty("level5")
	LEVEL5,

	/**
	 * Error Correction Level 6.
	 */
	@JsonProperty("level6")
	LEVEL6,

	/**
	 * Error Correction Level 7.
	 */
	@JsonProperty("level7")
	LEVEL7,

	/**
	 * Error Correction Level 8.
	 */
	@JsonProperty("level8")
	LEVEL8,

	/**
	 * Error Correction Auto.
	 */
	@JsonProperty("auto")
	AUTO
}
