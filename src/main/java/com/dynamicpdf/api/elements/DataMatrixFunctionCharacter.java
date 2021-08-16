package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DataMatrixFunctionCharacter {

	@JsonProperty("macro05")
    MACRO05,
    @JsonProperty("macro06")
    MACRO06,
    @JsonProperty("readerProgramming")
    READERPROGRAMMING,
    @JsonProperty("fnc1")
    FNC1,
    @JsonProperty("none")
    NONE

}
