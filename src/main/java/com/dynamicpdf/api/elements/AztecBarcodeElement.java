package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class AztecBarcodeElement extends Dim2BarcodeElement {

    private boolean processTilde;
    private AztecSymbolSize aztecSymbolSize;
    private int errorCorrection;
    private boolean readerInitializationSymbol;

    public AztecBarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
    }

    public AztecBarcodeElement(String value, ElementPlacement placement) {
        this(value, placement, 0, 0);
    }

    public AztecBarcodeElement(byte[] value, ElementPlacement placement, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
    }

    public AztecBarcodeElement(byte[] value, ElementPlacement placement) {
        this(value, placement, 0, 0);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.AztecBarcode;
    }

    public boolean getProcessTilde() {
        return processTilde;
    }

    public void setProcessTilde(boolean value) {
        processTilde = value;
    }

    public AztecSymbolSize getAztecSymbolSize() {
        return aztecSymbolSize;
    }

    public void setAztecSymbolSize(AztecSymbolSize value) {
        aztecSymbolSize = value;
    }

    public int getErrorCorrection() {
        return errorCorrection;
    }

    public void setErrorCorrection(int value) {
        errorCorrection = value;
    }

    public boolean getReaderInitializationSymbol() {
        return readerInitializationSymbol;
    }

    public void setReaderInitializationSymbol(boolean value) {
        readerInitializationSymbol = value;
    }

}
