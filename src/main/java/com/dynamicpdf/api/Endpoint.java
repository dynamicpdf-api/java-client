package com.dynamicpdf.api;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.specification.RequestSpecification;

/**
 * Represents the base class for endpoint and has settings for base url, 
 * api key and creates a rest request object.
 */

public abstract class Endpoint {

	private RequestSpecification requestSpec;;

	private static String endPointVersion = "v1.0";
	private static String defaultBaseUrl = "https://api.dynamicpdf.com";
	private static String defaultApiKey;
	private String baseUrl = defaultBaseUrl;
	private String apiKey = defaultApiKey;

	Endpoint() {
	}

	RequestSpecification getRequestSpecification() { return requestSpec; }

	void setRequestSpecification(RequestSpecification value) { requestSpec = value; }

	abstract String getEndpointName();

    String getEndpointVersion() { 
		return endPointVersion;
	}
	/**
	 * Gets default base url.
	 * @return Default base url
	 */
	public static String getDefaultBaseUrl() {
		return defaultBaseUrl;
	}

	/**
	 * Sets default base url.
	 * @param value Default base url.
	 */
	public static void setDefaultBaseUrl(String value) {
		defaultBaseUrl = value;
	}

	/**
	 * Gets default api key.
	 * @return Default api key.
	 */
	public static String getDefaultApiKey() {
		return defaultApiKey;
	}

	/**
	 * Sets default api key.
	 * @param value Default api key.
	 */
	public static void setDefaultApiKey(String value) {
		defaultApiKey = value;
	}

	/**
	 * Gets base url for the api.
	 * @return Base url for the api.
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * Sets base url for the api.
	 * @param value Base url for the api.
	 */
	public void setBaseUrl(String value) {
		baseUrl = value;
	}

	/**
	 * Gets api key.
	 * @return Api key.
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * Sets api key.
	 * @param value Api key.
	 */
	public void setApiKey(String value) {
		apiKey = value;
	}

	/**
	 * Initializing the request specification.
	 * @return Request specification
	 */
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
