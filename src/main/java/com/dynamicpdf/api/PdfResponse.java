package com.dynamicpdf.api;

public class PdfResponse extends Response {

    private byte[] content;

    public PdfResponse() {
    }

    public PdfResponse(byte[] pdfContent) {
        content = pdfContent;
    }

    public byte[] getContent() {
        return content;
    }

    private void setContent(byte[] value) {
        content = value;
    }
}
