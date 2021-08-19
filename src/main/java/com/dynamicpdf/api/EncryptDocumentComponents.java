package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EncryptDocumentComponents {

	@JsonProperty("all")
    ALL,
    @JsonProperty("allExceptMetadata")
    ALLEXCEPTMETADATA
}
