package com.dynamicpdf.api;

import java.util.List;

/**
 * Represents an image response.
 */

public class ImageResponse extends JsonResponse {

	private List<ImageInformation> content;

	/**
	 * Initializes a new instance of the <code>ImageResponse</code> class.
	 */

	public ImageResponse() {
		super();
	}

	/**
	 * Initializes a new instance of the <code>ImageResponse</code> class.
	 * @param jsonContent The image content of the response.
	 */

	public ImageResponse(String jsonContent) {
		super(jsonContent);
		//content = JsonConvert.DeserializeObject <List <ImageInformation>> (super.getJsonContent());
	}

	/**
	 * Gets a collection of <code>ImageInformation</code>.
	 * @return A collection of <code>ImageInformation</code>.
	 */
	public List<ImageInformation> getContent() {
		return content;
	}

	/**
	 * Sets a collection of <code>ImageInformation</code>.
	 * @param value A collection of <code>ImageInformation</code>.
	 */
	private void setContent(List<ImageInformation> value) {
		content = value;
	}

}
