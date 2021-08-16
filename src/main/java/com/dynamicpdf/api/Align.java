package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Align {

	@JsonProperty("left")
    LEFT,
    @JsonProperty("center")
    CENTER,
    @JsonProperty("right")
    RIGHT
}
