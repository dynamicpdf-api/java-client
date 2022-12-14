package com.dynamicpdf.api;

import com.dynamicpdf.api.elements.Element;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a page input.
 */

@JsonInclude(Include.NON_DEFAULT)
public class PageInput extends Input {

	private float pageWidth = 612.0f;
	private float pageHeight = 792.0f;
	private float topMargin = 0;
    private float bottomMargin = 0;
    private float rightMargin = 0;
    private float leftMargin = 0;
    private PageSize pageSize;
    private PageOrientation pageOrientation;
	private List<Element> elements = null;

	/**
	 * Initializes a new instance of the <code>PageInput</code> class.
	 * @param size The size of the page.
	 * @param orientation The orientation of the page.
	 * @param margins The margins of the page.
	 */
    public PageInput(PageSize size, PageOrientation orientation, Float margins) { 
        if(orientation != PageOrientation.PORTRAIT)
            setPageOrientation(orientation);
        if(size != PageSize.A4) 
            setPageSize(size);
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
        if(orientation != PageOrientation.PORTRAIT)
            setPageOrientation(orientation);
        if(size != PageSize.A4) 
            setPageSize(size);
    }
    
    /**
	 * Initializes a new instance of the <code>PageInput</code> class.
	 * @param size The size of the page.
	 */
    public PageInput(PageSize size) { 
        if(size != PageSize.A4) 
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
