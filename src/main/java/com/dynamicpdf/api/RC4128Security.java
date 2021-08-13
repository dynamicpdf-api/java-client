package com.dynamicpdf.api;

public class RC4128Security extends Security {

    private boolean encryptMetadata;

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
