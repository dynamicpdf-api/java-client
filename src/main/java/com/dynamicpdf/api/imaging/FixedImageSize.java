package com.dynamicpdf.api.imaging;

/**
 * Represents an image size with fixed dimensions.
 */
public class FixedImageSize extends ImageSize {
    private Integer width;
    private Integer height;
    private ImageSizeUnit unit;

    /**
     * Gets the width of the image.
     * @return The width of the image.
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the width of the image.
     * @param width The width of the image.
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * Gets the height of the image.
     * @return The height of the image.
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Sets the height of the image.
     * @param height The height of the image.
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Gets the unit of measurement for the width and height.
     * @return The unit of measurement for the width and height.
     */
    public ImageSizeUnit getUnit() {
        return unit;
    }

    /**
     * Sets the unit of measurement for the width and height.
     * @param unit The unit of measurement for the width and height.
     */
    public void setUnit(ImageSizeUnit unit) {
        this.unit = unit;
    }

    /**
     * Initializes a new instance of the FixedImageSize class and sets the image size type to Fixed.
     */
    public FixedImageSize() {
        setType(ImageSizeType.FIXED);
    }
}
