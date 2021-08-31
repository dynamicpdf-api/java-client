package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies vertical alignment.
 */
public enum VAlign {

	/**
	 *  Align top.
	 */
	@JsonProperty("top")
	TOP,

	/**
	 * Align center. This is default.
	 */
	@JsonProperty("center")
	CENTER,

	/**
	 * Align bottom.
	 */
	@JsonProperty("bottom")
	BOTTOM
}
