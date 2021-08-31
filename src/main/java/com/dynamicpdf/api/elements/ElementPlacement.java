package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the placement of a page element.
 */
public enum ElementPlacement {

	/**
	 * Represents top left placement.
	 */
	@JsonProperty("topLeft")
	TOPLEFT,

	/**
	 * Represents top center placement.
	 */
	@JsonProperty("topCenter")
	TOPCENTER,

	/**
	 * Represents top right placement.
	 */
	@JsonProperty("topRight")
	TOPRIGHT,

	/**
	 * Represents bottom left placement.
	 */
	@JsonProperty("bottomLeft")
	BOTTOMLEFT,

	/**
	 * Represents bottom center placement.
	 */
	@JsonProperty("bottomCenter")
	BOTTOMCENTER,

	/**
	 * Represents bottom right placement.
	 */
	@JsonProperty("bottomRight")
	BOTTOMRIGHT
}
