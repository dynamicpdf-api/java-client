package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ElementPlacement {

	@JsonProperty("topLeft")
    TOPLEFT,
    @JsonProperty("topCenter")
    TOPCENTER,
    @JsonProperty("topRight")
    TOPRIGHT,
    @JsonProperty("bottomLeft")
    BOTTOMLEFT,
    @JsonProperty("bottomCenter")
    BOTTOMCENTER,
    @JsonProperty("bottomRight")
    BOTTOMRIGHT
}
