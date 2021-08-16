package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class Pdf417BarcodeElement extends Dim2BarcodeElement {

    private int columns;
    private float yDimension;
    private boolean processTilde;
    private boolean compactPdf417;
    private ErrorCorrection errorCorrection;
    private Compaction compaction;

    public Pdf417BarcodeElement(String value, ElementPlacement placement, int columns, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
        this.columns = columns;
    }

    public Pdf417BarcodeElement(String value, ElementPlacement placement, int columns) {
        this(value, placement, columns, 0, 0);
    }

    public Pdf417BarcodeElement(byte[] value, ElementPlacement placement, int columns, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
        this.columns = columns;
    }

    public Pdf417BarcodeElement(byte[] value, ElementPlacement placement, int columns) {
        this(value, placement, columns, 0, 0);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.PDF417BARCODE;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int value) {
        columns = value;
    }

    @JsonProperty("yDimension")
    public float getYDimension() {
        return yDimension;
    }

    public void setYDimension(float value) {
        yDimension = value;
    }

    public boolean getProcessTilde() {
        return processTilde;
    }

    public void setProcessTilde(boolean value) {
        processTilde = value;
    }

    public boolean getCompactPdf417() {
        return compactPdf417;
    }

    public void setCompactPdf417(boolean value) {
        compactPdf417 = value;
    }

    @JsonProperty("errorCorrection")
    public ErrorCorrection getErrorCorrection() {
        return errorCorrection;
    }

    public void setErrorCorrection(ErrorCorrection value) {
        errorCorrection = value;
    }

    @JsonProperty("compaction")
    public Compaction getCompaction() {
        return compaction;
    }

    public void setCompaction(Compaction value) {
        compaction = value;
    }
}
