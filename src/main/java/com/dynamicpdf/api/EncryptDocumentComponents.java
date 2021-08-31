package com.dynamicpdf.api;

/**
 * Specifies the document components to be encrypted. 
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EncryptDocumentComponents {

	@JsonProperty("all")

	/**
	 * Encrypts all document contents.
	 */

	ALL,
	@JsonProperty("allExceptMetadata")

	/**
	 * Encrypts all document contents except metadata.
	 */

	ALLEXCEPTMETADATA
}
