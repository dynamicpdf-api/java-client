package com.dynamicpdf.api;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.specification.RequestSpecification;

public abstract class Endpoint {

    private RequestSpecification requestSpec;;

    private static String defaultBaseUrl = "https://api.dynamicpdf.com/v1.0";
    private static String defaultApiKey;
    private String baseUrl = defaultBaseUrl;
    private String apiKey = defaultApiKey;

    Endpoint() {
    }

    RequestSpecification getRequestSpecification() { return requestSpec; }

    void setRequestSpecification(RequestSpecification value) { requestSpec = value; }

    abstract String getEndpointName();

    public static String getDefaultBaseUrl() {
        return defaultBaseUrl;
    }

    public static void setDefaultBaseUrl(String value) {
        defaultBaseUrl = value;
    }

    public static String getDefaultApiKey() {
        return defaultApiKey;
    }

    public static void setDefaultApiKey(String value) {
        defaultApiKey = value;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String value) {
        baseUrl = value;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String value) {
        apiKey = value;
    }

    protected RequestSpecification createRequestSpecification() {
    	EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);

		RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);
		RestAssured.useRelaxedHTTPSValidation();
		requestSpec = RestAssured.given()
				.header("Authorization", "Bearer "+ getApiKey());
		return requestSpec;
    }

}
