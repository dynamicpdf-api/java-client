
package com.dynamicpdf.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PdfXmp extends Endpoint
    {
        PdfResource resource;

        public PdfXmp(PdfResource resource)
        {
            this.resource = resource;
        }

        String getEndpointName() { return "pdf-xmp";}
        

        public XmlResponse process()
        {
        	XmlResponse xmlResponse = null;
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
        		 xmlResponse = new XmlResponse(response.asString());
        		 xmlResponse.setIsSuccessful(true);
             }
             else
             {
            	 xmlResponse = new XmlResponse();
            	 xmlResponse.setErrorJson(response.asString()); 
            	 //xmlResponse.setErrorId(response.getSErrorId);
            	 //xmlResponse.setErrorMessage(response.ErrorMessage);
            	 xmlResponse.setIsSuccessful(false);
            	 xmlResponse.setStatusCode(response.getStatusCode());
             }
             return xmlResponse;
        }
    }

