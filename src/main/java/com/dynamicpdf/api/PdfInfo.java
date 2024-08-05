
package com.dynamicpdf.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Represents the pdf info endpoint.
 */

public class PdfInfo extends Endpoint
{
	private PdfResource resource;

	/**
	 * Initializes a new instance of the <code>PdfInfo</code> class.
	 * @param resource The resource of type <code>PdfResource</code>.
	 */

	public PdfInfo(PdfResource resource)
	{
		this.resource = resource;
	}

	public String getEndpointName() { return "pdf-info";}

	/**
	 * Process the pdf resource to get pdf's information.
	 * @return collection of <code>PdfInfoResponse</code> as multithreading tasks <code>Task</code>.
	 */
	public PdfInfoResponse process()
	{
		CompletableFuture<PdfInfoResponse> cf = processAsync();
		try {
			return cf.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
     * Process the pdf resource to get pdf's information.
     * 
     * @return collection of <code>PdfInfoResponse</code> as multithreading tasks <code>CompletableFuture</code>.
     */
	public CompletableFuture<PdfInfoResponse> processAsync()
	{
		return CompletableFuture.supplyAsync(() -> {
			PdfInfoResponse pdfInfoResponse = null;
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
				pdfInfoResponse = new PdfInfoResponse(response.asString());
				pdfInfoResponse.setIsSuccessful(true);
				pdfInfoResponse.setStatusCode(response.getStatusCode());
			}
			else
			{
				pdfInfoResponse = new PdfInfoResponse();
				pdfInfoResponse.setErrorJson(response.asString()); 
				pdfInfoResponse.setIsSuccessful(false);
				pdfInfoResponse.setStatusCode(response.getStatusCode());
			}
			return pdfInfoResponse;
		});
	}
}
