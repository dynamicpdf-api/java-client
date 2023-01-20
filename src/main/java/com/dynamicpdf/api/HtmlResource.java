package com.dynamicpdf.api;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * Represents a Html resource object that is created using the Html file and a name.
 */
public class HtmlResource extends Resource{

	/**
	 * Initializes a new instance of the <code>HtmlResource</code> class 
	 * @param html The input html string.
	 * @param resourceName The name of the resource.
	 */
    public HtmlResource(String html, String resourceName) {
    	super();
    	try {
    	setData(html.getBytes("UTF8")); 
    	} catch (UnsupportedEncodingException ex) {
		}
        if (resourceName == null)
            setResourceName(UUID.randomUUID().toString() + getFileExtension());
        else
            setResourceName(resourceName);
    }

    /**
	 * Initializes a new instance of the <code>HtmlResource</code> class 
	 * @param html The input html string.
	 */
    public HtmlResource(String html) {
    	super();
    	try {
    	   setData(html.getBytes("UTF8")); 
    	} catch (UnsupportedEncodingException ex) {
		}
        setResourceName(UUID.randomUUID().toString() + getFileExtension());
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
