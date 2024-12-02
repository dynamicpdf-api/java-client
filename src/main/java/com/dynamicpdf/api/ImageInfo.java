
package com.dynamicpdf.api;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Represents an image information endpoint.
 */

public class ImageInfo extends Endpoint
{
	private ImageResource resource;

	/**
	 * Initializes a new instance of the <code>ImageInfo</code> class.
	 * @param resource The image resource of type <code>ImageResource</code>.
	 */

	public ImageInfo(ImageResource resource)
	{
		this.resource = resource;
	}

	public String getEndpointName() { return "image-info";}

	/**
	 * Process the image resource to get image's information.
	 * @return The image resource to get image's information.
	 */
	public ImageResponse process()
	{
		CompletableFuture<ImageResponse> cf = processAsync();
		try {
			return cf.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
     * Process the pdf resource to get image's information.
     * 
     * @return collection of <code>ImageResponse</code> as multithreading tasks <code>CompletableFuture</code>.
     */
	public CompletableFuture<ImageResponse> processAsync()
	{
		return CompletableFuture.supplyAsync(() -> {
			ImageResponse imageResponse = null;
			RequestSpecification requestSpec = super.createRequestSpecification();
			Response response = RestAssured
					.given()
					.header("Accept", "*/*")
					.header("content-type", resource.mimeType)
					.spec(requestSpec)
					.body(resource.getData())
					.post(getDefaultBaseUrl() + "/"+ getEndpointVersion() + "/"  + getEndpointName());

			if (response.getStatusCode() == 200)
			{
				imageResponse = new ImageResponse(response.asString());
				imageResponse.setIsSuccessful(true);
				imageResponse.setStatusCode(response.getStatusCode());
			}
			else
			{
				if (response.getStatusCode() == 401) {
					throw new EndpointException("Invalid api key specified.");
				}
				imageResponse = new ImageResponse();
				String errorMessage = response.jsonPath().getString("message");
				UUID errorId = response.jsonPath().getUUID("id");
				imageResponse.setErrorId(errorId);
				imageResponse.setErrorJson(response.asString());
				imageResponse.setErrorMessage(errorMessage);
				imageResponse.setIsSuccessful(false);
				imageResponse.setStatusCode(response.getStatusCode());
			}
			return imageResponse;
		});
	}

}
