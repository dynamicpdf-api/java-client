package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)

/**
 * Represents an image input.
 */

public class ImageInput extends Input {

	private float scaleX;
	private float scaleY;
	private float topMargin;
	private float leftMargin;
	private float bottomMargin;
	private float rightMargin;
	private float pageWidth;
	private float pageHeight;
	private boolean expandToFit;
	private boolean shrinkToFit;
	private Align align = Align.CENTER;
	private VAlign vAlign = VAlign.CENTER;
	private int startPage;
	private int pageCount;

	/**
	 * Initializes a new instance of the <code>ImageInput</code> class.
	 * @param resource The <code>ImageResource</code> object to create ImageInput.
	 */

	public ImageInput(ImageResource resource) {
		super(resource);
	}

	/**
	 * Initializes a new instance of the <code>ImageInput</code> class.
	 * @param cloudResourcePath The image file path present in cloud resource manager.
	 */

	public ImageInput(String cloudResourcePath) {
		super(cloudResourcePath);
	}

	@JsonProperty("type")
	InputType getType() {
		return InputType.IMAGE;
	}

	/**
	 * Gets the scaleX of the image.
	 * @return The scaleX of the image.
	 */
	public float getScaleX() {
		return scaleX;
	}

	/**
	 * Sets the scaleX of the image.
	 * @param value The scaleX of the image.
	 */
	public void setScaleX(float value) {
		scaleX = value;
	}

	/**
	 * Gets the scaleY of the image.
	 * @return The scaleY of the image.
	 */
	public float getScaleY() {
		return scaleY;
	}

	/**
	 * Sets the scaleY of the image.
	 * @param value The scaleY of the image.
	 */
	public void setScaleY(float value) {
		scaleY = value;
	}

	/**
	 * Gets the top margin.
	 * @return The top margin.
	 */
	public float getTopMargin() {
		return topMargin;
	}

	/**
	 * Sets the top margin.
	 * @param value The top margin.
	 */
	public void setTopMargin(float value) {
		topMargin = value;
	}

	/**
	 * Gets the left margin.
	 * @return The left margin.
	 */
	public float getLeftMargin() {
		return leftMargin;
	}

	/**
	 * Sets the left margin.
	 * @param value The left margin.
	 */
	public void setLeftMargin(float value) {
		leftMargin = value;
	}

	/**
	 * Gets the bottom margin.
	 * @return The bottom margin.
	 */
	public float getBottomMargin() {
		return bottomMargin;
	}

	/**
	 * Sets the bottom margin.
	 * @param value The bottom margin.
	 */
	public void setBottomMargin(float value) {
		bottomMargin = value;
	}

	/**
	 * Gets the right margin.
	 * @return The right margin.
	 */
	public float getRightMargin() {
		return rightMargin;
	}

	/**
	 * Sets the right margin.
	 * @param value The right margin.
	 */
	public void setRightMargin(float value) {
		rightMargin = value;
	}

	/**
	 * Gets the page width.
	 * @return The page width.
	 */
	public float getPageWidth() {
		return pageWidth;
	}

	/**
	 * Sets the page width.
	 * @param value The page width.
	 */
	public void setPageWidth(float value) {
		pageWidth = value;
	}

	/**
	 * Gets the page height.
	 * @return The page height.
	 */
	public float getPageHeight() {
		return pageHeight;
	}

	/**
	 * Sets the page height.
	 * @param value The page height.
	 */
	public void setPageHeight(float value) {
		pageHeight = value;
	}

	/**
	 * Gets a boolean indicating whether to expand the image.
	 * @return A boolean indicating whether to expand the image.
	 */
	public boolean getExpandToFit() {
		return expandToFit;
	}

	/**
	 * Sets a boolean indicating whether to expand the image.
	 * @param value A boolean indicating whether to expand the image.
	 */
	public void setExpandToFit(boolean value) {
		expandToFit = value;
	}

	/**
	 * Gets a boolean indicating whether to shrink the image.
	 * @return A boolean indicating whether to shrink the image.
	 */
	public boolean getShrinkToFit() {
		return shrinkToFit;
	}

	/**
	 * Sets a boolean indicating whether to shrink the image.
	 * @param value A boolean indicating whether to shrink the image.
	 */
	public void setShrinkToFit(boolean value) {
		shrinkToFit = value;
	}

	/**
	 * Gets the horizontal alignment of the image.
	 * @return The horizontal alignment of the image.
	 */
	public Align getAlign() {
		return align;
	}

	/**
	 * Sets the horizontal alignment of the image.
	 * @param value The horizontal alignment of the image.
	 */
	public void setAlign(Align value) {
		align = value;
	}

	/**
	 * Gets the vertical alignment of the image.
	 * @return The vertical alignment of the image.
	 */
	@JsonProperty("vAlign")
	public VAlign getVAlign() {
		return vAlign;
	}

	/**
	 * Sets the vertical alignment of the image.
	 * @param value The vertical alignment of the image.
	 */
	public void setVAlign(VAlign value) {
		vAlign = value;
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
	public void setSatrtPage(int value) {
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
