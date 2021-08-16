package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MsiBarcodeCheckDigitMode {

	@JsonProperty("none")
    NONE,
    @JsonProperty("mod10")
    MOD10,
    @JsonProperty("mod11")
    MOD11,
    @JsonProperty("mod1010")
    MOD1010,
    @JsonProperty("mod1110")
    MOD1110
}
