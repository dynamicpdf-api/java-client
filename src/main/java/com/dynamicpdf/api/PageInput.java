package com.dynamicpdf.api;

import com.dynamicpdf.api.elements.Element;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a page input.
 */

@JsonInclude(Include.NON_DEFAULT)
public class PageInput extends Input {

	private Float pageWidth = null;
	private Float pageHeight = null;
	private Float topMargin = null;
    private Float bottomMargin = null;
    private Float rightMargin = null;
    private Float leftMargin = null;
    private PageSize pageSize = PageSize.LETTER;
    private PageOrientation pageOrientation = PageOrientation.PORTRAIT;
	private List<Element> elements = null;
	private final float DefaultPageHeight = 792.0f;
    private final float DefaultPagewidth = 612.0f;

	/**
	 * Initializes a new instance of the <code>PageInput</code> class.
	 * @param size The size of the page.
	 * @param orientation The orientation of the page.
	 * @param margins The margins of the page.
	 */
    public PageInput(PageSize size, PageOrientation orientation, Float margins) { 
    	setPageSize(size);
    	setPageOrientation(orientation); 
        if(margins != null){
            setTopMargin(margins);
            setBottomMargin(margins);
            setRightMargin(margins);
            setLeftMargin(margins);
        }
    }
    
    /**
	 * Initializes a new instance of the <code>PageInput</code> class.
	 * @param size The size of the page.
	 * @param orientation The orientation of the page.
	 */
    public PageInput(PageSize size, PageOrientation orientation) { 
    	setPageSize(size);
        setPageOrientation(orientation);
    }
    
    /**
	 * Initializes a new instance of the <code>PageInput</code> class.
	 * @param size The size of the page.
	 */
    public PageInput(PageSize size) { 
        setPageSize(size);
    }
    
	/**
	 * Initializes a new instance of the <code>PageInput</code> class.
	 * @param pageWidth The width of the page.
	 * @param pageHeight The height of the page.
	 */
	public PageInput(float pageWidth, float pageHeight) {
		this.pageWidth = pageWidth;
		this.pageHeight = pageHeight;
	}

	/**
	 * Initializes a new instance of the <code>PageInput</code> class.
	 */
	public PageInput() {
		super();
	}

	@JsonInclude
	@JsonProperty("type")
	InputType getType() {
		return InputType.PAGE;
	}

	/**
	 * Gets the width of the page.
	 * @return The width of the page.
	 */
	@JsonIgnore
	public Float getPageWidth() {
		return pageWidth;
	}

	/**
	 * Sets the width of the page.
	 * @param value The width of the page.
	 */
	public void setPageWidth(Float value) {
		pageWidth = value;
	}

	/**
	 * Gets the height of the page.
	 * @return The height of the page.
	 */
	@JsonIgnore
	public Float getPageHeight() {
		return pageHeight;
	}

	/**
	 * Sets the height of the page.
	 * @param value The height of the page.
	 */
	public void setPageHeight(Float value) {
		pageHeight = value;
	}
	
	@JsonInclude
	@JsonProperty("pageWidth")
	@JsonSerialize(using = FloatJsonSerializer.class)
	float getWidth() {
		return ((getPageWidth() == null) ? DefaultPagewidth : getPageWidth());
	}

	@JsonInclude
	@JsonProperty("pageHeight")
	@JsonSerialize(using = FloatJsonSerializer.class)
	float getHeight() {
		return ((getPageHeight() == null) ? DefaultPageHeight : getPageHeight());
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
        if (getWidth() > getHeight()){
            smaller = getHeight();
            larger = getWidth();
        }
        else {
            smaller = getWidth();
            larger = getHeight();
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
    
	/**
	 * Gets or sets the elements of the page.
	 * @return The elements of the page.
	 */
	public List<Element> getElements() {
		if (elements == null) {
			elements = new ArrayList<Element>();
		}
		return elements;
	}
}
