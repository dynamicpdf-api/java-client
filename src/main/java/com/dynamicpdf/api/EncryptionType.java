package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies encryption type.
 */
public enum EncryptionType {

    /*
     * RC4 40 bit security.
     */
    @JsonProperty("rc440")
    RC440,

    /*
     * RC4 128 bit security.
     */
    @JsonProperty("rc4128")
    RC4128,

    /*
     * AES 128 bit security.
     */
    @JsonProperty("aes128cbc")
    AES128CBC,

    /*
     * Aes 256 bit security.
     */
    @JsonProperty("aes256cbc")
    AES256CBC,

    /*
     * No security.
     */
    None

}
