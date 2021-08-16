package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class Code11BarcodeElement extends TextBarcodeElement {

    private float height;

    public Code11BarcodeElement(String value, ElementPlacement placement, float height, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
        this.height = height;
    }

    public Code11BarcodeElement(String value, ElementPlacement placement, float height) {
        this(value, placement, height, 0, 0);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.CODE11BARCODE;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float value) {
        height = value;
    }
}
