package com.dynamicpdf.api.elements;

import java.util.Base64;

public abstract class Dim2BarcodeElement extends BarcodeElement {

    private ValueType valueType = ValueType.STRING;

    Dim2BarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
    }

    Dim2BarcodeElement(byte[] value, ElementPlacement placement, float xOffset, float yOffset) {
        valueType = ValueType.BASE64ENCODEDBYTES;
        setValue(Base64.getEncoder().encodeToString(value));
        setPlacement(placement);
        setXOffset(xOffset);
        setYOffset(yOffset);
    }

    ValueType getValueType() {
        return valueType;
    }

    void setValueType(ValueType value) {
        valueType = value;
    }
}
