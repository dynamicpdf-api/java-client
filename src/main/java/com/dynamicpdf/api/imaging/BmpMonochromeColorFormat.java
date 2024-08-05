package com.dynamicpdf.api.imaging;

/**
 * Represents monochrome color format for BMP.
 */
public class BmpMonochromeColorFormat extends BmpColorFormat {

    private Integer blackThreshold;
    private Integer ditheringPercent;
    private DitheringAlgorithm ditheringAlgorithm;

    /**
     * Creates object for monochrome color format for BMP image format.
     */
    public BmpMonochromeColorFormat() {
        super(ColorFormatType.MONOCHROME);
    }

    /**
     * Gets the black threshold for monochrome BMP, ranges from 0-255.
     * 
     * @return The black threshold.
     */
    public Integer getBlackThreshold() {
        return blackThreshold;
    }

    /**
     * Sets the black threshold for monochrome BMP, ranges from 0-255.
     * 
     * @param blackThreshold The black threshold.
     */
    public void setBlackThreshold(Integer blackThreshold) {
        this.blackThreshold = blackThreshold;
    }

    
    /**
     * Gets the dithering percentage for BMP.
     * 
     * @return The dithering percentage.
     */
    public Integer getDitheringPercent() {
        return ditheringPercent;
    }

    /**
     * Sets the dithering percentage for BMP.
     * 
     * @param ditheringPercent The dithering percentage.
     */
    public void setDitheringPercent(Integer ditheringPercent) {
        this.ditheringPercent = ditheringPercent;
    }

    /**
     * Gets the dithering algorithm for BMP.
     * 
     * @return The dithering algorithm.
     */
    public DitheringAlgorithm getDitheringAlgorithm() {
        return ditheringAlgorithm;
    }

    /**
     * Sets the dithering algorithm for BMP.
     * 
     * @param ditheringAlgorithm The dithering algorithm.
     */
    public void setDitheringAlgorithm(DitheringAlgorithm ditheringAlgorithm) {
        this.ditheringAlgorithm = ditheringAlgorithm;
    }
}
