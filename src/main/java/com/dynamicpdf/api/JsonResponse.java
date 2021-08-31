package com.dynamicpdf.api;

/**
 * Represents the base class for json response.
 */

public abstract class JsonResponse extends Response {

	private String jsonContent;

	JsonResponse() {
	}

	JsonResponse(String jsonContent) {
		this.jsonContent = jsonContent;
	}

	/**
	 * Gets the json content.
	 * @return The json content.
	 */
	public String getJsonContent() {
		return jsonContent;
	}

	/**
	 * Sets the json content.
	 * @param value The json content.
	 */
	private void setJsonContent(String value) {
		jsonContent = value;
	}
}
