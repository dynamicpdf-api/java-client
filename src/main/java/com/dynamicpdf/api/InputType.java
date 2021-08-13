package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum InputType {

	@JsonProperty("pdf")
    PDF,
    @JsonProperty("image")
    IMAGE,
    @JsonProperty("dlex")
    DLEX,
    @JsonProperty("page")
    PAGE;
}
