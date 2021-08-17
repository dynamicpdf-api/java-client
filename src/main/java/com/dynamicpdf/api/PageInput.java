/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dynamicpdf.api;

import com.dynamicpdf.api.elements.Element;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(Include.NON_DEFAULT)
public class PageInput extends Input {

    private float pageWidth = 0;
    private float pageHeight = 0;

    private List<Element> elements = null;

    public PageInput(float pageWidth, float pageHeight) {
        this.pageWidth = pageWidth;
        this.pageHeight = pageHeight;
    }

    public PageInput() {
    	super();
    }

    @JsonInclude
    @JsonProperty("type")
    InputType getType() {
        return InputType.PAGE;
    }

    public float getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(float value) {
        pageWidth = value;
    }

    public float getPageHeight() {
        return pageHeight;
    }

    public void setPageHeight(float value) {
        pageHeight = value;
    }

    public List<Element> getElements() {
        if (elements == null) {
            elements = new ArrayList<Element>();
        }
        return elements;
    }
}
