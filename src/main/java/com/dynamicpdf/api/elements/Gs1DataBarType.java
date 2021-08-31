package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents GS1 DataBar types.
 */
public enum Gs1DataBarType {

	/**
	 * Omnidirectional GS1 DataBar type.
	 */
	@JsonProperty("omnidirectional")
	OMNIDIRECTIONAL,

	/**
	 * Limited GS1 DataBar type.
	 */
	@JsonProperty("limited")
	LIMITED,

	/**
	 * Expanded GS1 DataBar type.
	 */
	@JsonProperty("expanded")
	EXPANDED
}
