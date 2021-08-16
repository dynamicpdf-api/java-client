package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SecurityType {

	@JsonProperty("aes128")
    AES128,
    @JsonProperty("aes256")
    AES256,
    @JsonProperty("rc4128")
    RC4128
}
