package com.dynamicpdf.api.imaging;

/**
 * Represents indexed color format for PNG.
 */
public class PngIndexedColorFormat extends PngColorFormat {
    private QuantizationAlgorithm quantizationAlgorithm;
    private Integer ditheringPercent;
    private DitheringAlgorithm ditheringAlgorithm;

    /**
     * Gets the quantization algorithm for PNG.
     * @return The quantization algorithm for PNG.
     */
    public QuantizationAlgorithm getQuantizationAlgorithm() {
        return quantizationAlgorithm;
    }

    /**
     * Sets the quantization algorithm for PNG.
     * @param quantizationAlgorithm The quantization algorithm for PNG.
     */
    public void setQuantizationAlgorithm(QuantizationAlgorithm quantizationAlgorithm) {
        this.quantizationAlgorithm = quantizationAlgorithm;
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
     * Initializes a new instance of the PngIndexedColorFormat class with indexed color format type.
     */
    public PngIndexedColorFormat() {
        super(ColorFormatType.INDEXED);
    }
}
