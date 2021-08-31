package com.dynamicpdf.api;

/**
 * Represents an RGB color created using the web hexadecimal convention.
 */
public class WebColor extends RgbColor {

	/**
	 * Initializes a new instance of the <code>WebColor</code> class.
	 *
	 * @param webHexString The hexadecimal string representing the color.
	 */
	public WebColor(String webHexString) {
		setColorString(webHexString);
	}

}
