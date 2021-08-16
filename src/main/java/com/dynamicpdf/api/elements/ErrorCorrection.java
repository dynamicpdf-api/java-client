package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ErrorCorrection {

	@JsonProperty("level0")
    LEVEL0,
    @JsonProperty("level1")
    LEVEL1,
    @JsonProperty("level2")
    LEVEL2,
    @JsonProperty("level3")
    LEVEL3,
    @JsonProperty("level4")
    LEVEL4,
    @JsonProperty("level5")
    LEVEL5,
    @JsonProperty("level6")
    LEVEL6,
    @JsonProperty("level7")
    LEVEL7,
    @JsonProperty("level8")
    LEVEL8,
    @JsonProperty("auto")
    AUTO
}
