package com.dynamicpdf.api;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
Represents the pdf security info endpoint.
 */
public class PdfSecurityInfoEndpoint extends Endpoint {
    private PdfResource resource;

    public PdfSecurityInfoEndpoint(PdfResource resource) {
        this.resource = resource;
    }

    public String getEndpointName() {
        return "pdf-security-info";
    }

    /**
     * Process the pdf resource to get pdf's text.
     * <p>
     * PdfTextResponse
     * </p>
     * 
     * @return Pdf Text Response
     */
    public PdfSecurityInfoResponse process() {

        CompletableFuture<PdfSecurityInfoResponse> cf = processAsync();
        try {
            return cf.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Process the pdf resource to get pdf's security information.
     * 
     * @return collection of <code>PdfSecurityInfoResponse</code> as multithreading
     *         tasks
     *         <code>CompletableFuture</code>.
     */
    public CompletableFuture<PdfSecurityInfoResponse> processAsync() {
        return CompletableFuture.supplyAsync(() -> {
            PdfSecurityInfoResponse pdfSecurityInfoResponse = null;
            RequestSpecification requestSpec = super.createRequestSpecification();
            Response response = RestAssured
                    .given()
                    .header("Accept", "application/pdf")
                    .header("content-type", "application/pdf")
                    .spec(requestSpec)
                    .body(resource.getData())
                    .post(getDefaultBaseUrl() + "/" + getEndpointVersion() + "/" + getEndpointName());

            if (response.getStatusCode() == 200) {
                pdfSecurityInfoResponse = new PdfSecurityInfoResponse(response.asString());
                pdfSecurityInfoResponse.setIsSuccessful(true);
                pdfSecurityInfoResponse.setStatusCode(response.getStatusCode());
            } else {
                if (response.getStatusCode() == 401) {
                    throw new EndpointException("Invalid api key specified.");
                }
                pdfSecurityInfoResponse = new PdfSecurityInfoResponse();
                String errorMessage = response.jsonPath().getString("message");
                UUID errorId = response.jsonPath().getUUID("id");
                pdfSecurityInfoResponse.setErrorId(errorId);
                pdfSecurityInfoResponse.setErrorJson(response.asString());
                pdfSecurityInfoResponse.setErrorMessage(errorMessage);
                pdfSecurityInfoResponse.setIsSuccessful(false);
                pdfSecurityInfoResponse.setStatusCode(response.getStatusCode());
            }
            return pdfSecurityInfoResponse;
        });
    }
}
