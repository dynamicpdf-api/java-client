package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the Function Character for a Datamatrix barcode.
 */
public enum DataMatrixFunctionCharacter {

	/**
	 * Macro 05 Character.
	 */
	@JsonProperty("macro05")
	MACRO05,

	/**
	 * Macro 06 Character.
	 */
	@JsonProperty("macro06")
	MACRO06,

	/**
	 * ReaderProgramming Character.
	 */
	@JsonProperty("readerProgramming")
	READERPROGRAMMING,

	/**
	 * FNC1 Character.
	 */
	@JsonProperty("fnc1")
	FNC1,

	/**
	 * None.
	 */
	@JsonProperty("none")
	NONE

}
