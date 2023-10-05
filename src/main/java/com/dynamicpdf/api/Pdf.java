
package com.dynamicpdf.api;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.dynamicpdf.api.elements.Element;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Represents a pdf endpoint.
 */

public class Pdf extends Endpoint
{
	PdfInstructions instructions;
	private HashSet<Resource> resources = new HashSet<Resource>();

	/**
	 * Initializes a new instance of the <code>Pdf</code> class.
	 */

	public Pdf() { 
		super();        
		this.instructions = new PdfInstructions();
	}

	/**
	 * Gets the collection of resource.
	 * @return The collection of resource.
	 */
	String getEndpointName() { return "pdf";}

	/**
     * Adds additional resource to the endpoint.
     * @param resourcePath The resource file path.
     * @param resourceName The name of the resource.
     */
    public void addAdditionalResource(String resourcePath, String resourceName)
    {
        if( resourceName == null) {
        	Path path = Paths.get(resourcePath);
            Path resourceFileName = path.getFileName();
            resourceName = resourceFileName.toString();
        }
        AdditionalResource resource = new AdditionalResource( resourcePath, resourceName);
        getResources().add(resource);
    }
    
    /**
     * Adds additional resource to the endpoint.
     * @param resourcePath The resource file path.
     */
    public void addAdditionalResource(String resourcePath)
    {
    	Path path = Paths.get(resourcePath);
        Path resourceFileName = path.getFileName();
        String resourceName = resourceFileName.toString();
        AdditionalResource resource = new AdditionalResource( resourcePath, resourceName);
        getResources().add(resource);
    }

