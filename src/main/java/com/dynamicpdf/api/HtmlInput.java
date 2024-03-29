package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents a Html input.
 */
public class HtmlInput extends Input{

	private PageSize pageSize = PageSize.LETTER;
    private PageOrientation pageOrientation = PageOrientation.PORTRAIT;
    private String basePath = null;
    private Float topMargin = null;
    private Float bottomMargin = null;
    private Float rightMargin = null;
    private Float leftMargin = null;
    private float pageWidth;
    private float pageHeight;

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
    @JsonSerialize(using = FloatJsonSerializer.class)
    public Float getTopMargin() { 
    	return topMargin; 
    }
    
    /**
	 * Sets the top margin.
	 * @param value The top margin.
	 */
    public void setTopMargin(Float value) {
    	topMargin = value;
    }
    
    /**
   	 * Gets the left margin.
   	 * @return The left margin.
   	 */
    @JsonSerialize(using = FloatJsonSerializer.class)
    public Float getLeftMargin() {
     return leftMargin;
    }

    /**
	 * Sets the left margin.
	 * @param value The left margin.
	 */
    public void setLeftMargin(Float value) {
    	leftMargin = value;
    }
    
    /**
	 * Gets the bottom margin.
	 * @return The bottom margin.
	 */
    @JsonSerialize(using = FloatJsonSerializer.class)
    public Float getBottomMargin() { 
    	return bottomMargin;
   	}

    /**
	 * Sets the bottom margin.
	 * @param value The bottom margin.
	 */
    public void setBottomMargin(Float value) {
    	bottomMargin = value;
    }
    
    /**
	 * Gets the right margin.
	 * @return The right margin.
	 */
    @JsonSerialize(using = FloatJsonSerializer.class)
    public Float getRightMargin() { 
        return rightMargin;
    }

    /**
	 * Sets the right margin.
	 * @param value The right margin.
	 */
    public void setRightMargin(Float value) {
    	rightMargin = value;
    }
    
    /**
	 * Gets the width of the page.
	 * @return The width of the page.
	 */
    @JsonSerialize(using = FloatJsonSerializer.class)
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
    @JsonSerialize(using = FloatJsonSerializer.class)
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
        double[] paperSize = UnitConverter.getPaperSize(value);
        double smaller = paperSize[0];
        double larger = paperSize[1];
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
        float smaller;
        float larger;
        if (getPageWidth() > getPageHeight()){
            smaller = getPageHeight();
            larger = getPageWidth();
        }
        else {
            smaller = getPageWidth();
            larger = getPageHeight();
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
