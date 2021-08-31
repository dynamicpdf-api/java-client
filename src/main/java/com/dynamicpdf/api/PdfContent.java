package com.dynamicpdf.api;

/**
 * Represents the pdf content
 */

public class PdfContent {

	private int pageNumber;
	private String text;

	/**
	 * Gets or sets the page number.
	 * @return The page number.
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * Sets the page number.
	 * @param value The page number.
	 */
	public void setPageNumber(int value) {
		pageNumber = value;
	}

	/**
	 * Gets the text in the pdf.
	 * @return The text in the pdf.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the text in the pdf.
	 * @param value The text in the pdf.
	 */
	public void setText(String value) {
		text = value;
	}
}
