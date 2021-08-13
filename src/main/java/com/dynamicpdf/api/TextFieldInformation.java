package com.dynamicpdf.api;

public class TextFieldInformation {

    private String name;
    private String value;
    private String defaultValue;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String value) {
        defaultValue = value;
    }
}
