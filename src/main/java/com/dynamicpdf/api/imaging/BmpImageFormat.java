package com.dynamicpdf.api.imaging;

public class BmpImageFormat extends ImageFormat {

    private BmpColorFormat colorFormat;

     /**
     * Gets the Bmp Color Format.
     * 
     * @return color Format
     */
    public BmpColorFormat getColorFormat() {
        return colorFormat;
    }

     /**
     * Sets the Bmp Color Format.
     * 
     * @param colorFormat The color format.
     */
    public void setColorFormat(BmpColorFormat colorFormat) {
        this.colorFormat = colorFormat;
    }

    public BmpImageFormat() {
        super(ImageFormatType.BMP);
    }
}