
package com.dynamicpdf.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ImageInfo extends Endpoint
    {
        private ImageResource resource;

        public ImageInfo(ImageResource resource)
        {
            this.resource = resource;
        }

        String getEndpointName() { return "image-info";}

        public ImageResponse process()
        {
        	ImageResponse imageResponse = null;
        	RequestSpecification requestSpec = super.createRequestSpecification();
        	Response response = RestAssured
    				.given()
    				.header("Accept", "*/*")
    				.header("content-type", resource.mimeType)
    				.spec(requestSpec)
    				.body(resource.getData())
    				.post(getDefaultBaseUrl() + "/" + getEndpointName());
    		
        	 if (response.getStatusCode() == 200)
             {
        		 imageResponse = new ImageResponse(response.asString());
        		 imageResponse.setIsSuccessful(true);
        		 imageResponse.setStatusCode(response.getStatusCode());
             }
             else
             {
            	 imageResponse = new ImageResponse();
            	 imageResponse.setErrorJson(response.asString()); 
            	 imageResponse.setIsSuccessful(false);
            	 imageResponse.setStatusCode(response.getStatusCode());
             }
             return imageResponse;
        }
       
    }
