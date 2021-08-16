package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum QrCodeFnc1 {

	@JsonProperty("none")
    NONE,
    @JsonProperty("gs1")
    GS1,
    @JsonProperty("industry")
    INDUSTRY

}
