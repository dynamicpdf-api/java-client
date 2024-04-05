package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Excel input.
 */
public class ExcelInput extends ConverterInput {

	/**
	 * Initializes a new instance of the <code>ExcelInput</code> class.
	 * @param resource The resource of type <code>ExcelResource</code>.
	 * @param size The page size of the output PDF.
	 * @param orientation The page orientation of the output PDF.
	 * @param margins The page margins of the output PDF.
	 */
	public ExcelInput(ExcelResource resource, PageSize size, PageOrientation orientation, Float margins) {
		super(resource, size, orientation, margins);
	}

	/**
	 * Initializes a new instance of the <code>ExcelInput</code> class.
	 * @param resource The resource of type <code>ExcelResource</code>.
	 * @param size The page size of the output PDF.
	 * @param orientation The page orientation of the output PDF.
	 */
	public ExcelInput(ExcelResource resource, PageSize size, PageOrientation orientation) {
		super(resource, size, orientation);
	}
	
	/**
	 * Initializes a new instance of the <code>ExcelInput</code> class.
	 * @param resource The resource of type <code>ExcelResource</code>.
	 * @param size The page size of the output PDF.
	 */
	public ExcelInput(ExcelResource resource, PageSize size) {
		super(resource, size);
	}
	
	/**
	 * Initializes a new instance of the <code>ExcelInput</code> class.
	 * @param resource The resource of type <code>ExcelResource</code>.
	 */
	public ExcelInput(ExcelResource resource) {
		super(resource);
	}

	@JsonInclude
	@JsonProperty("type")
	InputType getType() {
		return InputType.EXCEL;
	}
}
