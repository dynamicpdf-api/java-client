package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Color;
import com.dynamicpdf.api.LineStyle;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents a line page element.
 *
 * <p>This class can be used to place lines of different length, width, color and patterns on a page.</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class LineElement extends Element {

	private Color color;
	private LineStyle lineStyle;
	private String colorName = null;
	private float x2Offset;
	private float y2Offset;
	private float width;
	private String lineStyleName;

	/**
	 * Initializes a new instance of the <code>LineElement</code> class.
	 * @param placement The placement of the line on the page.
	 * @param x2Offset X2 coordinate of the line.
	 * @param y2Offset Y2 coordinate of the line.
	 */
	public LineElement(ElementPlacement placement, float x2Offset, float y2Offset) {
		setPlacement(placement);
		this.x2Offset = x2Offset;
		this.y2Offset = y2Offset;
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.LINE;
	}

	@JsonProperty("color")
	String getColorName() {
		return colorName;
	}

	void setColorName(String value) {
		colorName = value;
	}

	@JsonProperty("lineStyle")
	String getLineStyleName() {
		return lineStyleName;
	}

	void setLineStyleName(String value) {
		lineStyleName = value;
	}

	/**
	 * Gets the <code>Color</code> object to use for the line.
	 * @return The <code>Color</code> object to use for the line.
	 */
	@JsonIgnore
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the <code>Color</code> object to use for the line.
	 * @param value The <code>Color</code> object to use for the line.
	 */
	public void setColor(Color value) {
		color = value;
		colorName = color.getColorString();
	}

	/**
	 * Gets the X2 coordinate of the line.
	 * @return The X2 coordinate of the line.
	 */
	public float getX2Offset() {
		return x2Offset;
	}

	/**
	 * Sets the X2 coordinate of the line.
	 * @param value The X2 coordinate of the line.
	 */
	public void setX2Offset(float value) {
		x2Offset = value;
	}

	/**
	 * Gets Y2 coordinate of the line.
	 * @return The Y2 coordinate of the line.
	 */
	public float getY2Offset() {
		return y2Offset;
	}

	/**
	 * Sets the Y2 coordinate of the line.
	 * @param value The Y2 coordinate of the line.
	 */
	public void setY2Offset(float value) {
		y2Offset = value;
	}

	/**
	 * Gets the width of the line.
	 * @return The width of the line.
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * Sets the width of the line.
	 * @param value The width of the line.
	 */
	public void setWidth(float value) {
		width = value;
	}

	/**
	 * Gets the <code>LineStyle</code> object to use for the style of the line.
	 * @return The <code>LineStyle</code> object to use for the style of the line.
	 */
	@JsonIgnore
	public LineStyle getLineStyle() {
		return lineStyle;
	}

	/**
	 * Sets the <code>LineStyle</code> object to use for the style of the line.
	 * @param value The <code>LineStyle</code> object to use for the style of the line.
	 */
	public void setLineStyle(LineStyle value) {
		lineStyle = value;
		lineStyleName = lineStyle.getLineStyleString();
	}

}
