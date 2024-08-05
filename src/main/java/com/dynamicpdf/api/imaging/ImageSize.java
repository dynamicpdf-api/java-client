package com.dynamicpdf.api.imaging;

/**
 * Base class for image size types.
 */
public abstract class ImageSize {
    private ImageSizeType type;

    /**
     * Gets the type of the image size.
     * @return The type of the image size.
     */
    public ImageSizeType getType() {
        return type;
    }

    /**
     * Sets the type of the image size.
     * @param type The type of the image size.
     */
    public void setType(ImageSizeType type) {
        this.type = type;
    }
}
