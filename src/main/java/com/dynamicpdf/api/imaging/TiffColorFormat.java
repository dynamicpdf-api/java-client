package com.dynamicpdf.api.imaging;

/**
 * Base class for TIFF color formats and used for RGB and Grayscale color formats.
 */
public class TiffColorFormat extends ColorFormat {

    /**
     * Initializes a new instance of the TiffColorFormat class with the specified color format type.
     * 
     * @param type The color format type.
     */
    public TiffColorFormat(ColorFormatType type) {
        setType(type);
    }
}
