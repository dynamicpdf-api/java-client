package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Color;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.Resource;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class TextElement extends Element {

    private Color color;
    private Font font;
    private String fontName;
    private Resource resource;
    private String colorName;
    private float fontSize;

    public TextElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
    }

    public TextElement(String value, ElementPlacement placement) {
        this(value, placement, 0, 0);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.TEXT;
    }

    @JsonProperty("font")
    String getFontName() {
        return fontName;
    }

    void setFontName(String value) {
        fontName = value;
    }

    @JsonProperty("color")
    String getColorName() {
        return colorName;
    }

    void setColorName(String value) {
        colorName = value;
    }

    @JsonIgnore
    public Resource getResource() {
        return resource;
    }

    void setResource(Resource value) {
        resource = value;
    }

    @JsonIgnore
    public Font getTextFont() {
        return font;
    }

    public String getText() {
        return getInputValue();
    }

    public void setText(String value) {
        setInputValue(value);
    }

    @JsonIgnore
    public Color getColor() {
        return color;
    }

    public void setColor(Color value) {
        color = value;
        colorName = color.getColorString();
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

}
