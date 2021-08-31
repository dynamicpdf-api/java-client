package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents different types of the security.
 */
public enum SecurityType {

	/**
	 * AES 128 bit security.
	 */
	@JsonProperty("aes128")
	AES128,

	/**
	 * AES 256 bit security.
	 */
	@JsonProperty("aes256")
	AES256,

	/**
	 * RC4 128 bit security.
	 */
	@JsonProperty("rc4128")
	RC4128
}
