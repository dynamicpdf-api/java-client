package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.FloatJsonSerializer;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.Resource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Base class from which all page elements are derived.
 */
public abstract class Element {

	private ElementType type;
	private Resource resource;
	private String inputValue;
	private Font textFont;
	private ElementPlacement placement;
	private float xOffset;
	private float yOffset;
	private boolean evenPages;
	private boolean oddPages;

	Element() {
	}

	Element(String value, ElementPlacement placement, float xOffset, float yOfset) {
		this.inputValue = value;
		this.placement = placement;
		this.xOffset = xOffset;
		this.yOffset = yOfset;
	}

	Element(String value) {
		inputValue = value;
	}

	abstract ElementType getType();

    /**
    * <p><b>This method is meant for DynamicPDF's internal usage and not supposed to be used by the client programs.</b></p>
    */
	public Resource getResource() {
		return null;
	}

	void setResource(Resource value) {
		resource = value;
	}

	String getInputValue() {
		return inputValue;
	}

	void setInputValue(String value) {
		inputValue = value;
	}

    /**
    * <p><b>This method is meant for DynamicPDF's internal usage and not supposed to be used by the client programs.</b></p>
    */
	public Font getTextFont() {
		return textFont;
	}
	/**
	 * Gets placement of the page element on the page.
	 * @return Placement of the page element on the page.
	 */
	public ElementPlacement getPlacement() {
		return placement;
	}

	/**
	 * Sets placement of the page element on the page.
	 * @param value Placement of the page element on the page.
	 */
	public void setPlacement(ElementPlacement value) {
		placement = value;
	}

	/**
	 * Gets the X coordinate of the page element.
	 * @return The X coordinate of the page element.
	 */
	@JsonProperty("xOffset")
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getXOffset() {
		return xOffset;
	}

	/**
	 * Sets the X coordinate of the page element.
	 * @param value The X coordinate of the page element.
	 */
	public void setXOffset(float value) {
		xOffset = value;
	}

	/**
	 * Gets the Y coordinate of the page element.
	 * @return The Y coordinate of the page element.
	 */
	@JsonProperty("yOffset")
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getYOffset() {
		return yOffset;
	}

	/**
	 * Sets the Y coordinate of the page element.
	 * @param value The Y coordinate of the page element.
	 */
	public void setYOffset(float value) {
		yOffset = value;
	}

	/**
	 * Gets the boolean value specifying whether the element should be added to even pages or not.
	 * @return The boolean value specifying whether the element should be added to even pages or not.
	 */
	public boolean getEvenPages() {
		return evenPages;
	}

	/**
	 * Sets the boolean value specifying whether the element should be added to even pages or not.
	 * @param value The boolean value specifying whether the element should be added to even pages or not.
	 */
	public void setEvenPages(boolean value) {
		evenPages = value;
	}

	/**
	 * Gets the boolean value specifying whether the element should be added to odd pages or not.
	 * @return The boolean value specifying whether the element should be added to odd pages or not. 
	 */
	public boolean getOddPages() {
		return oddPages;
	}

	/**
	 * Sets the boolean value specifying whether the element should be added to odd pages or not. 
	 * @param value The boolean value specifying whether the element should be added to odd pages or not. 
	 */
	public void setOddPages(boolean value) {
		oddPages = value;
	}
}
