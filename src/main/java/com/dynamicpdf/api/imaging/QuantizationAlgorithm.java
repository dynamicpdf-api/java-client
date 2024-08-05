package com.dynamicpdf.api.imaging;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum representing quantization algorithms.
 */

public enum QuantizationAlgorithm {

	/**
	 * Octree quantization algorithm.
	 */

	@JsonProperty("Octree")
	OCTREE,

	/**
	 * Web-safe color quantization algorithm.
	 */

	@JsonProperty("WebSafe")
	WEBSAFE,

	/**
	 * Werner quantization algorithm.
	 */

	@JsonProperty("Werner")
	WERNER,

	/**
	 * Wu quantization algorithm.
	 */
	WU
}

