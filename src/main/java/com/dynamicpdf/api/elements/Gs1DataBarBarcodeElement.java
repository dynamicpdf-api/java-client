package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class Gs1DataBarBarcodeElement extends TextBarcodeElement {

    private Gs1DataBarType type;
    private float height;

    public Gs1DataBarBarcodeElement(String value, ElementPlacement placement, float height, Gs1DataBarType type, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
        this.type = type;
        this.height = height;
    }

    public Gs1DataBarBarcodeElement(String value, ElementPlacement placement, float height, Gs1DataBarType type) {
        this(value, placement, height, type, 0, 0);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.Gs1DataBarBarcode;
    }

    Gs1DataBarType getGs1DataBarType() {
        return type;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float value) {
        height = value;
    }
}
