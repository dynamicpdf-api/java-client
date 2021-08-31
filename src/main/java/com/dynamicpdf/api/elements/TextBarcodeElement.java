package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Color;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.Resource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base class from which barcode page elements that display text are derived.
 */
public abstract class TextBarcodeElement extends BarcodeElement {

	private Color textColor;
	private Font font;
	private String fontName;
	private Resource resource;
	private String textColorName;
	private float fontSize;
	private boolean showText = true;

	TextBarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset) {
		super(value, placement, xOffset, yOffset);
	}

	TextBarcodeElement(String value, ElementPlacement placement) {
		this(value, placement, 0, 0);
	}

	@JsonProperty("font")
	String getFontName() {
		return fontName;
	}

	void setFontName(String value) {
		fontName = value;
	}

	@JsonIgnore
	public Font getTextFont() {
		return getFont();
	}

	@JsonIgnore
	public Resource getResource() {
		return resource;
	}

	void setResource(Resource value) {
		resource = value;
	}

	@JsonProperty("textColor")
	String getTextColorName() {
		return textColorName;
	}

	void setTextColorName(String value) {
		textColorName = value;
	}

	/**
	 * Gets the color of the text.
	 * @return The color of the text.
	 */
	@JsonIgnore
	public Color getTextColor() {
		return textColor;
	}

	/**
	 * Sets the color of the text.
	 * @param value The color of the text.
	 */
	public void setTextColor(Color value) {
		textColor = value;
		textColorName = textColor.getColorString();
	}

	/**
	 * Gets the font to use when displaying the text.
	 * @return The font to use when displaying the text.
	 */
	@JsonIgnore
	public Font getFont() {
		return font;

	}

	/**
	 * Sets the font to use when displaying the text.
	 * @param value The font to use when displaying the text.
	 */
	public void setFont(Font value) {
		font = value;
		fontName = font.getName();
		resource = font.getResource();
	}

	/**
	 * Gets the font size to use when displaying the text.
	 * @return The font size to use when displaying the text.
	 */
	public float getFontSize() {
		return fontSize;
	}

	/**
	 * Sets the font size to use when displaying the text.
	 * @param value The font size to use when displaying the text.
	 */
	public void setFontSize(float value) {
		fontSize = value;
	}

	/**
	 * Gets a value indicating if the value should be placed as text below the barcode.
	 * @return A value indicating if the value should be placed as text below the barcode.
	 */
	@JsonInclude
	public boolean getShowText() {
		return showText;
	}

	/**
	 * Sets a value indicating if the value should be placed as text below the barcode.
	 * @param value A value indicating if the value should be placed as text below the barcode.
	 */
	public void setShowText(boolean value) {
		showText = value;
	}

}
