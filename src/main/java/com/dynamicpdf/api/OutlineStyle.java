package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the style of the outline.
 */

public enum OutlineStyle {

	/**
	 * Bold.
	 */

	@JsonProperty("bold")
	BOLD,

	/**
	 * BOLDITALIC.
	 */

	@JsonProperty("boldItalic")
	BOLDITALIC,

	/**
	 * ITALIC.
	 */

	@JsonProperty("italic")
	ITALIC,

	/**
	 * REGULAR.
	 */

	@JsonProperty("regular")
	REGULAR
}
