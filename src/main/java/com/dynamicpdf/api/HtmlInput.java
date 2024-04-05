package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Html input.
 */
public class HtmlInput extends ConverterInput{

    private String basePath = null;

    /**
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param resource The resource of type <code>HtmlResource</code>
	 * @param basepath The basepath options for the url.
	 * @param size The page dimensions.
	 * @param orientation The orientation of the page.
	 * @param margins The margins on the page.
	 */
    public HtmlInput(HtmlResource resource, String basepath, PageSize size, PageOrientation orientation, Float margins){
    	super(resource, size, orientation, margins);
        if (basepath != null){
            setBasePath(basepath);
        }
    }
	
    /**
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param resource The resource of type <code>HtmlResource</code>
	 * @param basepath The basepath options for the url.
	 * @param size The page dimensions.
	 * @param orientation The orientation of the page.
	 */
    public HtmlInput(HtmlResource resource, String basepath, PageSize size, PageOrientation orientation){
    	super(resource, size, orientation);
        if (basepath != null){
            setBasePath(basepath);
        }
    }
    
    /**
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param resource The resource of type <code>HtmlResource</code>
	 * @param basepath The basepath options for the url.
	 * @param size The page dimensions.
	 */
    public HtmlInput(HtmlResource resource, String basepath, PageSize size){
    	super(resource, size);
        if (basepath != null){
            setBasePath(basepath);
        }
    }
    
    /**
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param resource The resource of type <code>HtmlResource</code>
	 * @param basepath The basepath options for the url.
	 */
    public HtmlInput(HtmlResource resource, String basepath){
    	super(resource);
        if (basepath != null){
            setBasePath(basepath);
        }
    }
    
    /**
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param resource The resource of type <code>HtmlResource</code>
	 */
    public HtmlInput(HtmlResource resource){
    	super(resource);
    }

    /**
	 * Gets the base path option.
	 * @return the base path option.
	 */
    public String getBasePath(){
    	return basePath;
    }

    /**
	 * Sets the base path option.
	 * @param value The base path option.
	 */
    public void setBasePath(String value) {
    	basePath = value;
    }   

    @JsonInclude
	@JsonProperty("type")
    InputType getType() {
		return InputType.HTML;
	}
}
