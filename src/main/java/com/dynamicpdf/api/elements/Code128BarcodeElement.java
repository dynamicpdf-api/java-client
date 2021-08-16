package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class Code128BarcodeElement extends TextBarcodeElement {

    private float height;
    private boolean uccEan128;
    private boolean processTilde;

    public Code128BarcodeElement(String value, ElementPlacement placement, float height, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
        this.height = height;
    }

    public Code128BarcodeElement(String value, ElementPlacement placement, float height) {
        this(value, placement, height, 0, 0);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.CODE128BARCODE;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float value) {
        height = value;
    }

    public boolean getUccEan128() {
        return uccEan128;
    }

    public void setUccEan128(boolean value) {
        uccEan128 = value;
    }

    public boolean getProcessTilde() {
        return processTilde;
    }

    public void setProcessTilde(boolean value) {
        processTilde = value;
    }
}
