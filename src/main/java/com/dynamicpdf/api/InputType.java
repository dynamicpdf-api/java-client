package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies an input type.
 */

public enum InputType {

	/**
	 * Pdf input.
	 */

	@JsonProperty("pdf")
	PDF,

	/**
	 * IMAGE input.
	 */

	@JsonProperty("image")
	IMAGE,

	/**
	 * DLEX input.
	 */

	@JsonProperty("dlex")
	DLEX,

	/**
	 * PAGE input.
	 */

	@JsonProperty("page")
	PAGE,
	
	/**
	 * HTML input.
	 */

	@JsonProperty("html")
	HTML
}
