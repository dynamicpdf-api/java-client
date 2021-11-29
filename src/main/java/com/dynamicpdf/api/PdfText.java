package com.dynamicpdf.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Represents the pdf text endpoint.
 */
public class PdfText extends Endpoint {

	PdfResource resource;
	private int startPage;
	private int pageCount;

	/**
	 * Initializes a new instance of the <code>PdfText</code> class.
	 * @param resource The image resource of type <code>PdfResource</code>
	 * @param startPage The start page.
	 * @param pageCount The page count.
	 */
	public PdfText(PdfResource resource, int startPage, int pageCount) {
		this.resource = resource;
		this.startPage = startPage;
		this.pageCount = pageCount;
	}

	/**
	 * Initializes a new instance of the <code>PdfText</code> class.
	 * @param resource The image resource of type <code>PdfResource</code>
	 */
	public PdfText(PdfResource resource) {
		this(resource, 1, 0);
	}

	String getEndpointName() {
		return "pdf-text";
	}

	/**
	 * Gets the start page.
	 * @return The start page.
	 */
	public int getStartPage() {
		return startPage;
	}

	/**
	 * Sets the start page.
	 * @param value The start page.
	 */
	public void setStartPage(int value) {
		startPage = value;
	}

	/**
	 * Gets the page count.
	 * @return The page count.
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * Sets the page count.
	 * @param value The page count.
	 */
	public void setPageCount(int value) {
		pageCount = value;
	}

	/**
	 * Process the pdf resource to get pdf's text.
	 * <p>PdfTextResponse</p>
	 * @return Pdf Text Response
	 */
	public PdfTextResponse process() {

		CompletableFuture<PdfTextResponse> cf = processAsync();
		try {
			return cf.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
     * Process the pdf resource to get pdf's text.
     * 
     * @return collection of <code>PdfTextResponse</code> as multithreading tasks <code>CompletableFuture</code>.
     */
	public CompletableFuture<PdfTextResponse> processAsync()
	{
		return CompletableFuture.supplyAsync(() -> {
			PdfTextResponse pdfTextResponse = null;
			RequestSpecification requestSpec = super.createRequestSpecification();
			Response response = RestAssured
					.given()
					.header("Accept", "application/pdf")
					.header("content-type", "application/pdf")
					.spec(requestSpec)
					.queryParam("StartPage", String.valueOf(startPage))
					.queryParam("PageCount", String.valueOf(pageCount))
					.body(resource.getData())
					.post(getDefaultBaseUrl() + "/"+ getEndpointVersion() + "/"  + getEndpointName());

			if (response.getStatusCode() == 200) {
				pdfTextResponse = new PdfTextResponse(response.asString());
				pdfTextResponse.setIsSuccessful(true);
				pdfTextResponse.setStatusCode(response.getStatusCode());
			} else {
				pdfTextResponse = new PdfTextResponse();
				pdfTextResponse.setErrorJson(response.asString());
				pdfTextResponse.setIsSuccessful(false);
				pdfTextResponse.setStatusCode(response.getStatusCode());
			}
			return pdfTextResponse;
		});
	}

}
