package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoToAction extends Action {

    private String inputID;
    private int pageOffset;
    private PageZoom pageZoom;
    private Input input;

    public GoToAction(Input input, int pageOffset, PageZoom pageZoom) {
        this.input = input;
        this.inputID = input.getId();
        this.pageOffset = pageOffset;
        this.pageZoom = pageZoom;
    }

    public GoToAction(Input input) {
        this(input, 0, PageZoom.FITPAGE);
    }

    public GoToAction(Input input, int pageOffset) {
        this(input, pageOffset, PageZoom.FITPAGE);
    }
    
    Input getInput() {
        return input;
    }

    void setInput(Input value) {
        input = value;
    }

    @JsonProperty("inputID")
    String getInputID() {
        return inputID;
    }

    void setInputID(String value) {
        inputID = value;
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int value) {
        this.pageOffset = value;
    }

    public PageZoom getPageZoom() {
        return pageZoom;
    }

    public void setPageZoom(PageZoom value) {
        this.pageZoom = value;
    }

}
