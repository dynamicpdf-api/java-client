package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Color;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BarcodeElement extends Element {

    private Color color;
    private String colorName;
    private float xDimension;

    BarcodeElement() {
    }

    BarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
    }

    @JsonProperty("color")
    String getColorName() {
        return colorName;
    }

    void ColorName(String value) {
        colorName = value;
    }

    @JsonIgnore
    public Color getColor() {
        return color;
    }

    public void setColor(Color value) {
        color = value;
        colorName = color.getColorString();
    }

    @JsonProperty("xDimension")
    public float getXDimension() {
        return xDimension;
    }

    public void setXDimension(float value) {
        xDimension = value;
    }

    public String getValue() {
        return getInputValue();

    }

    public void setValue(String value) {
        setInputValue(value);
    }

}
