
package com.dynamicpdf.api;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Represents the pdf xmp endpoint.
 */
public class PdfXmp extends Endpoint
{
	PdfResource resource;

	/**
	 * Initializes a new instance of the <code>PdfXmp</code> class.
	 * @param resource The image resource of type <code>PdfResource</code>
	 */
	public PdfXmp(PdfResource resource)
	{
		this.resource = resource;
	}

	public String getEndpointName() { return "pdf-xmp";}


	/**
	 * Process the pdf resource to get pdf's xmp data.
	 * <p> XmlResponse </p>
	 * @return Xml Response
	 */
	public XmlResponse process()
	{
		CompletableFuture<XmlResponse> cf = processAsync();
		try {
			return cf.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
     * Process the pdf resource to get pdf's xmp data.
     * 
     * @return collection of <code>XmlResponse</code> as multithreading tasks <code>CompletableFuture</code>.
     */
	public CompletableFuture<XmlResponse> processAsync()
	{
		return CompletableFuture.supplyAsync(() -> {
			XmlResponse xmlResponse = null;
			RequestSpecification requestSpec = super.createRequestSpecification();
			Response response = RestAssured
					.given()
					.header("Accept", "application/pdf")
					.header("content-type", "application/pdf")
					.spec(requestSpec)
					.body(resource.getData())
					.post(getDefaultBaseUrl() + "/"+ getEndpointVersion() + "/"  + getEndpointName());

			if (response.getStatusCode() == 200)
			{
				xmlResponse = new XmlResponse(response.asString());
				xmlResponse.setIsSuccessful(true);
				xmlResponse.setStatusCode(response.getStatusCode());
			}
			else
			{
				if (response.getStatusCode() == 401) {
					throw new EndpointException("Invalid api key specified.");
				}	
				xmlResponse = new XmlResponse();
				String errorMessage = response.jsonPath().getString("message");
				UUID errorId = response.jsonPath().getUUID("id");
				xmlResponse.setErrorId(errorId);
				xmlResponse.setErrorJson(response.asString());
				xmlResponse.setErrorMessage(errorMessage);
				xmlResponse.setIsSuccessful(false);
				xmlResponse.setStatusCode(response.getStatusCode());
			}
			return xmlResponse;
		});
	}
}

