package com.dynamicpdf.api;

import java.util.List;

/**
 * Represents the pdf text response.
 */
public class PdfTextResponse extends JsonResponse {

	private List<PdfContent> content;

	/**
	 * Initializes a new instance of the <code>PdfTextResponse</code> class.    
	 */
	public PdfTextResponse() {
		super();
	}

	/**
	 * Initializes a new instance of the <code>PdfResponse</code> class.
	 * @param jsonContent The json content
	 */
	public PdfTextResponse(String jsonContent) {
		super(jsonContent);
	}

	/**
	 * Gets the collection of PdfContent.
	 * @return The collection of PdfContent.
	 */
	public List<PdfContent> getContent() {
		return content;
	}

	private void setContent(List<PdfContent> value) {
		content = value;
	}

}
