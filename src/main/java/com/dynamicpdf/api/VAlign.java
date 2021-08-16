package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum VAlign {

	@JsonProperty("top")
    TOP,
    @JsonProperty("center")
    CENTER,
    @JsonProperty("bottom")
    BOTTOM
}
