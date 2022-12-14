package com.dynamicpdf.api;

/**
 * Represents a Html resource object that is created using the Html file and a name.
 */
public class HtmlResource extends Resource{

	/**
	 * Initializes a new instance of the <code>HtmlResource</code> class 
	 * @param filePath The html file path.
	 * @param resourceName The name of the resource.
	 */
    public HtmlResource(String filePath, String resourceName) {
    	super(filePath, resourceName);
    }

    /**
	 * Initializes a new instance of the <code>HtmlResource</code> class 
	 * @param filePath The html file path.
	 */
    public HtmlResource(String filePath) {
    	super(filePath, null);
    }
    
    ResourceType getType() {
		return ResourceType.HTML;
	}

	String getFileExtension() {
		return ".html";
	}

	String getMimeType() {
		return "text/html";
	}
}
