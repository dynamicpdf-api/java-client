package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Color;
import com.dynamicpdf.api.LineStyle;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class RectangleElement extends Element {

    private Color fillColor;
    private Color borderColor;
    private LineStyle borderStyle;
    private float width;
    private float height;
    private float borderWidth;
    private float cornerRadius;
    private String fillColorName;
    private String borderColorName;

    private String borderStyleName;

    public RectangleElement(ElementPlacement placement, float width, float height) {
        setPlacement(placement);
        this.width = width;
        this.height = height;
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.RECTANGLE;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float value) {
        width = value;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float value) {
        height = value;
    }

    public float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(float value) {
        borderWidth = value;
    }

    public float getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(float value) {
        cornerRadius = value;
    }

    @JsonProperty("fillColor")
    String getFillColorName() {
        return fillColorName;
    }

    void setFillColorName(String value) {
        fillColorName = value;
    }

    @JsonProperty("borderColor")
    String getBorderColorName() {
        return borderColorName;
    }

    void setBorderColorName(String value) {
        borderColorName = value;
    }

    @JsonProperty("borderStyle")
    String getBorderStyleName() {
        return borderStyleName;
    }

    void setBorderStyleName(String value) {
        borderStyleName = value;
    }

    @JsonIgnore
    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color value) {
        fillColor = value;
        fillColorName = fillColor.getColorString();
    }

    @JsonIgnore
    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color value) {
        borderColor = value;
        borderColorName = borderColor.getColorString();
    }

    @JsonIgnore
    public LineStyle getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(LineStyle value) {
        borderStyle = value;
        borderStyleName = borderStyle.getLineStyleString();
    }
}
