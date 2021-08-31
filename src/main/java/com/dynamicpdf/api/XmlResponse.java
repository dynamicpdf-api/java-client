package com.dynamicpdf.api;

/**
 * Represents the xml response.
 */
public class XmlResponse extends Response {

	private String content;

	/**
	 * Initializes a new instance of the <code>XmlResponse</code> class.
	 */
	public XmlResponse() {
	}

	/**
	 * Initializes a new instance of the <code>XmlResponse</code> class.
	 *
	 * @param xmlContent The xml content of the response.
	 */
	public XmlResponse(String xmlContent) {
		content = xmlContent;
	}

	/**
	 * Gets the xml content.
	 * @return The xml content.
	 */
	public String getContent() {
		return content;
	}

	private void setContent(String value) {
		content = value;
	}
}
