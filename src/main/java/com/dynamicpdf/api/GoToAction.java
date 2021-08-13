package com.dynamicpdf.api;

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
        this(input, 0, PageZoom.FitPage);
    }

    Input getInput() {
        return input;
    }

    void setInput(Input value) {
        input = value;
    }

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
