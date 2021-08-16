package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StackedGs1DataBarType {

	@JsonProperty("stacked")
    STACKED,
    @JsonProperty("stackedOmnidirectional")
    STACKEDOMNIDIRECTIONAL,
    @JsonProperty("expandedStacked")
    EXPANDEDSTACKED
}
