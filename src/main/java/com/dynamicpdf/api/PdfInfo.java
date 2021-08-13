
package com.dynamicpdf.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PdfInfo extends Endpoint
    {
        private PdfResource resource;

        public PdfInfo(PdfResource resource)
        {
            this.resource = resource;
        }

        String getEndpointName() { return "pdf-info";}


        public PdfInfoResponse process()
        {
        	PdfInfoResponse pdfInfoResponse = null;
        	RequestSpecification requestSpec = super.createRequestSpecification();
        	Response response = RestAssured
    				.given()
    				.header("Accept", "application/pdf")
    				.header("content-type", "application/pdf")
    				.spec(requestSpec)
    				.body(resource.getData())
    				.post(getDefaultBaseUrl() + "/" + getEndpointName());
    		
        	 if (response.getStatusCode() == 200)
             {
        		 pdfInfoResponse = new PdfInfoResponse(response.asString());
        		 pdfInfoResponse.setIsSuccessful(true);
             }
             else
             {
            	 pdfInfoResponse = new PdfInfoResponse();
            	 pdfInfoResponse.setErrorJson(response.asString()); 
            	 //xmlResponse.setErrorId(response.getSErrorId);
            	 //xmlResponse.setErrorMessage(response.ErrorMessage);
            	 pdfInfoResponse.setIsSuccessful(false);
            	 pdfInfoResponse.setStatusCode(response.getStatusCode());
             }
             return pdfInfoResponse;
        }
    }
