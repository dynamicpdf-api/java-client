
package com.dynamicpdf.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PdfText extends Endpoint
    {
        PdfResource resource;
        private int startPage;
        private int pageCount;

        public PdfText(PdfResource resource, int startPage, int pageCount)
        {
            this.resource = resource;
            this.startPage = startPage;
            this.pageCount = pageCount;
        }
        
        public PdfText(PdfResource resource)
        {
            this(resource,  1,  0);
        }

        String getEndpointName() { return "pdf-text";}

        public int getStartPage() { return startPage; }
        public void setStartPage(int value) { startPage = value; }

        public int getPageCount() { return pageCount; }
        public void setPageCount(int value) { pageCount = value; }

        public PdfTextResponse Process()
        {
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
    				.post(getDefaultBaseUrl() + "/" + getEndpointName());
    		
        	 if (response.getStatusCode() == 200)
             {
        		 pdfTextResponse = new PdfTextResponse(response.asString());
        		 pdfTextResponse.setIsSuccessful(true);
             }
             else
             {
            	 pdfTextResponse = new PdfTextResponse();
            	 pdfTextResponse.setErrorJson(response.asString()); 
            	 //xmlResponse.setErrorId(response.getSErrorId);
            	 //xmlResponse.setErrorMessage(response.ErrorMessage);
            	 pdfTextResponse.setIsSuccessful(false);
            	 pdfTextResponse.setStatusCode(response.getStatusCode());
             }
             return pdfTextResponse;
        }
      
    }
