package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Color;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.Resource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class TextBarcodeElement extends BarcodeElement {

    private Color textColor;
    private Font font;
    private String fontName;
    private Resource resource;
    private String textColorName;
    private float fontSize;
    private boolean showText = true;

    TextBarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
    }

    TextBarcodeElement(String value, ElementPlacement placement) {
        this(value, placement, 0, 0);
    }

    @JsonProperty("font")
    String getFontName() {
        return fontName;
    }

    void setFontName(String value) {
        fontName = value;
    }

    @JsonIgnore
    public Font getTextFont() {
        return getFont();
    }

    @JsonIgnore
    public Resource getResource() {
        return resource;
    }

    void setResource(Resource value) {
        resource = value;
    }

    @JsonProperty("textColor")
    String getTextColorName() {
        return textColorName;
    }

    void setTextColorName(String value) {
        textColorName = value;
    }

    @JsonIgnore
    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color value) {
        textColor = value;
        textColorName = textColor.getColorString();
    }

    @JsonIgnore
    public Font getFont() {
        return font;

    }

    public void setFont(Font value) {
        font = value;
        fontName = font.getName();
        resource = font.getResource();
    }

    public float getFontSize() {
        return fontSize;
    }

    public void setFontSize(float value) {
        fontSize = value;
    }

    @JsonInclude
    public boolean getShowText() {
        return showText;
    }

    public void setShowText(boolean value) {
        showText = value;
    }

}
