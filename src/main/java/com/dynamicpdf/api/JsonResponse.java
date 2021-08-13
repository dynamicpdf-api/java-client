package com.dynamicpdf.api;

public abstract class JsonResponse extends Response {

    private String jsonContent;

    JsonResponse() {
    }

    JsonResponse(String jsonContent) {
        this.jsonContent = jsonContent;
    }

    public String getJsonContent() {
        return jsonContent;
    }

    private void setJsonContent(String value) {
        jsonContent = value;
    }
}
