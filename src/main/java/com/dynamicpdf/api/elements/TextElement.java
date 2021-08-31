package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Color;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.Resource;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a text element.
 * 
 * <p>This class can be used to place text on a page.</</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class TextElement extends Element {

	private Color color;
	private Font font;
	private String fontName;
	private Resource resource;
	private String colorName;
	private float fontSize;

	/**
	 * Initializes a new instance of the <code>TextElement</code> class
	 * 
	 * @param value Text to display in the text element.
	 * @param placement The placement of the text element on the page.
	 * @param xOffset X coordinate of the text element.
	 * @param yOffset Y coordinate of the text element.
	 */
	public TextElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
	}

	/**
	 * Initializes a new instance of the <code>TextElement</code> class
	 * 
	 * @param value Text to display in the text element.
	 * @param placement The placement of the text element on the page.
	 */
	public TextElement(String value, ElementPlacement placement) {
		this(value, placement, 0, 0);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.TEXT;
	}

	@JsonProperty("font")
	String getFontName() {
		return fontName;
	}

	void setFontName(String value) {
		fontName = value;
	}

	@JsonProperty("color")
	String getColorName() {
		return colorName;
	}

	void setColorName(String value) {
		colorName = value;
	}

	@JsonIgnore
	public Resource getResource() {
		return resource;
	}

	void setResource(Resource value) {
		resource = value;
	}

	@JsonIgnore
	public Font getTextFont() {
		return font;
	}

	/**
	 * Gets the text to display in the text element.
	 * @return The text to display in the text element.
	 */
	public String getText() {
		return getInputValue();
	}

	/**
	 * Sets the text to display in the text element.
	 * @param value The text to display in the text element.
	 */
	public void setText(String value) {
		setInputValue(value);
	}

	/**
	 * Gets the <code>Color</code> object to use for the text of the text element.
	 * @return The <code>Color</code> object to use for the text of the text element.
	 */
	@JsonIgnore
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the <code>Color</code> object to use for the text of the text element.
	 * @param value The <code>Color</code> object to use for the text of the text element.
	 */
	public void setColor(Color value) {
		color = value;
		colorName = color.getColorString();
	}

	/**
	 * Gets the <code>Font</code> object used to specify the font of the text for the text element.
	 * @return The <code>Font</code> object used to specify the font of the text for the text element.
	 */
	@JsonIgnore
	public Font getFont() {
		return font;
	}

	/**
	 * Sets the <code>Font</code> object used to specify the font of the text for the text element.
	 * @param value The <code>Font</code> object used to specify the font of the text for the text element.
	 */
	public void setFont(Font value) {
		font = value;
		fontName = font.getName();
		resource = font.getResource();
	}

	/**
	 * Gets the font size for the text of the text element.
	 * @return The font size for the text of the text element.
	 */
	public float getFontSize() {
		return fontSize;
	}

	/**
	 * Sets the font size for the text of the text element.
	 * @param value The font size for the text of the text element.
	 */
	public void setFontSize(float value) {
		fontSize = value;
	}

}
