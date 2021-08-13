package com.dynamicpdf.api;

public class ButtonFieldInformation {

    private String name;
    private ButtonFieldType type;
    private String value;
    private String defaultValue;
    private String exportValue;
    private String[] exportValues;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public ButtonFieldType getType() {
        return type;
    }

    public void setType(ButtonFieldType value) {
        type = value;
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

    public String getExportValue() {
        return exportValue;
    }

    public void setExportValue(String value) {
        exportValue = value;
    }

    public String[] getExportValues() {
        return exportValues;
    }

    public void setExportValues(String[] value) {
        exportValues = value;
    }
}
