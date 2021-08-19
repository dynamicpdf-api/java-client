package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OutlineStyle {

	@JsonProperty("bold")
    BOLD,
    @JsonProperty("boldItalic")
	BOLDITALIC,
	@JsonProperty("italic")
	ITALIC,
	@JsonProperty("regular")
	REGULAR
}
