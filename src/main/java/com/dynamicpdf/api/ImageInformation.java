package com.dynamicpdf.api;

public class ImageInformation {

    private int pageNumber;
    private float width;
    private float height;
    private float horizondalDpi;
    private float verticalDpi;
    private float numberOfComponents;
    private float bitsPerComponent;
    private ColorSpaceType colorSpace;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int value) {
        pageNumber = value;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float value) {
        width = value;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float value) {
        height = value;
    }

    public float getHorizondalDpi() {
        return horizondalDpi;
    }

    public void setHorizondalDpi(float value) {
        horizondalDpi = value;
    }

    public float getVerticalDpi() {
        return verticalDpi;
    }

    public void setVerticalDpi(float value) {
        verticalDpi = value;
    }

    public float getNumberOfComponents() {
        return numberOfComponents;
    }

    public void setNumberOfComponents(float value) {
        numberOfComponents = value;
    }

    public float getBitsPerComponent() {
        return bitsPerComponent;
    }

    public void setBitsPerComponent(float value) {
        bitsPerComponent = value;
    }

    public ColorSpaceType getColorSpace() {
        return colorSpace;
    }

    public void setColorSpace(ColorSpaceType value) {
        colorSpace = value;
    }
}
