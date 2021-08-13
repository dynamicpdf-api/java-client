package com.dynamicpdf.api;

public class SignatureFieldInformation {

    private String name;
    private boolean signed;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public boolean getSigned() {
        return signed;
    }

    public void setSigned(boolean value) {
        signed = value;
    }
}
