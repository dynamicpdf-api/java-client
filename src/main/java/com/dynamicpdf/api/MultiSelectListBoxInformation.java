package com.dynamicpdf.api;

public class MultiSelectListBoxInformation {

    private String name;
    private String[] values;
    private String[] defaultValues;
    private String[] exportValues;
    private String[] items;
    private String[] itemsExportValues;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] value) {
        values = value;
    }

    public String[] getDefaultValues() {
        return defaultValues;
    }

    public void setDefaultValues(String[] value) {
        defaultValues = value;
    }

    public String[] getExportValues() {
        return exportValues;
    }

    public void setExportValues(String[] value) {
        exportValues = value;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] value) {
        items = value;
    }

    public String[] getItemsExportValues() {
        return itemsExportValues;
    }

    public void setItemsExportValues(String[] value) {
        itemsExportValues = value;
    }
}
