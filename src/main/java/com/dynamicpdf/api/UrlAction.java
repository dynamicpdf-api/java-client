package com.dynamicpdf.api;

public class UrlAction extends Action {

    String url;

    public UrlAction(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
