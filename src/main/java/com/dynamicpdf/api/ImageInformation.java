package com.dynamicpdf.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents an image information.
 */

public class ImageInformation {

	private int pageNumber;
	private float width;
	private float height;
	private float horizondalDpi;
	private float verticalDpi;
	private float numberOfComponents;
	private float bitsPerComponent;
	private ColorSpaceType colorSpace;

	/**
	 * Gets page number of the pdf where the image is present.
	 * @return Page number of the pdf where the image is present.
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * Sets page number of the pdf where the image is present.
	 * @param value Page number of the pdf where the image is present.
	 */
	public void setPageNumber(int value) {
		pageNumber = value;
	}

	/**
	 * Gets the width of the image.
	 * @return The width of the image.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getWidth() {
		return width;
	}

	/**
	 * Sets the width of the image.
	 * @param value The width of the image.
	 */
	public void setWidth(float value) {
		width = value;
	}

	/**
	 * Gets the height of the image.
	 * @return The height of the image.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getHeight() {
		return height;
	}

	/**
	 * Sets the height of the image.
	 * @param value The height of the image.
	 */
	public void setHeight(float value) {
		height = value;
	}

	/**
	 * Gets the horizondalDpi of the image.
	 * @return The horizondalDpi of the image.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getHorizondalDpi() {
		return horizondalDpi;
	}

	/**
	 * Sets the horizondalDpi of the image.
	 * @param value The horizondalDpi of the image.
	 */
	public void setHorizondalDpi(float value) {
		horizondalDpi = value;
	}

	/**
	 * Gets the verticalDpi of the image.
	 * @return The verticalDpi of the image.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getVerticalDpi() {
		return verticalDpi;
	}

	/**
	 * Sets the verticalDpi of the image.
	 * @param value The verticalDpi of the image.
	 */
	public void setVerticalDpi(float value) {
		verticalDpi = value;
	}

	/**
	 * Gets the number of color components present in the image.
	 * @return The number of color components present in the image.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getNumberOfComponents() {
		return numberOfComponents;
	}

	/**
	 * Sets the number of color components present in the image.
	 * @param value The number of color components present in the image.
	 */
	public void setNumberOfComponents(float value) {
		numberOfComponents = value;
	}

	/**
	 * Gets the bits per component of the image.
	 * @return The bits per component of the image.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getBitsPerComponent() {
		return bitsPerComponent;
	}

	/**
	 * Sets the bits per component of the image.
	 * @param value The bits per component of the image.
	 */
	public void setBitsPerComponent(float value) {
		bitsPerComponent = value;
	}

	/**
	 * Gets the clor space of the image.
	 * @return The clor space of the image.
	 */
	public ColorSpaceType getColorSpace() {
		return colorSpace;
	}

	/**
	 * Sets the clor space of the image.
	 * @param value The clor space of the image.
	 */
	public void setColorSpace(ColorSpaceType value) {
		colorSpace = value;
	}
}
