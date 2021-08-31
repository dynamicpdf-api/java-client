package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type of Compaction to encode.
 */
public enum Compaction {

	/**
	 * Byte Compaction.
	 */
	@JsonProperty("byte")
	BYTE,

	/**
	 * Text Compaction.
	 */
	@JsonProperty("text")
	TEXT,

	/**
	 * Numeric Compaction.
	 */
	@JsonProperty("numeric")
	NUMERIC,

	/**
	 * All Compactions.
	 */
	@JsonProperty("auto")
	AUTO
}
