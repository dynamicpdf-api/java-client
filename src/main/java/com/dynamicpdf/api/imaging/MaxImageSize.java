package com.dynamicpdf.api.imaging;

/**
 * Represents an image size that fits within a specified maximum width and height.
 */
public class MaxImageSize extends ImageSize {
    private Integer maxWidth;
    private Integer maxHeight;
    private ImageSizeUnit unit;

    /**
     * Gets the maximum width of the image.
     * @return The maximum width of the image.
     */
    public Integer getMaxWidth() {
        return maxWidth;
    }

    /**
     * Sets the maximum width of the image.
     * @param maxWidth The maximum width of the image.
     */
    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * Gets the maximum height of the image.
     * @return The maximum height of the image.
     */
    public Integer getMaxHeight() {
        return maxHeight;
    }

    /**
     * Sets the maximum height of the image.
     * @param maxHeight The maximum height of the image.
     */
    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * Gets the unit of measurement for the maximum width and height.
     * @return The unit of measurement for the maximum width and height.
     */
    public ImageSizeUnit getUnit() {
        return unit;
    }

    /**
     * Sets the unit of measurement for the maximum width and height.
     * @param unit The unit of measurement for the maximum width and height.
     */
    public void setUnit(ImageSizeUnit unit) {
        this.unit = unit;
    }

    /**
     * Initializes a new instance of the MaxImageSize class.
     */
    public MaxImageSize() {
        setType(ImageSizeType.MAX);
    }
}
