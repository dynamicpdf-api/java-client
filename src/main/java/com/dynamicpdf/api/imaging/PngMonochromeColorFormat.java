package com.dynamicpdf.api.imaging;

/**
 * Represents monochrome color format for PNG with black threshold.
 */
public class PngMonochromeColorFormat extends PngColorFormat {
    private Integer blackThreshold;
    private Integer ditheringPercent;
    private DitheringAlgorithm ditheringAlgorithm;

    /**
     * Gets the black threshold for monochrome PNG, ranges from 0-255.
     * @return The black threshold for monochrome PNG.
     */
    public Integer getBlackThreshold() {
        return blackThreshold;
    }

    /**
     * Sets the black threshold for monochrome PNG, ranges from 0-255.
     * @param blackThreshold The black threshold for monochrome PNG.
     */
    public void setBlackThreshold(Integer blackThreshold) {
        this.blackThreshold = blackThreshold;
    }

    /**
     * Gets the dithering percentage for PNG.
     * @return The dithering percentage for PNG.
     */
    public Integer getDitheringPercent() {
        return ditheringPercent;
    }

    /**
     * Sets the dithering percentage for PNG.
     * @param ditheringPercent The dithering percentage for PNG.
     */
    public void setDitheringPercent(Integer ditheringPercent) {
        this.ditheringPercent = ditheringPercent;
    }

    /**
     * Gets the dithering algorithm for PNG.
     * @return The dithering algorithm for PNG.
     */
    public DitheringAlgorithm getDitheringAlgorithm() {
        return ditheringAlgorithm;
    }

    /**
     * Sets the dithering algorithm for PNG.
     * @param ditheringAlgorithm The dithering algorithm for PNG.
     */
    public void setDitheringAlgorithm(DitheringAlgorithm ditheringAlgorithm) {
        this.ditheringAlgorithm = ditheringAlgorithm;
    }

    /**
     * Initializes a new instance of the PngMonochromeColorFormat class with monochrome color format type.
     */
    public PngMonochromeColorFormat() {
        super(ColorFormatType.MONOCHROME);
    }
}
