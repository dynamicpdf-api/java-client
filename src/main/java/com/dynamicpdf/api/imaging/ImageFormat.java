package com.dynamicpdf.api.imaging;

/**
 * Base class for image formats.
 */
public abstract class ImageFormat {
    private final ImageFormatType type;

    /**
     * Gets the image format type.
     * @return The image format type.
     */
    public ImageFormatType getType() {
        return type;
    }

    /**
     * Initializes a new instance of the ImageFormat class with the specified image format type.
     * @param type The image format type.
     */
    public ImageFormat(ImageFormatType type) {
        this.type = type;
    }
}
