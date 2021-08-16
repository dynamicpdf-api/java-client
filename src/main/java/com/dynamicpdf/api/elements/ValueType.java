package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ValueType {

	@JsonProperty("string")
    STRING,
    @JsonProperty("base64EncodedBytes")
    BASE64ENCODEDBYTES
}
