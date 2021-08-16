package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DataMatrixEncodingType {

	@JsonProperty("auto")
    AUTO,
    @JsonProperty("autoAscii")
    AUTOASCII,
    @JsonProperty("ascii")
    ASCII,
    @JsonProperty("extendedAscii")
    EXTENDEDASCII,
    @JsonProperty("doubleDigit")
    DOUBLEDIGIT,
    @JsonProperty("c40")
    C40,
    @JsonProperty("text")
    TEXT,
    @JsonProperty("ansiX12")
    ANSIX12,
    @JsonProperty("edifact")
    EDIFACT,
    @JsonProperty("base256")
    BASE256
}
