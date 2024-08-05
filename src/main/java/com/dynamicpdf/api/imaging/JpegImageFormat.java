package com.dynamicpdf.api.imaging;

/**
 * Represents JPEG image format with quality.
 */
public class JpegImageFormat extends ImageFormat {
    private Integer quality;

    /**
     * Gets the quality of the JPEG image.
     * @return The quality of the JPEG image.
     * <p> The quality ranges from 0 to 100, where 0 indicates highly compressed and low quality and 100 indicates high quality and less compressed image.</p>
     */
    public Integer getQuality() {
        return quality;
    }

    /**
     * Sets the quality of the JPEG image.
     * @param quality The quality of the JPEG image.
     * <p> The quality ranges from 0 to 100, where 0 indicates highly compressed and low quality and 100 indicates high quality and less compressed image.</p>
     */
    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    /**
     * Initializes a new instance of the JpegImageFormat class.
     */
    public JpegImageFormat() {
        super(ImageFormatType.JPEG);
    }
}
