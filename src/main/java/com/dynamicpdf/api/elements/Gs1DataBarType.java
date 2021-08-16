package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Gs1DataBarType {

	@JsonProperty("omnidirectional")
    OMNIDIRECTIONAL,
    @JsonProperty("limited")
    LIMITED,
    @JsonProperty("expanded")
    EXPANDED
}
