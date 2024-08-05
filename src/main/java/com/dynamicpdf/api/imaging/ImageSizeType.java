package com.dynamicpdf.api.imaging;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the type of image size.
 */

 public enum ImageSizeType {

	/**
	 * DPI-based image size.
	 */

	@JsonProperty("Dpi")
	DPI,

	/**
	 * Fixed image size.
	 */

	@JsonProperty("Fixed")
	FIXED,

	/**
	 * Image size that fits within a given maximum size.
	 */

	@JsonProperty("Max")
	MAX,

	/**
	 * Percentage-based image size.
	 */

	@JsonProperty("Percentage")
	PERCENTAGE
}
