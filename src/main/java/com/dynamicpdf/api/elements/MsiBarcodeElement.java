package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class MsiBarcodeElement extends TextBarcodeElement {

    private MsiBarcodeCheckDigitMode appendCheckDigit = null;
    private float height;

    public MsiBarcodeElement(String value, ElementPlacement placement, float height, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
        this.height = height;
    }

    public MsiBarcodeElement(String value, ElementPlacement placement, float height) {
        this(value, placement, height, 0, 0);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.MSIBARCODE;
    }

    public MsiBarcodeCheckDigitMode getAppendCheckDigit() {
        return appendCheckDigit;
    }

    public void setAppendCheckDigit(MsiBarcodeCheckDigitMode value) {
        appendCheckDigit = value;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float value) {
        height = value;
    }

}
