package com.dynamicpdf.api.imaging;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum representing compression types.
 */

 public enum CompressionType {

	/**
	 * CCIT Group 3 compression.
	 */

	@JsonProperty("CcitGroup3")
	CCITGROUP3,

	/**
	 * CCIT Group 4 compression.
	 */

	@JsonProperty("CcitGroup4")
	CCITGROUP4,
}