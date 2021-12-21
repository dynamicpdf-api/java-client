package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

//<summary>
/// Specifies additional resource type.
/// </summary>
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
	FONT
}
