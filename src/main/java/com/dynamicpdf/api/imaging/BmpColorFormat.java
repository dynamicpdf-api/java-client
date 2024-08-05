package com.dynamicpdf.api.imaging;

    /**
     * Base class for BMP color formats
     */

public class BmpColorFormat extends ColorFormat {

    /**
     * Creates BmpColorFormat object with the given type.
     * @param type The color format type.
     */
    public BmpColorFormat(ColorFormatType type) {
        if (type != ColorFormatType.MONOCHROME)
            setType(ColorFormatType.RGB);
        else
            setType(type);
    }
}
