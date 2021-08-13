
package com.dynamicpdf.api;

import java.util.HashSet;
import java.util.List;

import com.dynamicpdf.api.elements.Element;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Pdf extends Endpoint
{
	PdfInstructions instructions;
	private HashSet<Resource> resources = new HashSet<Resource>();

	public Pdf() { 
		super();        
		this.instructions = new PdfInstructions();
	}

	String getEndpointName() { return "pdf";}

	public HashSet<Resource> getResources() { return resources; }

	public String getAuthor()
	{
		return this.instructions.getAuthor();            
	}
	public void setAuthor(String value)
	{
		this.instructions.setAuthor(value);
	}

	public String getTitle()
	{
		return this.instructions.getTitle();
	}
	public void setTitle(String value) 
	{
		this.instructions.setTitle(value);
	}

	public String getSubject()
	{ 
		return this.instructions.getSubject();
	}
	public void setSubject(String value) 
	{ 
		this.instructions.setSubject(value);
	}

	public String getCreator()
	{ 
		return this.instructions.getCreator();
	}
	public void setCreator(String value) 
	{ 
		this.instructions.setCreator(value);
	}

	public String getKeywords() 
	{
		return this.instructions.getKeywords();
	}
	public void setKeywords(String value) 
	{ 

		this.instructions.setKeywords(value);
	}

	public Security getSecurity() 
	{
		return this.instructions.getSecurity();
	}
	public void setSecurity(Security value) 
	{ 
		this.instructions.setSecurity(value);
	}

	public boolean getFlattenAllFormFields()
	{
		return this.instructions.getFlattenAllFormFields();
	}
	public void setFlattenAllFormFields(boolean value)
	{ 
		this.instructions.setFlattenAllFormFields(value);
	}

	public boolean getRetainSignatureFormFields() 
	{
		return this.instructions.getRetainSignatureFormFields();            
	}
	public void setRetainSignatureFormFields(boolean value) 
	{
		this.instructions.setRetainSignatureFormFields(value);
	}

	public PdfInput addPdf(PdfResource resource, MergeOptions options)
	{
		PdfInput input = new PdfInput(resource, options);
		this.getInputs().add(input);
		return input;
	}
	public PdfInput addPdf(PdfResource resource)
	{
		return addPdf(resource, null);
	}

	public PdfInput addPdf(String cloudResourcePath, MergeOptions options)
	{
		PdfInput input = new PdfInput(cloudResourcePath, options);
		this.getInputs().add(input);
		return input;
	}
	public PdfInput addPdf(String cloudResourcePath)
	{            
		return addPdf(cloudResourcePath, null);
	}


	public ImageInput addImage(ImageResource resource)
	{
		ImageInput input = new ImageInput(resource);
		this.getInputs().add(input);
		return input;
	}

	public ImageInput addImage(String cloudResourcePath)
	{
		ImageInput input = new ImageInput(cloudResourcePath);
		this.getInputs().add(input);
		return input;
	}

	public DlexInput addDlex(DlexResource dlexResource, LayoutDataResource layoutData)
	{
		DlexInput input = new DlexInput(dlexResource, layoutData);
		this.getInputs().add(input);
		return input;
	}

	public DlexInput addDlex(String cloudResourcePath, LayoutDataResource layoutData)
	{
		DlexInput input = new DlexInput(cloudResourcePath, layoutData);
		this.getInputs().add(input);
		return input;
	}

	public DlexInput addDlex(String cloudResourcePath, String cloudLayoutDataPat)
	{
		DlexInput input = new DlexInput(cloudResourcePath, cloudLayoutDataPat);
		this.getInputs().add(input);
		return input;
	}

	public PageInput addPage(float pageWidth, float pageHeight)
	{
		PageInput input = new PageInput(pageWidth, pageHeight);
		this.getInputs().add(input);
		return input;
	}

	public PageInput addPage()
	{
		PageInput input = new PageInput();
		this.getInputs().add(input);
		return input;
	}

	public List<Input> getInputs()
	{
		return this.instructions.getInputs();
	}

	public List<Template> getTemplates()
	{
		return this.instructions.getTemplates();
	}

	public List<Font> getFonts()
	{
		return this.instructions.getFonts();
	}

	public List<FormField> getFormFields()
	{
		return this.instructions.getFormFields();
	}

	public List<Outline> getOutlines()
	{
		return this.instructions.getOutlines();
	}


	public PdfResponse process()
	{
		RequestSpecification spec = super.createRequestSpecification();
		PdfResponse pdfResponse = null;
		HashSet<Resource> finalResources = new HashSet<Resource>();
		String jsonText = null;
		ObjectMapper basicMapper = new ObjectMapper();
		//basicMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC);
		
		for (Input input : instructions.getInputs()) {
			if (input.getType() == InputType.PAGE) {
				PageInput pageInput = (PageInput) input;
				for (Element element : pageInput.getElements()) {
					if (element.getResource() != null) {
						finalResources.add(element.getResource());
					}
					if (element.getTextFont() != null) {
						instructions.getFonts().add(element.getTextFont());
					}
				}
			}
			for (Resource resource : input.getResources()) {
				finalResources.add(resource);
			}
			if (input.getTemplate() != null) {
				instructions.getTemplates().add(input.getTemplate());
				if (input.getTemplate().getElements() != null && input.getTemplate().getElements().size() > 0) {
					for (Element element : input.getTemplate().getElements()) {
						if (element.getResource() != null) {
							finalResources.add(element.getResource());
						}
						if (element.getTextFont() != null) {
							instructions.getFonts().add(element.getTextFont());
						}

					}
				}
			}

		}
		
		try {
			jsonText =  basicMapper.writeValueAsString(this.instructions);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		spec.multiPart("Instructions", "Instructions.json", jsonText.getBytes(), "application/json");
		
		if (instructions.getInputs() == null) {
			throw new EndpointException("Minimum one input required.");
		}
		for (Resource resource : finalResources) {
			if (resource.getType() == ResourceType.LayoutData) {
				LayoutDataResource res = (LayoutDataResource) resource;
				spec.multiPart("Resource", res.getLayoutDataResourceName(), resource.getData(), resource.getMimeType());
			} else {
				spec.multiPart("Resource", resource.getResourceName(), resource.getData(), resource.getMimeType());
			}
		}

		Response response = RestAssured
				.given()
				.header("Accept", "*/*")
				.header("Content-Type","multipart/form-data")
				.spec(spec)
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
