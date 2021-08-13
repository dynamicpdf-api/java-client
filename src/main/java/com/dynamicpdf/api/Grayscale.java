package com.dynamicpdf.api;

public class Grayscale extends Color {

    private String colorString;
    private float grayLevel;

    Grayscale(String colorString) {
        setColorString(colorString);
    }

    public Grayscale(float grayLevel) {
        this.grayLevel = grayLevel;
    }

    /// <summary>Gets the color black.</summary>
    public static Grayscale getBlack() {
        return new Grayscale(0);
    }

    public static Grayscale getWhite() {
        return new Grayscale(1);
    }

    public String getColorString() {
        if (colorString != null) {
            return colorString;
        } else {
            return "gray(" + Float.toString(grayLevel) + ")";
        }

    }

    void setColorString(String value) {

        colorString = value;
    }
}
