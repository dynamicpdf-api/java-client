package com.dynamicpdf.api.imaging;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum representing color formats.
 */

public enum ColorFormatType {

	/**
	 * RGB color format.
	 */

	@JsonProperty("Rgb")
	RGB,

	/**
	 * RGBA color format.
	 */

	@JsonProperty("RgbA")
	RGBA,

	/**
	 * Grayscale color format.
	 */

	@JsonProperty("Grayscale")
	GRAYSCALE,

	/**
	 * Monochrome color format.
	 */

	@JsonProperty("Monochrome")
	MONOCHROME,
	
	/**
	 * Indexed color format.
	 */

	@JsonProperty("Indexed")
	INDEXED
}

