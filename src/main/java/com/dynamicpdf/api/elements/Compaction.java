package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Compaction {

	@JsonProperty("byte")
    BYTE,
    @JsonProperty("text")
    TEXT,
    @JsonProperty("numeric")
    NUMERIC,
    @JsonProperty("automatic")
    AUTOMATIC
}
