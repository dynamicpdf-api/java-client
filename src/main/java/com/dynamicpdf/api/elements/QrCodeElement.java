package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class QrCodeElement extends Dim2BarcodeElement {

    private QrCodeFnc1 fnc1 = null;
    private int version;

    public QrCodeElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
    }

    public QrCodeElement(String value, ElementPlacement placement) {
        this(value, placement, 0, 0);
    }

    public QrCodeElement(byte[] value, ElementPlacement placement, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
    }

    public QrCodeElement(byte[] value, ElementPlacement placement) {
        this(value, placement, 0, 0);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.QRCODE;
    }

    @JsonProperty("fnc1")
    public QrCodeFnc1 getFnc1() {
        return fnc1;
    }

    public void setFnc1(QrCodeFnc1 value) { 
        fnc1 = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        version = value;
    }
}
