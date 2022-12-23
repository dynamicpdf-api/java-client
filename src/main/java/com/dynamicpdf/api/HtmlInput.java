package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Html input.
 */
public class HtmlInput extends Input{

	private PageSize pageSize;
    private PageOrientation pageOrientation;
    private String htmlString = null;
    private String basePath = null;
    private float topMargin = 0;
    private float bottomMargin = 0;
    private float rightMargin = 0;
    private float leftMargin = 0;
    private float pageWidth = 612.0f;
    private float pageHeight = 792.0f;

    /**
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param resource The resource of type <code>HtmlResource</code>
	 * @param basepath The basepath options for the url.
	 * @param size The page dimensions.
	 * @param orientation The orientation of the page.
	 * @param margins The margins on the page.
	 */
    public HtmlInput(HtmlResource resource, String basepath, PageSize size, PageOrientation orientation, Float margins){
    	super(resource);
        setPageSize(size);
        setPageOrientation(orientation);
        if (basepath != null){
            setBasePath(basepath);
        }

        if (margins != null){
            setTopMargin(margins);
            setBottomMargin(margins);
            setRightMargin(margins);
            setLeftMargin(margins);
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
    	super(resource);
        setPageSize(size);
        setPageOrientation(orientation);
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
    	super(resource);
        setPageSize(size);
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
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param htmlString The html string.
	 * @param basepath The basepath options for the url.
	 * @param size The page dimensions.
	 * @param orientation The orientation of the page.
	 * @param margins The margins on the page.
	 */
    public HtmlInput(String htmlString, String basepath, PageSize size, PageOrientation orientation, Float margins){
    	super();
		if (htmlString != null && htmlString.length() > 0) {
			setHtmlString(htmlString);
			setPageSize(size);
			setPageOrientation(orientation);
			if (basepath != null) {
				setBasePath(basepath);
			}
			if (margins != null) {
				setTopMargin(margins);
				setBottomMargin(margins);
				setRightMargin(margins);
				setLeftMargin(margins);
			}
		} else {
			throw new EndpointException("Specify valid Html string.");
		}
    }   
    
    /**
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param htmlString The html string.
	 * @param basepath The basepath options for the url.
	 * @param size The page dimensions.
	 * @param orientation The orientation of the page.
	 */
    public HtmlInput(String htmlString, String basepath, PageSize size, PageOrientation orientation){
    	super();
		if (htmlString != null && htmlString.length() > 0) {
			setHtmlString(htmlString);
			setPageSize(size);
			setPageOrientation(orientation);
			if (basepath != null) {
				setBasePath(basepath);
			}
		} else {
			throw new EndpointException("Specify valid Html string.");
		}
    } 

    /**
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param htmlString The html string.
	 * @param basepath The basepath options for the url.
	 * @param size The page dimensions.
	 */
    public HtmlInput(String htmlString, String basepath, PageSize size){
    	super();
		if (htmlString != null && htmlString.length() > 0) {
			setHtmlString(htmlString);
			setPageSize(size);
			if (basepath != null) {
				setBasePath(basepath);
			}
		} else {
			throw new EndpointException("Specify valid Html string.");
		}
    } 
    
    /**
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param htmlString The html string.
	 * @param basepath The basepath options for the url.
	 */
    public HtmlInput(String htmlString, String basepath){
    	super();
		if (htmlString != null && htmlString.length() > 0) {
			setHtmlString(htmlString);
			if (basepath != null) {
				setBasePath(basepath);
			}
		} else {
			throw new EndpointException("Specify valid Html string.");
		}
    } 
    
    /**
	 * Initializes a new instance of the <code>HtmlInput</code> class.
	 * @param htmlString The html string.
	 */
    public HtmlInput(String htmlString){
    	super();
		if (htmlString != null && htmlString.length() > 0) {
			setHtmlString(htmlString);
		} else {
			throw new EndpointException("Specify valid Html string.");
		}
    } 
    
    /**
	 * Gets the html string for the input.
	 * @return The html string.
	 */
    public String getHtmlString() { 
    	return htmlString;
    }
    
    void setHtmlString(String value){
    	htmlString = value;
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
    
    /**
	 * Gets the top margin.
	 * @return The top margin.
	 */
    public float getTopMargin() { 
    	return topMargin; 
    }
    
    /**
	 * Sets the top margin.
	 * @param value The top margin.
	 */
    public void setTopMargin(float value) {
    	topMargin = value;
    }
    
    /**
   	 * Gets the left margin.
   	 * @return The left margin.
   	 */
    public float getLeftMargin() {
     return leftMargin;
    }

    /**
	 * Sets the left margin.
	 * @param value The left margin.
	 */
    public void setLeftMargin(float value) {
    	leftMargin = value;
    }
    
    /**
	 * Gets the bottom margin.
	 * @return The bottom margin.
	 */
    public float getBottomMargin() { 
    	return bottomMargin;
   	}

    /**
	 * Sets the bottom margin.
	 * @param value The bottom margin.
	 */
    public void setBottomMargin(float value) {
    	bottomMargin = value;
    }
    
    /**
	 * Gets the right margin.
	 * @return The right margin.
	 */
    public float getRightMargin() { 
        return rightMargin;
    }

    /**
	 * Sets the right margin.
	 * @param value The right margin.
	 */
    public void setRightMargin(float value) {
    	rightMargin = value;
    }
    
    /**
	 * Gets the width of the page.
	 * @return The width of the page.
	 */
    public float getPageWidth() { 
        return pageWidth;
    }
    
    /**
	 * Sets the width of the page.
	 * @param value The width of the page.
	 */
    public void setPageWidth(float value) {
    	pageWidth = value;
    }

    /**
	 * Gets the height of the page.
	 * @return The height of the page.
	 */
    public float getPageHeight() { 
        return pageHeight;
    }
    
    /**
	 * Sets the height of the page.
	 * @param value The height of the page.
	 */
    public void setPageHeight(float value) {
    	pageHeight = value;
    }

    @JsonInclude
	@JsonProperty("type")
    InputType getType() {
		return InputType.HTML;
	}

    /**
	 * Gets the page size.
	 * @return The page size.
	 */
    @JsonIgnore
    public PageSize getPageSize(){
    	return pageSize;
    }
    
    /**
	 * Sets the page size.
	 * @param value The page size.
	 */
    public void setPageSize(PageSize value){
        pageSize = value;
        double smaller = 0.0f;
        double larger = 0.0f;
        UnitConverter.getPaperSize(value, smaller, larger);
        if (getPageOrientation() == PageOrientation.PORTRAIT){
            setPageHeight((float)larger);
            setPageWidth((float)smaller);
        }
        else{
            setPageHeight((float)smaller);
            setPageWidth((float)larger); 
        }
    } 

    /**
	 * Gets the page orientation.
	 * @return The page orientation.
	 */
    @JsonIgnore
    public PageOrientation getPageOrientation(){
        return pageOrientation;
    }
    
    /**
	 * Sets the page orientation.
	 * @param value The page orientation.
	 */
    public void setPageOrientation(PageOrientation value){
        pageOrientation = value;
        float smaller = (float)getPageWidth();
        float larger = (float)getPageHeight();
        if (getPageWidth() > getPageHeight()){
            smaller = (float)getPageHeight();
            larger = (float)getPageWidth();
        }
        else {
            smaller = (float)getPageWidth();
            larger = (float)getPageHeight();
        }
        if (getPageOrientation() == PageOrientation.PORTRAIT){
            setPageHeight(larger);
            setPageWidth(smaller);
        }
        else {
            setPageHeight(smaller);
            setPageWidth(larger);
        }
     }

}
