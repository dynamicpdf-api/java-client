package com.dynamicpdf.api;

/**
 * Represents the pdf response.
 */
public class PdfResponse extends Response {

	private byte[] content;

	/**
	 * Initializes a new instance of the <code>PdfResponse</code> class.
	 */
	public PdfResponse() {
	}

	/**
	 * Initializes a new instance of the <code>PdfResponse</code> class.
	 * @param pdfContent The byte array of pdf content.
	 * */
	public PdfResponse(byte[] pdfContent) {
		content = pdfContent;
	}

	/**
	 * Sets the content od pdf.
	 * @return The content od pdf.
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * Sets the content od pdf.
	 * @param value The content od pdf.
	 */
	private void setContent(byte[] value) {
		content = value;
	}
}
