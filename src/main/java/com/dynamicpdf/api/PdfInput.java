package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a pdf input.
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class PdfInput extends Input {

	private MergeOptions mergeOptions = null;
	private int startPage;
	private int pageCount;

	/**
	 * Initializes a new instance of the <code>PdfInput</code> class.
	 * @param resource The resource of type <code>PdfResource</code>.
	 * @param options The merge options for the pdf.
	 */
	public PdfInput(PdfResource resource, MergeOptions options) {
		super(resource);
		mergeOptions = options;
	}

	/**
	 * Initializes a new instance of the <code>PdfInput</code> class.
	 * @param resourceName The name of the resource present in cloud resource manager.
	 */
	public PdfInput(PdfResource resource) {
		super(resource);
	}

	/**
	 * Returns a <code>PdfInput</code> object containing the input pdf.
	 * @param cloudResourcePath The resource path in cloud resource manager.
	 * @param options The merge options for the pdf.
	 */
	public PdfInput(String cloudResourcePath, MergeOptions options) {
		super(cloudResourcePath);
		mergeOptions = options;
	}

	/**
	 * 
	 * @param cloudResourcePath The resource path in cloud resource manager.
	 */
	public PdfInput(String cloudResourcePath) {
		super(cloudResourcePath);
	}

	@JsonProperty("type")
	InputType getType() {
		return InputType.PDF;
	}

	/**
	 * Gets the merge options <code>MergeOptions</code>.
	 * @return The merge options <code>MergeOptions</code>.
	 */
	public MergeOptions getMergeOptions() {
		return mergeOptions;
	}

	/**
	 * Sets the merge options <code>MergeOptions</code>.
	 * @param value The merge options <code>MergeOptions</code>.
	 */
	public void setMergeOptions(MergeOptions value) {
		mergeOptions = value;
	}

	/**
	 * Gets the start page.
	 * @return The start page.
	 */
	public int getStartPage() {
		return startPage;
	}

	/**
	 * Sets the start page.
	 * @param value The start page.
	 */
	public void setStartPage(int value) {
		startPage = value;
	}

	/**
	 * Gets the page count.
	 * @return The page count.
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * Sets the page count.
	 * @param value The page count.
	 */
	public void setPageCount(int value) {
		pageCount = value;
	}
}
