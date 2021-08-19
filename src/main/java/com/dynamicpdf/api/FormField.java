package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class FormField {

    private String name;
    private String value = null;
    private boolean flatten;
    private boolean remove;

    public FormField(String name) {
        this.name = name;
    }

    public FormField(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getFlatten() {
        return flatten;
    }

    public void setFlatten(boolean value) {
        flatten = value;
    }

    public boolean getRemove() {
        return remove;
    }

    public void setRemove(boolean value) {
        remove = value;
    }

}
