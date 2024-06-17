package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents the base class for inputs.
 */
public abstract class ConverterInput extends Input{

	private PageSize pageSize = null;
    private PageOrientation pageOrientation = null;
	private Float topMargin = null;
    private Float bottomMargin = null;
    private Float rightMargin = null;
    private Float leftMargin = null;
    private Float pageWidth = null;
    private Float pageHeight = null;

	ConverterInput(Resource resource, PageSize size, PageOrientation orientation, Float margins) {
		super(resource);
		if (size != null)
			setPageSize(size);
		
		if(orientation != null)	
			setPageOrientation(orientation);

		if (margins != null) {
			setTopMargin(margins);
			setBottomMargin(margins);
			setRightMargin(margins);
			setLeftMargin(margins);
		}
	}

	ConverterInput(Resource resource, PageSize size, PageOrientation orientation) {
		super(resource);
		if (size != null)
			setPageSize(size);

		if (orientation != null)
			setPageOrientation(orientation);
	}

	ConverterInput(Resource resource, PageSize size) {
		super(resource);
		if (size != null)
			setPageSize(size);
	}

	ConverterInput(Resource resource) {
		super(resource);	
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
	 * Gets the page width.
	 * @return The page width.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public Float getPageWidth() {
		return pageWidth;
	}

	/**
	 * Sets the page width.
	 * @param value The page width.
	 */
	public void setPageWidth(Float value) {
		pageWidth = value;
	}

	/**
	 * Gets the page height.
	 * @return The page height.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public Float getPageHeight() {
		return pageHeight;
	}

	/**
	 * Sets the page height.
	 * @param value The page height.
	 */
	public void setPageHeight(Float value) {
		pageHeight = value;
	}

	/**
	 * Gets the page size.
	 * @return The page size.
	 */
	@JsonIgnore
	public PageSize getPageSize() {
		return pageSize;
	}

	/**
	 * Sets the page size.
	 * @param value The page size.
	 */
	public void setPageSize(PageSize value) {

		pageSize = value;
		double[] paperSize = UnitConverter.getPaperSize(value);
		double smaller = paperSize[0];
		double larger = paperSize[1];
		if (getPageOrientation() == PageOrientation.LANDSCAPE) {
			setPageHeight((float) smaller);
			setPageWidth((float) larger);
		} else {
			setPageHeight((float) larger);
			setPageWidth((float) smaller);
		}
	}

	/**
	 * Gets the page orientation.
	 * @return The page orientation.
	 */
	@JsonIgnore
	public PageOrientation getPageOrientation() {
		return pageOrientation;
	}

	/**
	 * Sets the page orientation.
	 * @param value The page orientation.
	 */
	public void setPageOrientation(PageOrientation value) {

		pageOrientation = value;
		float smaller;
		float larger;
		if (getPageWidth() != null && getPageHeight() != null){
			if (getPageWidth() > getPageHeight()) {
				smaller = getPageHeight();
				larger = getPageWidth();
			} else {
				smaller = getPageWidth();
				larger = getPageHeight();
			}
			if (getPageOrientation() == PageOrientation.LANDSCAPE) {
				setPageHeight(smaller);
				setPageWidth(larger);
			} else {
				setPageHeight(larger);
				setPageWidth(smaller);
			}
		}
	}
}
