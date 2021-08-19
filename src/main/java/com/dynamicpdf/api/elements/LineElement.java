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
public class LineElement extends Element {

    private Color color;
    private LineStyle lineStyle;
    private String colorName = null;
    private float x2Offset;
    private float y2Offset;
    private float width;
    private String lineStyleName;

    public LineElement(ElementPlacement placement, float x2Offset, float y2Offset) {
        setPlacement(placement);
        this.x2Offset = x2Offset;
        this.y2Offset = y2Offset;
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.LINE;
    }

    @JsonProperty("color")
    String getColorName() {
        return colorName;
    }

    void setColorName(String value) {
        colorName = value;
    }

    @JsonProperty("lineStyle")
    String getLineStyleName() {
        return lineStyleName;
    }

    void setLineStyleName(String value) {
        lineStyleName = value;
    }

    @JsonIgnore
    public Color getColor() {
        return color;
    }

    public void setColor(Color value) {
        color = value;
        colorName = color.getColorString();
    }

    public float getX2Offset() {
        return x2Offset;
    }

    public void setX2Offset(float value) {
        x2Offset = value;
    }

    public float getY2Offset() {
        return y2Offset;
    }

    public void setY2Offset(float value) {
        y2Offset = value;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float value) {
        width = value;
    }

    @JsonIgnore
    public LineStyle getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(LineStyle value) {
        lineStyle = value;
        lineStyleName = lineStyle.getLineStyleString();
    }

}
