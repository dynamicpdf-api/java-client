package com.dynamicpdf.api.imaging;

/**
 * Represents TIFF image format with color format.
 */
public class TiffImageFormat extends ImageFormat {

    private boolean multiPage = false;
    private TiffColorFormat colorFormat;

    /**
     * Initializes a new instance of the TiffImageFormat class.
     */
    public TiffImageFormat() {
        super(ImageFormatType.TIFF);
    }

    /**
     * Gets a value indicating whether the TIFF image format supports multiple pages.
     * 
     * @return true if the TIFF image format supports multiple pages; otherwise, false.
     */
    public boolean isMultiPage() {
        return multiPage;
    }

    /**
     * Sets a value indicating whether the TIFF image format supports multiple pages.
     * 
     * @param multiPage true if the TIFF image format supports multiple pages; otherwise, false.
     */
    public void setMultiPage(boolean multiPage) {
        this.multiPage = multiPage;
    }

    /**
     * Gets the color format for TIFF.
     * 
     * @return The color format for TIFF.
     */
    public TiffColorFormat getColorFormat() {
        return colorFormat;
    }

    /**
     * Sets the color format for TIFF.
     * 
     * @param colorFormat The color format for TIFF.
     */
    public void setColorFormat(TiffColorFormat colorFormat) {
        this.colorFormat = colorFormat;
    }
}
