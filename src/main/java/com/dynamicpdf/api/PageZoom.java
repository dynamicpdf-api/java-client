package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies type of page zoom.
 */

public enum PageZoom {

	/**
	 * RETAIN.
	 */

	@JsonProperty("retain")
	RETAIN,

	/**
	 * FITPAGE.
	 */

	@JsonProperty("fitPage")
	FITPAGE,

	/**
	 * FITWIDTH.
	 */

	@JsonProperty("fitWidth")
	FITWIDTH,

	/**
	 * FITHEIGHT.
	 */

	@JsonProperty("fitHeight")
	FITHEIGHT,

	/**
	 * FITBOX.
	 */

	@JsonProperty("fitBox")
	FITBOX
}