    /**
     * Adds additional resource to the endpoint.
     * @param resourceData The resource data.
     * @param additionalResourceType The type of the resource.
     * @param resourceName The name of the resource.
     */
    public void addAdditionalResource(byte[] resourceData,AdditionalResourceType additionalResourceType, String resourceName)
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
            case HTML:
                type = ResourceType.HTML;
                break;
        }
        AdditionalResource resource = new AdditionalResource(resourceData, resourceName, type);
        getResources().add(resource);
    }
    
    
	/**
	 * Sets the collection of resource.
	 * @return The collection of resource.
	 */
	public HashSet<Resource> getResources() { return resources; }

	/**
	 * Gets the author.
	 * @return The author.
	 */
	public String getAuthor()
	{
		return this.instructions.getAuthor();            
	}

	/**
	 * Sets the author.
	 * @param value The author.
	 */
	public void setAuthor(String value)
	{
		this.instructions.setAuthor(value);
	}

	/**
	 * Gets the title.
	 * @return The title.
	 */
	public String getTitle()
	{
		return this.instructions.getTitle();
	}

	/**
	 * Sets the title.
	 * @param value The title.
	 */
	public void setTitle(String value) 
	{
		this.instructions.setTitle(value);
	}

	/**
	 * Gets the subject.
	 * @return The subject.
	 */
	public String getSubject()
	{ 
		return this.instructions.getSubject();
	}

	/**
	 * Sets the subject.
	 * @param value The subject.
	 */
	public void setSubject(String value) 
	{ 
		this.instructions.setSubject(value);
	}

	/**
	 * Gets the creator.
	 * @return The creator.
	 */
	public String getCreator()
	{ 
		return this.instructions.getCreator();
	}

	/**
	 * Sets the creator.
	 * @param value The creator.
	 */
	public void setCreator(String value) 
	{ 
		this.instructions.setCreator(value);
	}

	/**
	 * Gets the keywords.
	 * @return The keywords.
	 */
	public String getKeywords() 
	{
		return this.instructions.getKeywords();
	}

	/**
	 * Sets the keywords.
	 * @param value The keywords.
	 */
	public void setKeywords(String value) 
	{ 

		this.instructions.setKeywords(value);
	}

	/**
	 * Gets the security.
	 * @return The security.
	 */
	public Security getSecurity() 
	{
		return this.instructions.getSecurity();
	}

	/**
	 * Sets the security.
	 * @param value The security.
	 */
	public void setSecurity(Security value) 
	{ 
		this.instructions.setSecurity(value);
	}

	/**
	 * Gets the value indicating whether to flatten all form fields.
	 * @return The value indicating whether to flatten all form fields.
	 */
	public boolean getFlattenAllFormFields()
	{
		return this.instructions.getFlattenAllFormFields();
	}

	/**
	 * Sets the value indicating whether to flatten all form fields.
	 * @param value The value indicating whether to flatten all form fields.
	 */
	public void setFlattenAllFormFields(boolean value)
	{ 
		this.instructions.setFlattenAllFormFields(value);
	}

	/**
	 * Gets the value indicating whether to retain signature form field.
	 * @return The value indicating whether to retain signature form field.
	 */
	public boolean getRetainSignatureFormFields() 
	{
		return this.instructions.getRetainSignatureFormFields();            
	}

	/**
	 * Sets the value indicating whether to retain signature form field.
	 * @param value The value indicating whether to retain signature form field.
	 */
	public void setRetainSignatureFormFields(boolean value) 
	{
		this.instructions.setRetainSignatureFormFields(value);
	}

	/**
	 * Returns a <code>PdfInput</code> object containing the input pdf.
	 * @param resource The resource of type <code>PdfResource</code>.
	 * @param options The merge options for the pdf.
	 * @return Added pdf pages
	 */

	public PdfInput addPdf(PdfResource resource, MergeOptions options)
	{
		PdfInput input = new PdfInput(resource, options);
		this.getInputs().add(input);
		return input;
	}

	/**
	 * 
	 * @param resource The resource of type <code>PdfResource</code>.
	 * @return Added pdf pages
	 */
	public PdfInput addPdf(PdfResource resource)
	{
		return addPdf(resource, null);
	}

	/**
	 * Returns a <code>PdfInput</code> object containing the input pdf.
	 * @param cloudResourcePath The resource path in cloud resource manager.
	 * @param options The merge options for the pdf.
	 * @return Added pdf pages
	 */
	public PdfInput addPdf(String cloudResourcePath, MergeOptions options)
	{
		PdfInput input = new PdfInput(cloudResourcePath, options);
		this.getInputs().add(input);
		return input;
	}

	/**
	 * 
	 * @param cloudResourcePath The resource path in cloud resource manager.
	 * @return Added pdf pages
	 */
	public PdfInput addPdf(String cloudResourcePath)
	{            
		return addPdf(cloudResourcePath, null);
	}

	/**
	 * Returns an <code>ImageInput</code> object containing the input pdf.
	 * @param resource The resource of type <code>ImageResource</code>.
	 * @return Added pdf pages
	 */

	public ImageInput addImage(ImageResource resource)
	{
		ImageInput input = new ImageInput(resource);
		this.getInputs().add(input);
		return input;
	}

	/**
	 * Returns an <code>ImageInput</code> object containing the input pdf.
	 * @param cloudResourcePath The resource path in cloud resource manager.
	 * @return Added pdf pages
	 */

	public ImageInput addImage(String cloudResourcePath)
	{
		ImageInput input = new ImageInput(cloudResourcePath);
		this.getInputs().add(input);
		return input;
	}

	/**
	 * @deprecated This method is deprecated, use {@link #addHtml(HtmlResource, String, PageSize, PageOrientation, Float)} method instead.
	 * Returns an <code>HtmlInput</code> object containing the input html.
	 * @param resource The resource of type <code>HtmlResource</code>.
	 * @param basepath The BasePath option.
	 * @param size The page dimensions.
	 * @param orientation The orientation of the page.
	 * @param margins The margins on the page.
	 * @return Added pdf pages
	 */
	@Deprecated
    public HtmlInput AddHtml(HtmlResource resource, String basepath, PageSize size, PageOrientation orientation, Float margins)
    {
		return addHtml(resource, basepath, size, orientation, margins);
    }

    /**
	 * @deprecated This method is deprecated, use {@link #addHtml(String, String, PageSize, PageOrientation, Float)} method instead.
	 * Returns an <code>HtmlInput</code> object containing the input html.
	 * @param html The HTML input string.
	 * @param basepath The BasePath option.
	 * @param size The page dimensions.
	 * @param orientation The orientation of the page.
	 * @param margins The margins on the page.
	 * @return Added pdf pages
	 */
	@Deprecated
    public HtmlInput AddHtml(String html, String basepath, PageSize size, PageOrientation orientation, Float margins)
    {
    	return addHtml(new HtmlResource(html), basepath, size, orientation, margins);
    }

	/**
	 * Returns an <code>HtmlInput</code> object containing the input html.
	 * @param resource The resource of type <code>HtmlResource</code>.
	 * @param basepath The BasePath option.
	 * @param size The page dimensions.
	 * @param orientation The orientation of the page.
	 * @param margins The margins on the page.
	 * @return Added pdf pages
	 */
    public HtmlInput addHtml(HtmlResource resource, String basepath, PageSize size, PageOrientation orientation, Float margins)
    {
        HtmlInput input = new HtmlInput(resource, basepath, size, orientation, margins);
        this.getInputs().add(input);
        return input;
    }

    /**
	 * Returns an <code>HtmlInput</code> object containing the input html.
	 * @param html The HTML input string.
	 * @param basepath The BasePath option.
	 * @param size The page dimensions.
	 * @param orientation The orientation of the page.
	 * @param margins The margins on the page.
	 * @return Added pdf pages
	 */
    public HtmlInput addHtml(String html, String basepath, PageSize size, PageOrientation orientation, Float margins)
    {
    	return addHtml(new HtmlResource(html), basepath, size, orientation, margins);
    }
    
    /**
     * Returns a <code>WordInput</code> object containing the input pdf.
     * @param resource The resource of type <code>WordResource</code>.
     * @param size The page dimensions.
     * @param orientation The orientation of the page.
     * @param margins The margins on the page.
     * @return Added pdf pages
     */
	public WordInput addWord(WordResource resource, PageSize size, PageOrientation orientation, Float margins) {
		WordInput input = new WordInput(resource, size, orientation, margins);
		this.getInputs().add(input);
		return input;
	}
    
	/**
	 * Returns a <code>DlexInput</code> object containing the input pdf.
	 * @param dlexResource The dlex resource of type <code>DlexResource</code>.
	 * @param layoutData The layout data resource of type <code>LayoutDataResource</code>.
	 * @return Added pdf pages
	 */

	public DlexInput addDlex(DlexResource dlexResource, LayoutDataResource layoutData)
	{
		DlexInput input = new DlexInput(dlexResource, layoutData);
		this.getInputs().add(input);
		return input;
	}

	/**
	 * Returns a <code>DlexInput</code> object containing the input pdf.
	 * @param cloudResourcePath The resource path in cloud resource manager.
	 * @param layoutData The layout data resource of type <code>LayoutDataResource</code>.
	 * @return Added pdf pages
	 */

	public DlexInput addDlex(String cloudResourcePath, LayoutDataResource layoutData)
	{
		DlexInput input = new DlexInput(cloudResourcePath, layoutData);
		this.getInputs().add(input);
		return input;
	}

	/**
	 * Returns a <code>DlexInput</code> object containing the input pdf.
	 * @param cloudResourcePath The resource path in cloud resource manager.
	 * @param layoutData The json data string used to create the PDF report.
	 * @return Added pdf pages
	 */

	public DlexInput addDlex(String cloudResourcePath, String layoutData)
	{
		DlexInput input = new DlexInput(cloudResourcePath, layoutData);
		this.getInputs().add(input);
		return input;
	}
	
	/**
	 * Returns a <code>DlexInput</code> object containing the input pdf.
	 * @param dlexResource The resource path in cloud resource manager.
	 * @param layoutData The json data string used to create the PDF report.
	 * @return Added pdf pages
	 */
	public DlexInput addDlex(DlexResource dlexResource, String layoutData) {
		DlexInput input = new DlexInput(dlexResource, layoutData);
		this.getInputs().add(input);
		return input;
	}

	/**
	 * Returns a <code>PageInput</code> object containing the input pdf.
	 * @param pageWidth The width of the page.
	 * @param pageHeight The height of the page.
	 * @return Added pdf pages
	 */

	public PageInput addPage(float pageWidth, float pageHeight)
	{
		PageInput input = new PageInput(pageWidth, pageHeight);
		this.getInputs().add(input);
		return input;
	}

	/**
	 * Returns a <code>PageInput</code> object containing the input pdf.
	 * @return A <code>PageInput</code> object containing the input pdf.
	 */
	public PageInput addPage()
	{
		PageInput input = new PageInput();
		this.getInputs().add(input);
		return input;
	}

	/**
	 * Gets the inputs.
	 * @return The inputs.
	 */
	public List<Input> getInputs()
	{
		return this.instructions.getInputs();
	}

	/**
	 * Gets the templates.
	 * @return The templates.
	 */
	public HashSet<Template> getTemplates()
	{
		return this.instructions.getTemplates();
	}

	/**
	 * Gets the fonts.
	 * @return The fonts.
	 */
	public HashSet<Font> getFonts()
	{
		return this.instructions.getFonts();
	}

	/**
	 * Gets the formFields.
	 * @return The formFields.
	 */
	public List<FormField> getFormFields()
	{
		return this.instructions.getFormFields();
	}

	/**
	 * Gets the outlines.
	 * @return The outlines.
	 */
	@JsonIgnore
	public OutlineList getOutlines()
	{
		return this.instructions.getOutlines();
	}

	/**
	 * Gets the instructions json based on the inputs passed.
	 * @return The json string.
	 */
	public String getInstructionsJson() {
		return getInstructionsJson(false);
	}
	
	/**
	 * Gets the instructions json based on the inputs passed.
	 * @param indented The boolean value specifying whether the json string is indented or not.
	 * @return The json string.
	 */
	public String getInstructionsJson(boolean indented) {
		for (Input input : instructions.getInputs()) { 
			if (input.getType() == InputType.PAGE) {
				PageInput pageInput = (PageInput)input; 
				for (Element element : pageInput.getElements()) {
					if (element.getTextFont() != null && element.getTextFont().getResourceName() != null) {
						instructions.getFonts().add(element.getTextFont());
					}
				} 
			} 
			if (input.getTemplate() != null) {
				instructions.getTemplates().add(input.getTemplate());
				if (input.getTemplate().getElements() != null && input.getTemplate().getElements().size() > 0) { 
					for (Element element : input.getTemplate().getElements()) { 
						if (element.getTextFont() != null && element.getTextFont().getResourceName() != null) {
							instructions.getFonts().add(element.getTextFont()); 
						}
					}
				} 
			} 
		}

		String jsonText = null; 
		ObjectMapper basicMapper = new ObjectMapper();
		
		try {
			if(indented) {
			    jsonText = basicMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.instructions);
			} else {
				jsonText = basicMapper.writeValueAsString(this.instructions);
			}
		} catch(JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return jsonText;
	}


	/**
	 * Process to create pdf.
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
	 * Process to create pdf.
	 * 
	 * @return collection of <code>PdfResponse</code> as multithreading tasks <code>CompletableFuture</code>.
	 */
	public CompletableFuture<PdfResponse> processAsync()
	{
		return CompletableFuture.supplyAsync(() -> {
			RequestSpecification spec = super.createRequestSpecification();
			PdfResponse pdfResponse = null;
			HashSet<Resource> finalResources = new HashSet<Resource>();
			String jsonText = null;
			ObjectMapper basicMapper = new ObjectMapper();

			for (Input input : instructions.getInputs()) {
				if (input.getType() == InputType.PAGE) {
					PageInput pageInput = (PageInput) input;
					for (Element element : pageInput.getElements()) {
						if (element.getResource() != null) {
							finalResources.add(element.getResource());
						}
						if (element.getTextFont() != null && element.getTextFont().getResourceName() != null) {
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
							if (element.getTextFont() != null && element.getTextFont().getResourceName() != null) {
								instructions.getFonts().add(element.getTextFont());
							}

						}
					}
				}

			}

			for (Resource resource : getResources()) {
				finalResources.add(resource);
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
				if (resource.getType() == ResourceType.LAYOUTDATA) {
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
					.post(getDefaultBaseUrl() + "/"+ getEndpointVersion() + "/"  + getEndpointName());


			if (response.getStatusCode() == 200)
			{
				pdfResponse = new PdfResponse(response.asByteArray());
				pdfResponse.setIsSuccessful(true);
				pdfResponse.setStatusCode(response.getStatusCode());
			}
			else
			{
				if (response.getStatusCode() == 401) {
					throw new EndpointException("Invalid api key specified.");
				}
				pdfResponse = new PdfResponse();
				String errorMessage = response.jsonPath().getString("message");
				UUID errorId = response.jsonPath().getUUID("id");
				pdfResponse.setErrorId(errorId);
				pdfResponse.setErrorJson(response.asString());
				pdfResponse.setErrorMessage(errorMessage);
				pdfResponse.setIsSuccessful(false);
				pdfResponse.setStatusCode(response.getStatusCode());
			}
			return pdfResponse;
		});
	}

}
