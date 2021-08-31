package com.dynamicpdf.api;

/**
 * Represents a page information.
 */

public class PageInformation {

	private int pageNumber;
	private float width;
	private float height;

	/**
	 * Gets the page number.
	 * @return The page number.
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * sets the page number.
	 * @param value The page number.
	 */
	public void setPageNumber(int value) {
		pageNumber = value;
	}

	/**
	 * Gets the width of the page.
	 * @return The width of the page.
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * sets the width of the page.
	 * @param value The width of the page.
	 */
	public void setWidth(float value) {
		width = value;
	}

	/**
	 * Gets the height of the page.
	 * @return The height of the page.
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * sets the height of the page.
	 * @param value The height of the page.
	 */
	public void setHeight(float value) {
		height = value;
	}
}
