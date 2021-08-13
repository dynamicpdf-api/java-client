package com.dynamicpdf.api;

import com.dynamicpdf.api.elements.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Template {

    private String id = null;
    private List<Element> elements = new ArrayList<Element>();

    public Template(String id) {
        if (id == null) {
            this.id = UUID.randomUUID().toString();
        } else {
            this.id = id;
        }
    }

    public Template() {
        this(null);
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        id = value;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> value) {
        elements = value;
    }
}
