package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Color;
import com.dynamicpdf.api.FloatJsonSerializer;
import com.dynamicpdf.api.LineStyle;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents a rectangle page element.
 * 
 * <p>This class can be used to place rectangles of any size or color on a page.</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class RectangleElement extends Element {

	private Color fillColor;
	private Color borderColor;
	private LineStyle borderStyle;
	private float width;
	private float height;
	private float borderWidth;
	private float cornerRadius;
	private String fillColorName;
	private String borderColorName;

	private String borderStyleName;

	/**
	 * Initializes a new instance of the <code>RectangleElement</code> class.
	 * 
	 * @param placement The placement of the rectangle on the page.
	 * @param width Width of the rectangle.
	 * @param height Height of the rectangle.
	 */
	public RectangleElement(ElementPlacement placement, float width, float height) {
		setPlacement(placement);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Initializes a new instance of the <code>RectangleElement</code> class.
	 * 
	 * @param width Width of the rectangle.
	 * @param height Height of the rectangle.
	 */
	public RectangleElement(float width, float height) {
		setPlacement(ElementPlacement.TOPLEFT);
		this.width = width;
		this.height = height;
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.RECTANGLE;
	}

	/**
	 * Gets the width of the rectangle.
	 * @return The width of the rectangle.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getWidth() {
		return width;
	}

	/**
	 * Sets the width of the rectangle.
	 * @param value The width of the rectangle.
	 */
	public void setWidth(float value) {
		width = value;
	}

	/**
	 * Gets the height of the rectangle.
	 * @return The height of the rectangle.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getHeight() {
		return height;
	}

	/**
	 * Sets the height of the rectangle.
	 * @param value The height of the rectangle.
	 */
	public void setHeight(float value) {
		height = value;
	}

	/**
	 * Gets the border width of the rectangle.
	 * <p>To force the borders not to appear set the border width to any value 0 or less.</p>
	 * @return The border width of the rectangle.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getBorderWidth() {
		return borderWidth;
	}

	/**
	 * Sets the border width of the rectangle.
	 * <p>To force the borders not to appear set the border width to any value 0 or less.</p>
	 * @param value The border width of the rectangle.
	 */
	public void setBorderWidth(float value) {
		borderWidth = value;
	}

	/**
	 * Gets the corner radius of the rectangle.
	 * @return The corner radius of the rectangle.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getCornerRadius() {
		return cornerRadius;
	}

	/**
	 * Sets the corner radius of the rectangle.
	 * @param value The corner radius of the rectangle.
	 */
	public void setCornerRadius(float value) {
		cornerRadius = value;
	}

	@JsonProperty("fillColor")
	String getFillColorName() {
		return fillColorName;
	}

	void setFillColorName(String value) {
		fillColorName = value;
	}

	@JsonProperty("borderColor")
	String getBorderColorName() {
		return borderColorName;
	}

	void setBorderColorName(String value) {
		borderColorName = value;
	}

	@JsonProperty("borderStyle")
	String getBorderStyleName() {
		return borderStyleName;
	}

	void setBorderStyleName(String value) {
		borderStyleName = value;
	}

	/**
	 * Gets the <code>Color</code>object to use for the fill of the rectangle.
	 *
	 * <p>To force no color to appear in the rectangle (only borders) set the fill color to null (Nothing in Visual Basic).</p>
	 * @return The <code>Color</code>object to use for the fill of the rectangle.
	 */
	@JsonIgnore
	public Color getFillColor() {
		return fillColor;
	}

	/**
	 * Sets the <code>Color</code>object to use for the fill of the rectangle.
	 *
	 * <p>To force no color to appear in the rectangle (only borders) set the fill color to null (Nothing in Visual Basic).</p>
	 * @param value The <code>Color</code>object to use for the fill of the rectangle.
	 */
	public void setFillColor(Color value) {
		fillColor = value;
		fillColorName = fillColor.getColorString();
	}

	/**
	 * Gets the <code>Color</code>object to use for the border of the rectangle.
	 * @return The <code>Color</code>object to use for the border of the rectangle.
	 */
	@JsonIgnore
	public Color getBorderColor() {
		return borderColor;
	}

	/**
	 * Sets the <code>Color</code>object to use for the border of the rectangle.
	 * @param value The <code>Color</code>object to use for the border of the rectangle.
	 */
	public void setBorderColor(Color value) {
		borderColor = value;
		borderColorName = borderColor.getColorString();
	}

	/**
	 * Gets the <code>LineStyle</code> object used to specify the border style of the rectangle.
	 * @return The <code>LineStyle</code> object used to specify the border style of the rectangle.
	 */
	@JsonIgnore
	public LineStyle getBorderStyle() {
		return borderStyle;
	}

	/**
	 * Sets the <code>LineStyle</code> object used to specify the border style of the rectangle.
	 * @param value The <code>LineStyle</code> object used to specify the border style of the rectangle.
	 */
	public void setBorderStyle(LineStyle value) {
		borderStyle = value;
		borderStyleName = borderStyle.getLineStyleString();
	}
}
