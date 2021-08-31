package com.dynamicpdf.api;

/**
 * Represents the pdf inforamtion response.
 */

public class PdfInfoResponse extends JsonResponse {

	private PdfInformation content;

	/**
	 * Initializes a new instance of the <code>PdfInfoResponse</code> class.
	 */
	public PdfInfoResponse() {
		super();
	}

	/**
	 * Initializes a new instance of the <code>PdfInfoResponse</code> class.
	 * @param jsonContent The json of pdf information.
	 */
	public PdfInfoResponse(String jsonContent) {
		super(jsonContent);
		//content = JsonConvert.DeserializeObject <PdfInformation> (super.getJsonContent());
	}

	/**
	 * Gets the pdf information content.
	 * @return The pdf information content.
	 */
	public PdfInformation getContent() {
		return content;
	}

	/**
	 * Sets the pdf information content.
	 * @param value The pdf information content.
	 */
	private void setContent(PdfInformation value) {
		content = value;
	}

}
