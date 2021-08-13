package com.dynamicpdf.api;

public class XmlResponse extends Response {

    private String content;

    public XmlResponse() {
    }

    public XmlResponse(String xmlContent) {
        content = xmlContent;
    }

    public String getContent() {
        return content;
    }

    private void setContent(String value) {
        content = value;
    }
}
