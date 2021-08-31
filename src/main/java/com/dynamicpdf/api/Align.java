package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies horizontal alignment. Center alignment is the default value for alignments.
 */

public enum Align {

	/**
	 * Align left.
	 */

	@JsonProperty("left")
	LEFT,

	/**
	 * Align center.
	 */

	@JsonProperty("center")
	CENTER,

	/**
	 * Align right.
	 */

	@JsonProperty("right")
	RIGHT
}
