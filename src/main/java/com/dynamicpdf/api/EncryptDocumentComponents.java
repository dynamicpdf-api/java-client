package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the document components to be encrypted.
 */
public enum EncryptDocumentComponents {

    /**
     * Encrypts all document contents.
     */
    @JsonProperty("all")
    ALL,
    
    /**
     * Encrypts all document contents except metadata.
     */
    @JsonProperty("allExceptMetadata")
    ALLEXCEPTMETADATA
}
