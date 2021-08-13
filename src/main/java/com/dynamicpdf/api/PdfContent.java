package com.dynamicpdf.api;

public class PdfContent {

    private int pageNumber;
    private String text;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int value) {
        pageNumber = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String value) {
        text = value;
    }
}
