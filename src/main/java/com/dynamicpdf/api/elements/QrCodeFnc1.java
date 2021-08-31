package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type of FNC1 mode to use.
 */
public enum QrCodeFnc1 {

	/**
	 * FNC1 None.
	 */
	@JsonProperty("none")
	NONE,

	/**
	 * FNC1 Gs1.
	 */
	@JsonProperty("gs1")
	GS1,

	/**
	 * FNC1 Industry.
	 */
	@JsonProperty("industry")
	INDUSTRY

}
