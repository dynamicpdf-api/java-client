package com.dynamicpdf.api;

public class ChoiceFieldInformation {

    private String name;
    private ChoiceFieldType type;
    private String value;
    private String defaultValue;
    private String exportValue;
    private String[] items;
    private String[] itemExportValues;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public ChoiceFieldType getType() {
        return type;
    }

    public void setType(ChoiceFieldType value) {
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

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] value) {
        items = value;
    }

    public String[] getItemExportValues() {
        return itemExportValues;
    }

    public void setItemExportValues(String[] value) {
        itemExportValues = value;
    }
}
