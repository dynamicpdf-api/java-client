package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents Stacked GS1 DataBar types.
 */
public enum StackedGs1DataBarType {

	/**
	 * Stacked type.
	 */
	@JsonProperty("stacked")
	STACKED,

	/**
	 * Stacked Omnidirectional type.
	 */
	@JsonProperty("stackedOmnidirectional")
	STACKEDOMNIDIRECTIONAL,

	/**
	 * Expanded stacked type.
	 */
	@JsonProperty("expandedStacked")
	EXPANDEDSTACKED
}
