package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a list of outlines
 */
public class OutlineList {

	private List<Outline> outlines = null;

	OutlineList()
	{
		outlines = new ArrayList<Outline>();
	}

	/**
	 * Adds an <code>Outline</code> object to the outline list.
	 * @param text Text of the outline.
	 * @return The <code>Outline</code> object that is created.
	 */
	public Outline add(String text)
	{
		Outline outline = new Outline(text);
		outlines.add(outline);
		return outline;
	}

	/**
	 * Adds an <code>Outline</code> object to the outline list.
	 * @param text Text of the outline.
	 * @param url URL the action launches.
	 * @return The <code>Outline</code> object that is created.
	 */
	public Outline add(String text, String url)
	{
		Outline outline = new Outline(text, new UrlAction(url));
		outlines.add(outline);
		return outline;
	}

	/**
	 * Adds an <code>Outline</code> object to the outline list.
	 * @param text Text of the outline.
	 * @param input Any of the <code>ImageInput</code>,  <code>DlexInput</code>,  <code>PdfInput</code> or  <code>PageInput</code> objects to create PDF.
	 * @param pageOffset Page number to navigate.
	 * @param pageZoom <code>PageZoom</code> to display the destination.
	 * @return The <code>Outline</code> object that is created.
	 */
	public Outline add(String text, Input input, int pageOffset, PageZoom pageZoom)
	{
		GoToAction linkTo = new GoToAction(input);
		linkTo.setPageOffset(pageOffset);
		linkTo.setPageZoom(pageZoom);
		Outline outline = new Outline(text, linkTo);
		outlines.add(outline);
		return outline;
	}

	/**
	 * Adds an <code>Outline</code> object to the outline list.
	 * @param text Text of the outline.
	 * @param input Any of the <code>ImageInput</code>,  <code>DlexInput</code>,  <code>PdfInput</code> or  <code>PageInput</code> objects to create PDF.
	 * @param pageOffset Page number to navigate.
	 * @return The <code>Outline</code> object that is created.
	 */
	public Outline add(String text, Input input, int pageOffset)
	{
		return add(text, input, pageOffset, PageZoom.FITPAGE);
	}

	/**
	 * Adds an <code>Outline</code> object to the outline list.
	 * @param text Text of the outline.
	 * @param input Any of the <code>ImageInput</code>,  <code>DlexInput</code>,  <code>PdfInput</code> or  <code>PageInput</code> objects to create PDF.
	 * @return The <code>Outline</code> object that is created.
	 */
	public Outline add(String text, Input input)
	{
		return add(text, input, 0, PageZoom.FITPAGE);
	}
	
	/**
     * Adds an <code>Outline</code> object to the outline list.
     * @param pdfInput PdfInput of type <code>PdfInput</code>  object to import outlines to the PDF.
     */
	public void addPdfOutlines(PdfInput pdfInput)
	{
		outlines.add(new Outline(pdfInput));
	}

	@JsonProperty
	List<Outline> getOutlines()
	{
		return this.outlines;
	}

}
