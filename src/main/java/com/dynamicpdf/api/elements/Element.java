package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.Resource;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Element {

    private ElementType type;
    private Resource resource;
    private String inputValue;
    private Font textFont;
    private ElementPlacement placement;
    private float xOffset;
    private float yOffset;
    private boolean evenPages;
    private boolean oddPages;

    Element() {
    }

    Element(String value, ElementPlacement placement, float xOffset, float yOfset) {
        this.inputValue = value;
        this.placement = placement;
        this.xOffset = xOffset;
        this.yOffset = yOfset;
    }

    Element(String value) {
        inputValue = value;
    }

    abstract ElementType getType();

    public Resource getResource() {
        return null;
    }

    void setResource(Resource value) {
        resource = value;
    }

    String getInputValue() {
        return inputValue;
    }

    void setInputValue(String value) {
        inputValue = value;
    }

    public Font getTextFont() {
        return textFont;
    }

    public ElementPlacement getPlacement() {
        return placement;
    }

    public void setPlacement(ElementPlacement value) {
        placement = value;
    }

    @JsonProperty("xOffset")
    public float getXOffset() {
        return xOffset;
    }

    public void setXOffset(float value) {
        xOffset = value;
    }

    @JsonProperty("yOffset")
    public float getYOffset() {
        return yOffset;
    }

    public void setYOffset(float value) {
        yOffset = value;
    }

    public boolean getEvenPages() {
        return evenPages;
    }

    public void setEvenPages(boolean value) {
        evenPages = value;
    }

    public boolean getOddPages() {
        return oddPages;
    }

    public void setOddPages(boolean value) {
        oddPages = value;
    }
}
