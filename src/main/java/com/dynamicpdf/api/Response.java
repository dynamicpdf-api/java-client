package com.dynamicpdf.api;

import java.util.UUID;

public class Response {

    private boolean isSuccessful;
    private String errorJson;
    private String errorMessage;
    private UUID errorId = null;
    private int statusCode;

    public boolean getIsSuccessful() {
        return isSuccessful;
    }

    void setIsSuccessful(boolean value) {
        isSuccessful = value;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    void setErrorMessage(String value) {
        errorMessage = value;
    }

    public UUID getErrorId() {
        return errorId;
    }

    void setErrorId(UUID value) {
        errorId = value;
    }

    public int getStatusCode() {
        return statusCode;
    }

    void setStatusCode(int value) {
        statusCode = value;
    }

    public String getErrorJson() {
        return errorJson;
    }

    void setErrorJson(String value) {
        errorJson = value;
    }
}
