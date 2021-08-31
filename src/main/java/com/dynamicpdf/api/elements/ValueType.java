package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents value type.
 */
public enum ValueType {

	/**
	 * String.
	 */
	@JsonProperty("string")
	STRING,

	/**
	 * Base 64 encoded byte array.
	 */
	@JsonProperty("base64EncodedBytes")
	BASE64ENCODEDBYTES
}
