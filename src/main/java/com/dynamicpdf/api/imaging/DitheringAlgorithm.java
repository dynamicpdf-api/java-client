package com.dynamicpdf.api.imaging;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum representing dithering algorithms.
 */

 public enum DitheringAlgorithm {

	/**
	 * Floyd-Steinberg dithering algorithm.
	 */

	@JsonProperty("FloydSteinberg")
	FLOYDSTEINBERG,

	/**
	 * Bayer dithering algorithm.
	 */

	@JsonProperty("Bayer")
	BAYER,

	/**
	 * No dithering.
	 */

	@JsonProperty("None")
	NONE
}

