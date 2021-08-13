package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class StackedGs1DataBarBarcodeElement extends TextBarcodeElement {

    private StackedGs1DataBarType stackedGs1DataBarType;
    private int expandedStackedSegmentCount;
    private float rowHeight;

    public StackedGs1DataBarBarcodeElement(String value, ElementPlacement placement, StackedGs1DataBarType stackedGs1DataBarType, float rowHeight, float xOffset, float yOffset) {
        super(value, placement, xOffset, yOffset);
        this.stackedGs1DataBarType = stackedGs1DataBarType;
        this.rowHeight = rowHeight;
    }

    public StackedGs1DataBarBarcodeElement(String value, ElementPlacement placement, StackedGs1DataBarType stackedGs1DataBarType, float rowHeight) {
        this(value, placement, stackedGs1DataBarType, rowHeight, 0, 0);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.StackedGs1DataBarBarcode;
    }

    StackedGs1DataBarType getStackedGs1DataBarType() {
        return stackedGs1DataBarType;
    }

    public int getExpandedStackedSegmentCount() {
        return expandedStackedSegmentCount;
    }

    public void setExpandedStackedSegmentCount(int value) {
        expandedStackedSegmentCount = value;
    }

    public float getRowHeight() {
        return rowHeight;
    }

    public void setRowHeight(float value) {
        rowHeight = value;
    }
}
