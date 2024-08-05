package com.dynamicpdf.api.imaging;

/**
 * Base class for PNG color formats, used for RGB, RGBA, and Grayscale color formats.
 */
public class PngColorFormat extends ColorFormat {

    /**
     * Initializes a new instance of the PngColorFormat class.
     * @param type The color format type.
     */
    public PngColorFormat(ColorFormatType type) {
        setType(type);
    }
}
