package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies additional resource type.
 */
public enum AdditionalResourceType {

	/**
	 * Image resource.
	 */
	@JsonProperty("image")
	IMAGE,

	/**
	 * Pdf resource.
	 */
	@JsonProperty("pdf")
	PDF,

	/**
	 * Font resource.
	 */
	@JsonProperty("font")
	FONT,
	
	/**
	 * Html resource.
	 */
	@JsonProperty("html")
	HTML
}
