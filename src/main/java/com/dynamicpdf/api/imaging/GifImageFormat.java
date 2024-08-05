package com.dynamicpdf.api.imaging;

/**
 * Represents GIF image format with dithering properties.
 */
public class GifImageFormat extends ImageFormat {
    private Integer ditheringPercent;
    private DitheringAlgorithm ditheringAlgorithm;

    /**
     * Gets the dithering percentage.
     * @return The dithering percentage.
     */
    public Integer getDitheringPercent() {
        return ditheringPercent;
    }

    /**
     * Sets the dithering percentage.
     * @param ditheringPercent The dithering percentage.
     */
    public void setDitheringPercent(Integer ditheringPercent) {
        this.ditheringPercent = ditheringPercent;
    }

    /**
     * Gets the dithering algorithm.
     * @return The dithering algorithm.
     */
    public DitheringAlgorithm getDitheringAlgorithm() {
        return ditheringAlgorithm;
    }

    /**
     * Sets the dithering algorithm.
     * @param ditheringAlgorithm The dithering algorithm.
     */
    public void setDitheringAlgorithm(DitheringAlgorithm ditheringAlgorithm) {
        this.ditheringAlgorithm = ditheringAlgorithm;
    }

    /**
     * Initializes a new instance of the GifImageFormat class and sets the image format type to GIF.
     */
    public GifImageFormat() {
        super(ImageFormatType.GIF);
    }
}
