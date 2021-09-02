
package com.dynamicpdf.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Represents a Dlex layout endpoint.
 */

public class DlexLayout extends Endpoint
{
	private LayoutDataResource resource;
	private String dlexPath;

	/**
	 * Initializes a new instance of the <code>DlexLayout</code> class using the 
	 * DLEX file path present in the cloud environment and the JSON data for the PDF report.
	 * @param cloudDlexPath The DLEX file path present in the resource manager.
	 * @param layoutData The <code>LayoutDataResource</code>, json data file used to create the PDF report.
	 */

	public DlexLayout(String cloudDlexPath, LayoutDataResource layoutData) { 
		super();        
		dlexPath = cloudDlexPath;
		this.resource = layoutData;
	}

	String getEndpointName() { return "dlex-layout";}

	/**
	 * Gets the DLEX file path present in the resource manager.
	 * @return The DLEX file path present in the resource manager.
	 */
	public String getDlexPath() { return dlexPath; }

	/**
	 * Sets the DLEX file path present in the resource manager.
	 * @param value The DLEX file path present in the resource manager.
	 */
	public void setDlexPath(String value) { dlexPath = value; }

	/**
	 * Process the DLEX and layout data to create PDF report.
	 * @return Pdf Response
	 */
	public PdfResponse process()
	{
		CompletableFuture<PdfResponse> cf = processAsync();
		try {
			return cf.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
     *  Process the DLEX and layout data to create PDF report.
     * 
     * @return collection of <code>PdfResponse</code> as multithreading tasks <code>CompletableFuture</code>.
     */
	public CompletableFuture<PdfResponse> processAsync()
	{
		return CompletableFuture.supplyAsync(() -> {
			PdfResponse pdfResponse = null;
			RequestSpecification requestSpec = super.createRequestSpecification();

			if(resource != null)
				requestSpec.multiPart("LayoutData", resource.getLayoutDataResourceName(), resource.getData(),resource.getMimeType());
			if (dlexPath != null)
				requestSpec.param("DlexPath" , dlexPath);

			Response response = RestAssured
					.given()
					.header("Accept", "application/json*")
					.header("Content-Type","multipart/form-data")
					.spec(requestSpec)
					.body(resource.getData())
					.post(getDefaultBaseUrl() + "/" + getEndpointName());

			if (response.getStatusCode() == 200)
			{
				pdfResponse = new PdfResponse(response.asByteArray());
				pdfResponse.setIsSuccessful(true);
				pdfResponse.setStatusCode(response.getStatusCode());
			}
			else
			{
				pdfResponse = new PdfResponse();
				pdfResponse.setErrorJson(response.asString()); 
				pdfResponse.setIsSuccessful(false);
				pdfResponse.setStatusCode(response.getStatusCode());
			}
			return pdfResponse;
		});
	}
}

