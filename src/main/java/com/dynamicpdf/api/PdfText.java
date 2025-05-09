package com.dynamicpdf.api;

import java.util.UUID;
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
	private TextOrder textOrder;

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
	 * @param startPage The start page.
	 * @param pageCount The page count.
	 * @param textOrder The text extraction order
	 */

	public PdfText(PdfResource resource, int startPage, int pageCount, TextOrder textOrder) {
		this.resource = resource;
		this.startPage = startPage;
		this.pageCount = pageCount;
		this.textOrder = textOrder;
	}
	
	/**
	 * Initializes a new instance of the <code>PdfText</code> class.
	 * @param resource The image resource of type <code>PdfResource</code>
	 */
	public PdfText(PdfResource resource) {
		this(resource, 1, 0, TextOrder.Stream);
	}

	public String getEndpointName() {
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
	 * Gets the text extraction order.
	 * @return The text order.
	 */
	public TextOrder getTextOrder() {
		return textOrder;
	}

	/**
	 * Sets the text extraction order.
	 * @param textOrder The text order.
	 */
	public void setTextOrder(TextOrder textOrder) {
		this.textOrder = textOrder;
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
					.queryParam("TextOrder", String.valueOf(textOrder))
					.body(resource.getData())
					.post(getDefaultBaseUrl() + "/"+ getEndpointVersion() + "/"  + getEndpointName());

			if (response.getStatusCode() == 200) {
				pdfTextResponse = new PdfTextResponse(response.asString());
				pdfTextResponse.setIsSuccessful(true);
				pdfTextResponse.setStatusCode(response.getStatusCode());
			} else {
				if (response.getStatusCode() == 401) {
					throw new EndpointException("Invalid api key specified.");
				}
				pdfTextResponse = new PdfTextResponse();
				String errorMessage = response.jsonPath().getString("message");
				UUID errorId = response.jsonPath().getUUID("id");
				pdfTextResponse.setErrorId(errorId);
				pdfTextResponse.setErrorJson(response.asString());
				pdfTextResponse.setErrorMessage(errorMessage);
				pdfTextResponse.setIsSuccessful(false);
				pdfTextResponse.setStatusCode(response.getStatusCode());
			}
			return pdfTextResponse;
		});
	}
}
