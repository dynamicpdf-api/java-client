package com.dynamicpdf.api;

import com.dynamicpdf.api.elements.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a document template.
 */
public class Template {

	private String id = null;
	private List<Element> elements = new ArrayList<Element>();

	/**
	 * Initializes a new instance of the <code>Template</code> class.
	 * 
	 * @param id The id string representing id for the template.
	 */
	public Template(String id) {
		if (id == null) {
			this.id = UUID.randomUUID().toString();
		} else {
			this.id = id;
		}
	}

	/**
	 * Initializes a new instance of the <code>Template</code> class.
	 */
	public Template() {
		this(null);
	}

	/**
	 * Gets the id for the template.
	 * @return The id for the template.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id for the template.
	 * @param value The id for the template.
	 */
	public void setId(String value) {
		id = value;
	}

	/**
	 * Gets the elements for the template.
	 * @return The elements for the template.
	 */
	public List<Element> getElements() {
		return elements;
	}

	/**
	 * Sets the elements for the template.
	 * @param value The elements for the template.
	 */
	public void setElements(List<Element> value) {
		elements = value;
	}
}
