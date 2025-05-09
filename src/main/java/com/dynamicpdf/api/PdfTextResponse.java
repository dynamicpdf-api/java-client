package com.dynamicpdf.api;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

/**
 * Represents the pdf text response.
 */
public class PdfTextResponse extends JsonResponse {

	private List<PdfContent> content;

	/**
	 * Initializes a new instance of the <code>PdfTextResponse</code> class.    
	 */
	public PdfTextResponse() {
		super();
	}

	/**
	 * Initializes a new instance of the <code>PdfResponse</code> class.
	 * @param jsonContent The json content
	 */
	public PdfTextResponse(String jsonContent) {
        super(jsonContent);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            content = mapper.readValue(super.getJsonContent(), new TypeReference<List<PdfContent>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	/**
	 * Gets the collection of PdfContent.
	 * @return The collection of PdfContent.
	 */
	public List<PdfContent> getContent() {
		return content;
	}

	private void setContent(List<PdfContent> value) {
		content = value;
	}

}
