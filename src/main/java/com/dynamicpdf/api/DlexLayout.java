
package com.dynamicpdf.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DlexLayout extends Endpoint
{
	private LayoutDataResource resource;
	private String dlexPath;

	public DlexLayout(String cloudDlexPath, LayoutDataResource layoutData) { 
		super();        
		dlexPath = cloudDlexPath;
		this.resource = layoutData;
	}

	String getEndpointName() { return "dlex-layout";}
	public String getDlexPath() { return dlexPath; }
	public void setDlexPath(String value) { dlexPath = value; }

	public PdfResponse process()
	{
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
		}
		else
		{
			pdfResponse = new PdfResponse();
			pdfResponse.setErrorJson(response.asString()); 
			//xmlResponse.setErrorId(response.getSErrorId);
			//xmlResponse.setErrorMessage(response.ErrorMessage);
			pdfResponse.setIsSuccessful(false);
			pdfResponse.setStatusCode(response.getStatusCode());
		}
		return pdfResponse;
	}
}

