package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RC4128Security extends Security {

    private boolean encryptMetadata = true;

    public RC4128Security(String userPassword, String ownerPassword) {
        super(userPassword, ownerPassword);
    }

    SecurityType getType() {
        return SecurityType.RC4128;
    }

    public boolean getEncryptMetadata() {
        return encryptMetadata;
    }
}
