package com.dynamicpdf.api.imaging;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the unit of measurement for image size.
 */

 public enum ImageSizeUnit {

	/**
	 * Millimeter unit of measurement.
	 */

	@JsonProperty("Millimeter")
	MILLIMETER,

	/**
	 * Inch unit of measurement.
	 */

	@JsonProperty("Inch")
	INCH,

	/**
	 * Point unit of measurement.
	 */

	@JsonProperty("Point")
	POINT
}

