package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a goto action in a PDF document that navigates 
 * to a specific page using page number and zoom options.
 */

public class GoToAction extends Action {

	private String inputID;
	private int pageOffset;
	private PageZoom pageZoom;
	private Input input;

	/**
	 * Initializes a new instance of the  <code>GoToAction</code> class 
	 * using an input to create the PDF, page number, and a zoom option.
	 * @param input Any of the <code>ImageInput</code>,  <code>DlexInput</code>,  <code>PdfInput</code> or  <code>PageInput</code> objects to create PDF.
	 * @param pageOffset Page number to navigate.
	 * @param pageZoom <code>PageZoom</code> to display the destination.
	 */

	public GoToAction(Input input, int pageOffset, PageZoom pageZoom) {
		this.input = input;
		this.inputID = input.getId();
		this.pageOffset = pageOffset;
		this.pageZoom = pageZoom;
	}

	/**
	 * Initializes a new instance of the  <code>GoToAction</code> class 
	 * using an input to create the PDF, page number, and a zoom option. 
	 * @param input Any of the <code>ImageInput</code>,  <code>DlexInput</code>,  <code>PdfInput</code> or  <code>PageInput</code> objects to create PDF.
	 */
	public GoToAction(Input input) {
		this(input, 0, PageZoom.FITPAGE);
	}

	/**
	 * Initializes a new instance of the  <code>GoToAction</code> class 
	 * using an input to create the PDF, page number, and a zoom option. 
	 * @param input Any of the <code>ImageInput</code>,  <code>DlexInput</code>,  <code>PdfInput</code> or  <code>PageInput</code> objects to create PDF.
	 * @param pageOffset Page number to navigate.
	 */
	public GoToAction(Input input, int pageOffset) {
		this(input, pageOffset, PageZoom.FITPAGE);
	}

	Input getInput() {
		return input;
	}

	void setInput(Input value) {
		input = value;
	}

	@JsonProperty("inputID")
	String getInputID() {
		return inputID;
	}

	void setInputID(String value) {
		inputID = value;
	}

	/**
	 * Gets page Offset.
	 * @return Page Offset.
	 */
	public int getPageOffset() {
		return pageOffset;
	}

	/**
	 * Sets page Offset.
	 * @param value Page Offset.
	 */
	public void setPageOffset(int value) {
		this.pageOffset = value;
	}

	/**
	 * Gets <code>PageZoom</code> to display the destination.
	 * @return <code>PageZoom</code> to display the destination.
	 */
	public PageZoom getPageZoom() {
		return pageZoom;
	}

	/**
	 * Sets <code>PageZoom</code> to display the destination.
	 * @param value <code>PageZoom</code> to display the destination.
	 */
	public void setPageZoom(PageZoom value) {
		this.pageZoom = value;
	}

}
