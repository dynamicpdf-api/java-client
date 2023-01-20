package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents different types of the page orientation.
 */

public enum PageOrientation {

	/**
	 * Page Orientation of portrait.
	 */
	@JsonProperty("portrait")
    PORTRAIT,

    /**
	 * Page Orientation of landscape.
	 */
	@JsonProperty("landscape")
    LANDSCAPE,
}
