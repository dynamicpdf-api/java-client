package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.FloatJsonSerializer;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.Resource;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents an image element.
 *
 * <p>This class can be used to place images on a page.</p>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class ImageElement extends Element {

	private Resource resource;
	private String resourceName;
	private float scaleX;
	private float scaleY;
	private float maxHeight;
	private float maxWidth;

	/**
	 * Initializes a new instance of the <code>ImageElement</code> class.
	 * @param resource <code>ImageResource</code> object containing the image resource.
	 * @param placement The placement of the image on the page.
	 * @param xOffset X coordinate of the image.
	 * @param yOffset Y coordinate of the image.
	 */
	public ImageElement(ImageResource resource, ElementPlacement placement, float xOffset, float yOffset) {
		super();
		this.resource = resource;
		this.resourceName = resource.getResourceName();
		setPlacement(placement);
		setXOffset(xOffset);
		setYOffset(yOffset);
	}
	
	/**
	 * Initializes a new instance of the <code>ImageElement</code> class.
	 * @param resource <code>ImageResource</code> object containing the image resource.
	 * @param xOffset X coordinate of the image.
	 * @param yOffset Y coordinate of the image.
	 */
	public ImageElement(ImageResource resource, float xOffset, float yOffset) {
		super();
		this.resource = resource;
		this.resourceName = resource.getResourceName();
		setPlacement(ElementPlacement.TOPLEFT);
		setXOffset(xOffset);
		setYOffset(yOffset);
	}

	/**
	 * Initializes a new instance of the <code>ImageElement</code> class.
	 * @param resource <code>ImageResource</code> object containing the image resource.
	 * @param placement The placement of the image on the page
	 */
	public ImageElement(ImageResource resource, ElementPlacement placement) {
		this(resource, placement, 0, 0);
	}
	
	/**
	 * Initializes a new instance of the <code>ImageElement</code> class.
	 * @param resource <code>ImageResource</code> object containing the image resource.
	 */
	public ImageElement(ImageResource resource) {
		this(resource, ElementPlacement.TOPLEFT, 0, 0);
	}

	/**
	 * Initializes a new instance of the <code>ImageElement</code> class.
	 * @param resourceName The name of the image resource.
	 * @param placement The placement of the image on the page.
	 * @param xOffset X coordinate of the image.
	 * @param yOffset Y coordinate of the image.
	 */
	public ImageElement(String resourceName, ElementPlacement placement, float xOffset, float yOffset) {
		super();
		this.resourceName = resourceName;
		setPlacement(placement);
		setXOffset(xOffset);
		setYOffset(yOffset);
	}
	
	/**
	 * Initializes a new instance of the <code>ImageElement</code> class.
	 * @param resourceName The name of the image resource.
	 * @param xOffset X coordinate of the image.
	 * @param yOffset Y coordinate of the image.
	 */
	public ImageElement(String resourceName, float xOffset, float yOffset) {
		super();
		this.resourceName = resourceName;
		setPlacement(ElementPlacement.TOPLEFT);
		setXOffset(xOffset);
		setYOffset(yOffset);
	}

	/**
	 * Initializes a new instance of the <code>ImageElement</code> class.
	 * @param resourceName The name of the image resource.
	 * @param placement The placement of the image on the page.
	 */
	public ImageElement(String resourceName, ElementPlacement placement) {
		this(resourceName, placement, 0, 0);
	}
	
	/**
	 * Initializes a new instance of the <code>ImageElement</code> class.
	 * @param resourceName The name of the image resource.
	 */
	public ImageElement(String resourceName) {
		this(resourceName, ElementPlacement.TOPLEFT, 0, 0);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.IMAGE;
	}

	@JsonIgnore
	public Resource getResource() {
		return resource;
	}

	void setResource(Resource value) {
		resource = value;
	}

	@JsonProperty("resourceName")
	String getResourceName() {
		return resourceName;
	}

	void setResourceName(String value) {
		resourceName = value;
	}

	/**
	 * Gets horizontal scale of the image.
	 * @return The horizontal scale of the image.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getScaleX() {
		return scaleX;
	}

	/**
	 * Sets the horizontal scale of the image.
	 * @param value The horizontal scale of the image.
	 */
	public void setScaleX(float value) {
		scaleX = value;
	}

	/**
	 * Gets the vertical scale of the image.
	 * @return The vertical scale of the image.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getScaleY() {
		return scaleY;
	}

	/**
	 * Sets the vertical scale of the image.
	 * @param value The vertical scale of the image.
	 */
	public void setScaleY(float value) {
		scaleY = value;
	}

	/**
	 * Gets the maximum height of the image.
	 * @return The maximum height of the image.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getMaxHeight() {
		return maxHeight;
	}

	/**
	 * Sets the maximum height of the image.
	 * @param value The maximum height of the image.
	 */
	public void setMaxHeight(float value) {
		maxHeight = value;
	}

	/**
	 * Gets the maximum width of the image.
	 * @return The maximum width of the image.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getMaxWidth() {
		return maxWidth;
	}

	/**
	 * Sets the maximum width of the image.
	 * @param value The maximum width of the image.
	 */
	public void setMaxWidth(float value) {
		maxWidth = value;
	}
}
