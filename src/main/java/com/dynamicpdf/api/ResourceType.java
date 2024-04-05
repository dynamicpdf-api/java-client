package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies resource type.
 */
public enum ResourceType {

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
	 * LayoutData resource.
	 */
	@JsonProperty("layoutData")
	LAYOUTDATA,

	/**
	 * Dlex resource.
	 */
	@JsonProperty("dlex")
	DLEX,

	/**
	 * Font resource.
	 */
	@JsonProperty("font")
	FONT,
	
	/**
	 * Html resource.
	 */
	@JsonProperty("html")
	HTML,
	
	/**
	 * Word resource.
	 */
	@JsonProperty("word")
    WORD,

	/**
	 * Excel resource.
	 */
	@JsonProperty("excel")
    EXCEL
}
