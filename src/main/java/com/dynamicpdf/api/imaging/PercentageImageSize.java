package com.dynamicpdf.api.imaging;

/**
 * Represents an image size based on percentage scaling.
 */
public class PercentageImageSize extends ImageSize {
    private Integer horizontalPercentage;
    private Integer verticalPercentage;

    /**
     * Gets the horizontal scaling percentage.
     * @return The horizontal scaling percentage.
     */
    public Integer getHorizontalPercentage() {
        return horizontalPercentage;
    }

    /**
     * Sets the horizontal scaling percentage.
     * @param horizontalPercentage The horizontal scaling percentage.
     */
    public void setHorizontalPercentage(Integer horizontalPercentage) {
        this.horizontalPercentage = horizontalPercentage;
    }

    /**
     * Gets the vertical scaling percentage.
     * @return The vertical scaling percentage.
     */
    public Integer getVerticalPercentage() {
        return verticalPercentage;
    }

    /**
     * Sets the vertical scaling percentage.
     * @param verticalPercentage The vertical scaling percentage.
     */
    public void setVerticalPercentage(Integer verticalPercentage) {
        this.verticalPercentage = verticalPercentage;
    }

    /**
     * Initializes a new instance of the PercentageImageSize class.
     */
    public PercentageImageSize() {
        setType(ImageSizeType.PERCENTAGE);
    }
}
