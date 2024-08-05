package com.dynamicpdf.api.imaging;

/**
 * Represents PNG image format with color format.
 */
public class PngImageFormat extends ImageFormat {
    private PngColorFormat colorFormat;

    /**
     * Gets the color format for PNG.
     * @return The color format for PNG.
     */
    public PngColorFormat getColorFormat() {
        return colorFormat;
    }

    /**
     * Sets the color format for PNG.
     * @param colorFormat The color format for PNG.
     */
    public void setColorFormat(PngColorFormat colorFormat) {
        this.colorFormat = colorFormat;
    }

    /**
     * Initializes a new instance of the PngImageFormat class.
     */
    public PngImageFormat() {
        super(ImageFormatType.PNG);
    }
}
