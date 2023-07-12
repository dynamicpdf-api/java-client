package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Represents a Word input.
 */
public class WordInput extends Input {
	private PageSize pageSize = PageSize.LETTER;
	private PageOrientation pageOrientation = PageOrientation.PORTRAIT;
	private float pageWidth;
	private float pageHeight;
	private Float topMargin = null;
	private Float bottomMargin = null;
	private Float rightMargin = null;
	private Float leftMargin = null;
	private List<TextReplace> textReplace;

	/**
	 * Initializes a new instance of the <code>WordInput</code> class.
	 * @param resource The resource of type <code>WordResource</code>.
	 * @param size The page size of the output PDF.
	 * @param orientation The page orientation of the output PDF.
	 * @param margins The page margins of the output PDF.
	 */
	public WordInput(WordResource resource, PageSize size, PageOrientation orientation, Float margins) {
		super(resource);
		setPageSize(size);
		setPageOrientation(orientation);

		if (margins != null) {
			setTopMargin(margins);
			setBottomMargin(margins);
			setRightMargin(margins);
			setLeftMargin(margins);
		}
	}

	/**
	 * Initializes a new instance of the <code>WordInput</code> class.
	 * @param resource The resource of type <code>WordResource</code>.
	 * @param size The page size of the output PDF.
	 * @param orientation The page orientation of the output PDF.
	 */
	public WordInput(WordResource resource, PageSize size, PageOrientation orientation) {
		super(resource);
		setPageSize(size);
		setPageOrientation(orientation);
	}
	
	/**
	 * Initializes a new instance of the <code>WordInput</code> class.
	 * @param resource The resource of type <code>WordResource</code>.
	 * @param size The page size of the output PDF.
	 */
	public WordInput(WordResource resource, PageSize size) {
		super(resource);
		setPageSize(size);
		setPageOrientation(PageOrientation.PORTRAIT);
	}
	
	/**
	 * Initializes a new instance of the <code>WordInput</code> class.
	 * @param resource The resource of type <code>WordResource</code>.
	 */
	public WordInput(WordResource resource) {
		super(resource);
		setPageSize(PageSize.LETTER);
		setPageOrientation(PageOrientation.PORTRAIT);
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
	public float getPageWidth() {
		return pageWidth;
	}

	/**
	 * Sets the page width.
	 * @param value The page width.
	 */
	public void setPageWidth(float value) {
		pageWidth = value;
	}

	/**
	 * Gets the page height.
	 * @return The page height.
	 */
	@JsonSerialize(using = FloatJsonSerializer.class)
	public float getPageHeight() {
		return pageHeight;
	}

	/**
	 * Sets the page height.
	 * @param value The page height.
	 */
	public void setPageHeight(float value) {
		pageHeight = value;
	}

	/**
	 * Gets the <code>TextReplace</code> object List.
	 * @return The <code>TextReplace</code> object List.
	 */
	public List<TextReplace> getTextReplace() {
		if (this.textReplace == null) {
			this.textReplace = new ArrayList<TextReplace>();
		}
		return textReplace;
	}

	/**
	 * Sets the <code>TextReplace</code> object List.
	 * @param value The <code>TextReplace</code> object List.
	 */
	public void setTextReplace(List<TextReplace> value) {
		textReplace = value;
	}

	@JsonInclude
	@JsonProperty("type")
	InputType getType() {
		return InputType.WORD;
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
		if (getPageOrientation() == PageOrientation.PORTRAIT) {
			setPageHeight((float) larger);
			setPageWidth((float) smaller);
		} else {
			setPageHeight((float) smaller);
			setPageWidth((float) larger);
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
		if (getPageWidth() > getPageHeight()) {
			smaller = getPageHeight();
			larger = getPageWidth();
		} else {
			smaller = getPageWidth();
			larger = getPageHeight();
		}
		if (getPageOrientation() == PageOrientation.PORTRAIT) {
			setPageHeight(larger);
			setPageWidth(smaller);
		} else {
			setPageHeight(smaller);
			setPageWidth(larger);
		}
	}
}
