package com.dynamicpdf.api;

/**
 * Represents a grayscale color.
 */

public class Grayscale extends Color {

	private String colorString;
	private float grayLevel;

	Grayscale(String colorString) {
		setColorString(colorString);
	}

	/**
	 * Initializes a new instance of the  <code>Grayscale</code> class.
	 * @param grayLevel The gray level for the color.
	 */

	public Grayscale(float grayLevel) {
		this.grayLevel = grayLevel;
	}

	/**
	 * Gets the color black.
	 * @return The color black.
	 */
	public static Grayscale getBlack() {
		return new Grayscale(0);
	}

	/**
	 * Gets the color white.
	 * @return The color white.
	 */
	public static Grayscale getWhite() {
		return new Grayscale(1);
	}

	/**
	 * Gets the color string.
	 * @return The color string.
	 */
	public String getColorString() {
		if (colorString != null) {
			return colorString;
		} else {
			return "gray(" + Float.toString(grayLevel) + ")";
		}

	}

	void setColorString(String value) {

		colorString = value;
	}
}
