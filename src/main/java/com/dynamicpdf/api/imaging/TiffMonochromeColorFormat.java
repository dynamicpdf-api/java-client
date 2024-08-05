package com.dynamicpdf.api.imaging;

/**
 * Represents monochrome color format for TIFF with black threshold and compression type.
 */
public class TiffMonochromeColorFormat extends TiffColorFormat {

    private Integer blackThreshold;
    private CompressionType compressionType;
    private Integer ditheringPercent;
    private DitheringAlgorithm ditheringAlgorithm;

    /**
     * Initializes a new instance of the TiffMonochromeColorFormat class with monochrome color format type.
     */
    public TiffMonochromeColorFormat() {
        super(ColorFormatType.MONOCHROME);
    }

    /**
     * Gets the black threshold for monochrome TIFF, ranges from 0-255.
     * 
     * @return The black threshold.
     */
    public Integer getBlackThreshold() {
        return blackThreshold;
    }

    /**
     * Sets the black threshold for monochrome TIFF, ranges from 0-255.
     * 
     * @param blackThreshold The black threshold.
     */
    public void setBlackThreshold(Integer blackThreshold) {
        this.blackThreshold = blackThreshold;
    }

    /**
     * Gets the compression type for monochrome TIFF.
     * 
     * @return The compression type.
     */
    public CompressionType getCompressionType() {
        return compressionType;
    }

    /**
     * Sets the compression type for monochrome TIFF.
     * 
     * @param compressionType The compression type.
     */
    public void setCompressionType(CompressionType compressionType) {
        this.compressionType = compressionType;
    }

    /**
     * Gets the dithering percentage for TIFF.
     * 
     * @return The dithering percentage.
     */
    public Integer getDitheringPercent() {
        return ditheringPercent;
    }

    /**
     * Sets the dithering percentage for TIFF.
     * 
     * @param ditheringPercent The dithering percentage.
     */
    public void setDitheringPercent(Integer ditheringPercent) {
        this.ditheringPercent = ditheringPercent;
    }

    /**
     * Gets the dithering algorithm for TIFF.
     * 
     * @return The dithering algorithm.
     */
    public DitheringAlgorithm getDitheringAlgorithm() {
        return ditheringAlgorithm;
    }

    /**
     * Sets the dithering algorithm for TIFF.
     * 
     * @param ditheringAlgorithm The dithering algorithm.
     */
    public void setDitheringAlgorithm(DitheringAlgorithm ditheringAlgorithm) {
        this.ditheringAlgorithm = ditheringAlgorithm;
    }
}
