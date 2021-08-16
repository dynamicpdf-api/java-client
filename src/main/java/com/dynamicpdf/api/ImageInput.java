package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ImageInput extends Input {

    private float scaleX;
    private float scaleY;
    private float topMargin;
    private float leftMargin;
    private float bottomMargin;
    private float rightMargin;
    private float pageWidth;
    private float pageHeight;
    private boolean expandToFit;
    private boolean shrinkToFit;
    private Align align = Align.CENTER;
    private VAlign vAlign = VAlign.CENTER;
    private int startPage;
    private int pageCount;

    public ImageInput(ImageResource resource) {
        super(resource);
    }

    public ImageInput(String cloudResourcePath) {
        super(cloudResourcePath);
    }

    @JsonProperty("type")
    InputType getType() {
        return InputType.IMAGE;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float value) {
        scaleX = value;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float value) {
        scaleY = value;
    }

    public float getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(float value) {
        topMargin = value;
    }

    public float getLeftMargin() {
        return leftMargin;
    }

    public void setLeftMargin(float value) {
        leftMargin = value;
    }

    public float getBottomMargin() {
        return bottomMargin;
    }

    public void setBottomMargin(float value) {
        bottomMargin = value;
    }

    public float getRightMargin() {
        return rightMargin;
    }

    public void setRightMargin(float value) {
        rightMargin = value;
    }

    public float getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(float value) {
        pageWidth = value;
    }

    public float getPageHeight() {
        return pageHeight;
    }

    public void setPageHeight(float value) {
        pageHeight = value;
    }

    public boolean getExpandToFit() {
        return expandToFit;
    }

    public void setExpandToFit(boolean value) {
        expandToFit = value;
    }

    public boolean getShrinkToFit() {
        return shrinkToFit;
    }

    public void setShrinkToFit(boolean value) {
        shrinkToFit = value;
    }

    public Align getAlign() {
        return align;
    }

    public void setAlign(Align value) {
        align = value;
    }

    @JsonProperty("vAlign")
    public VAlign getVAlign() {
        return vAlign;
    }

    public void setVAlign(VAlign value) {
        vAlign = value;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setSatrtPage(int value) {
        startPage = value;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int value) {
        pageCount = value;
    }
}
