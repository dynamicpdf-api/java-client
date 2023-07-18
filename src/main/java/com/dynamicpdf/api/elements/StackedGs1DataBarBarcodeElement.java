package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.FloatJsonSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents a StackedGS1DataBar barcode element.
 * 
 * <p>This class can be used to place a StackedGS1DataBar barcode on a page.</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class StackedGs1DataBarBarcodeElement extends TextBarcodeElement {

	private StackedGs1DataBarType stackedGs1DataBarType;
	private int expandedStackedSegmentCount;
	private float rowHeight;

	/**
	 * Initializes a new instance of the <code>StackedGs1DataBarBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param stackedGs1DataBarType The StackedGS1DataBarType of the barcode.
	 * @param rowHeight The row height of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode. 
	 */
	public StackedGs1DataBarBarcodeElement(String value, ElementPlacement placement, StackedGs1DataBarType stackedGs1DataBarType, float rowHeight, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
		this.stackedGs1DataBarType = stackedGs1DataBarType;
		this.rowHeight = rowHeight;
	}
	
	/**
	 * Initializes a new instance of the <code>StackedGs1DataBarBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param stackedGs1DataBarType The StackedGS1DataBarType of the barcode.
	 * @param rowHeight The row height of the barcode.
	 * @param xOffset The X coordinate of the barcode.
	 * @param yOffset The Y coordinate of the barcode. 
	 */
	public StackedGs1DataBarBarcodeElement(String value, StackedGs1DataBarType stackedGs1DataBarType, float rowHeight, float xOffset, float yOffset) {
		super(value, ElementPlacement.TOPLEFT, xOffset, yOffset);
		this.stackedGs1DataBarType = stackedGs1DataBarType;
		this.rowHeight = rowHeight;
	}

	/**
	 * Initializes a new instance of the <code>StackedGs1DataBarBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param placement The placement of the barcode on the page.
	 * @param stackedGs1DataBarType The StackedGS1DataBarType of the barcode.
	 * @param rowHeight The row height of the barcode.
	 */
	public StackedGs1DataBarBarcodeElement(String value, ElementPlacement placement, StackedGs1DataBarType stackedGs1DataBarType, float rowHeight) {
		this(value, placement, stackedGs1DataBarType, rowHeight, 0, 0);
	}
	
	/**
	 * Initializes a new instance of the <code>StackedGs1DataBarBarcodeElement</code> class
	 * 
	 * @param value The value of the barcode.
	 * @param stackedGs1DataBarType The StackedGS1DataBarType of the barcode.
	 * @param rowHeight The row height of the barcode.
	 */
	public StackedGs1DataBarBarcodeElement(String value, StackedGs1DataBarType stackedGs1DataBarType, float rowHeight) {
		this(value, ElementPlacement.TOPLEFT, stackedGs1DataBarType, rowHeight, 0, 0);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.STACKEDGS1DATABARBARCODE;
	}

	@JsonProperty("stackedGs1DataBarType")
	StackedGs1DataBarType getStackedGs1DataBarType() {
		return stackedGs1DataBarType;
	}

	/**
	 * Gets the segment count of the Expanded Stacked barcode.
	 *
	 * <p>This is used only for the ExpandedStacked Gs1DataBar type.</p>
	 * @return The segment count of the Expanded Stacked barcode.
	 */
	public int getExpandedStackedSegmentCount() {
		return expandedStackedSegmentCount;
	}

	/**
	 * Sets the segment count of the Expanded Stacked barcode.
	 *
	 * <p>This is used only for the ExpandedStacked Gs1DataBar type.</p>
	 * @param value The segment count of the Expanded Stacked barcode.
	 */
	public void setExpandedStackedSegmentCount(int value) {
		expandedStackedSegmentCount = value;
	}

	/**
	 * Gets the row height of the barcode.
	 * @return The row height of the barcode.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getRowHeight() {
		return rowHeight;
	}

	/**
	 * Sets the row height of the barcode.
	 * @param value The row height of the barcode.
	 */
	public void setRowHeight(float value) {
		rowHeight = value;
	}
}
