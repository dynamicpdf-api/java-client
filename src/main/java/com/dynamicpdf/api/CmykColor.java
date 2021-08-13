package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class CmykColor extends Color {

    private float cyan = 0;
    private float magenta = 0;
    private float yellow = 0;
    private float black = 0;
    private String colorString;

    CmykColor(String colorString) {
        setColorString(colorString);
    }

    public CmykColor(float cyan, float magenta, float yellow, float black) {
        if (cyan < 0.0f || cyan > 1.0f || magenta < 0.0f || magenta > 1.0f || yellow < 0.0f || yellow > 1.0f || black < 0.0f || black > 1.0f) {
            throw new EndpointException("CMYK values must be from 0.0 to 1.0.");
        }
        this.cyan = cyan;
        this.magenta = magenta;
        this.yellow = yellow;
        this.black = black;
    }

    public static CmykColor getBlack() {
        return new CmykColor(1, 1, 1, 1);
    }

    public static CmykColor getWhite() {
        return new CmykColor(0, 0, 0, 0);
    }

    @JsonProperty("colorString")
    public String getColorString() {
        if (colorString != null) {
            return colorString;
        } else {
            return "cmyk(" + Float.toString(cyan) + "," + Float.toString(magenta) + "," + Float.toString(yellow) + "," + Float.toString(black) + ")";
        }
    }

    void setColorString(String value) {
        colorString = value;

    }

}
