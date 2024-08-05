package com.dynamicpdf.api.imaging;

/**
 * Represents indexed color format for TIFF.
 */
public class TiffIndexedColorFormat extends TiffColorFormat {

    private QuantizationAlgorithm quantizationAlgorithm;
    private Integer ditheringPercent;
    private DitheringAlgorithm ditheringAlgorithm;

    /**
     * Initializes a new instance of the TiffIndexedColorFormat class with indexed color format type.
     */
    public TiffIndexedColorFormat() {
        super(ColorFormatType.INDEXED);
    }

    /**
     * Gets the quantization algorithm for TIFF.
     * 
     * @return The quantization algorithm.
     */
    public QuantizationAlgorithm getQuantizationAlgorithm() {
        return quantizationAlgorithm;
    }

    /**
     * Sets the quantization algorithm for TIFF.
     * 
     * @param quantizationAlgorithm The quantization algorithm.
     */
    public void setQuantizationAlgorithm(QuantizationAlgorithm quantizationAlgorithm) {
        this.quantizationAlgorithm = quantizationAlgorithm;
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
