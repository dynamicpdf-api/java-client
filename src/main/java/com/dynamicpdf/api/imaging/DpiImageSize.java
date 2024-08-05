package com.dynamicpdf.api.imaging;

/**
 * Represents an image size defined by DPI (Dots Per Inch).
 */
public class DpiImageSize extends ImageSize {

    private Integer horizontalDpi;
    private Integer verticalDpi;

    public DpiImageSize() {
        setType(ImageSizeType.DPI);
    }

    /**
     * Gets the horizontal DPI (Dots Per Inch) of the image.
     * @return The horizontal Dpi of the image.
     */
    public Integer getHorizontalDpi() {
        return horizontalDpi;
    }

    /**
     * Sets the horizontal DPI (Dots Per Inch) of the image.
     * @param horizontalDpi Dpi The width of the image.
     */
    public void setHorizontalDpi(Integer horizontalDpi) {
        this.horizontalDpi = horizontalDpi;
    }

     /**
     * Gets the vertical DPI (Dots Per Inch) of the image.
     * @return The vertical Dpi of the image.
     */
    public Integer getVerticalDpi() {
        return verticalDpi;
    }

    /**
     * Sets the vertical DPI (Dots Per Inch) of the image.
     * @param verticalDpi The vertical Dpi of the image.
     */
    public void setVerticalDpi(Integer verticalDpi) {
        this.verticalDpi = verticalDpi;
    }
}
