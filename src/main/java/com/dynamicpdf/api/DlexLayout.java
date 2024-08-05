
package com.dynamicpdf.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;

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

	/**
	 * Initializes a new instance of the <code>DlexInput</code> class by posting the 
	 * DLEX file and the JSON data file from the client to the API to create the PDF report.
	 * @param dlexResource The <code>DlexResource</code> dlex file created as per the desired PDF report design.
	 * @param layoutData The <code>LayoutDataResource</code>, json data file used to create the PDF report.
	 */
	public DlexLayout(DlexResource dlexResource, LayoutDataResource layoutData) { 
		super();
		getResources().add(dlexResource);
		this.resource = layoutData;
	}

	public String getEndpointName() { return "dlex-layout";}

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
	 * Adds additional resource to the endpoint.
	 * @param resourcePath The resource file path.
	 * @param resourceName The name of the resource.
	 */
	public void addAdditionalResource(String resourcePath, String resourceName)
	{
	 	if( resourceName == null) {
        	Path path = Paths.get(resourcePath);
            resourceName = path.getFileName().toString();
        }
	 	AdditionalResource resource = new AdditionalResource(resourcePath, resourceName);
	 	if(resource.getType() == ResourceType.LAYOUTDATA )
         	throw new EndpointException("Layout data resources cannot be added to a DlexLayout object.");
     	else if( resource.getType() == ResourceType.DLEX)
         	throw new EndpointException("Dlex resources cannot be added to a DlexLayout object.");
     	else
         	getResources().add(resource);
	}

	/**
	  * Adds additional resource to the endpoint.
	  * @param resourceData The resource data.
	  * @param additionalResourceType The type of the additional resource.
	  * @param resourceName The name of the resource.
	  */
	public void addAdditionalResource(byte[] resourceData, AdditionalResourceType additionalResourceType, String resourceName)
	{
		ResourceType type = ResourceType.PDF;
		switch(additionalResourceType)
		{
			case FONT:
				type = ResourceType.FONT;
               	break;
		 	case IMAGE:
              	type = ResourceType.IMAGE;
              	break;
         	case PDF:
            	type = ResourceType.PDF;
             	break;
         	default:
             	throw new EndpointException("This type of resource not allowed");
         }
		AdditionalResource resource = new AdditionalResource(resourceData, resourceName, type);
        getResources().add(resource);
	}

	private HashSet<Resource> resources = new HashSet<Resource>();
	
	/**
	 * Gets the collection of resource.
	 * @return The collection of resource.
	 */
	public HashSet<Resource> getResources() { return resources; }

	/** Process the DLEX and layout data to create PDF report.
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
			if (getResources() != null && getResources().size() > 0)
            {
                for (Resource resource : getResources())
                {
                    requestSpec.multiPart("Resource", resource.getResourceName(), resource.getData(), resource.getMimeType());
                }
            }

			Response response = RestAssured
					.given()
					.header("Accept", "application/json*")
					.header("Content-Type","multipart/form-data")
					.spec(requestSpec)
					.body(resource.getData())
					.post(getDefaultBaseUrl() + "/"+ getEndpointVersion() + "/"  + getEndpointName());

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

