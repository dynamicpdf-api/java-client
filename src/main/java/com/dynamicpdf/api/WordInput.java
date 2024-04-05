package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Word input.
 */
public class WordInput extends ConverterInput {

	private List<TextReplace> textReplace;

	/**
	 * Initializes a new instance of the <code>WordInput</code> class.
	 * @param resource The resource of type <code>WordResource</code>.
	 * @param size The page size of the output PDF.
	 * @param orientation The page orientation of the output PDF.
	 * @param margins The page margins of the output PDF.
	 */
	public WordInput(WordResource resource, PageSize size, PageOrientation orientation, Float margins) {
		super(resource, size, orientation, margins);
	}

	/**
	 * Initializes a new instance of the <code>WordInput</code> class.
	 * @param resource The resource of type <code>WordResource</code>.
	 * @param size The page size of the output PDF.
	 * @param orientation The page orientation of the output PDF.
	 */
	public WordInput(WordResource resource, PageSize size, PageOrientation orientation) {
		super(resource, size, orientation);
	}
	
	/**
	 * Initializes a new instance of the <code>WordInput</code> class.
	 * @param resource The resource of type <code>WordResource</code>.
	 * @param size The page size of the output PDF.
	 */
	public WordInput(WordResource resource, PageSize size) {
		super(resource, size);
	}
	
	/**
	 * Initializes a new instance of the <code>WordInput</code> class.
	 * @param resource The resource of type <code>WordResource</code>.
	 */
	public WordInput(WordResource resource) {
		super(resource);
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
}
