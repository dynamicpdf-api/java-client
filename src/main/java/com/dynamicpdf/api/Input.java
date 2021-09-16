package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents the base class for inputs.
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public abstract class Input {

	private String templateId = null;
	private List<Resource> resources = new ArrayList<Resource>();
	private Template template;
	private InputType inputType;
	private String resourceName;
	private String id;

	Input() {
	}

	Input(String cloudResourcePath) {
		resourceName = cloudResourcePath;
	}

	Input(Resource resource) {
		resources.add(resource);
		resourceName = resource.getResourceName();
	}

	@JsonInclude
	@JsonProperty("type")
	abstract InputType getType();

	@JsonProperty
	String getTemplateId() {
		return templateId;
	}

	void setTemplateId(String value) {
		templateId = value;
	}

	@JsonIgnore
	List<Resource> getResources() {
		return resources;
	}

	void setResources(List<Resource> value) {
		resources = value;
	}

	/**
	 * Gets  the resource name.
	 * @return The resource name.
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * Sets  the resource name.
	 * @param value The resource name.
	 */
	public void setResourceName(String value) {
		resourceName = value;
	}

	/**
	 * Gets the id.
	 * @return The id.
	 */
	public String getId() {
		if (id == null)
        {
            id = UUID.randomUUID().toString();
        }
		return id;
	}

	/**
	 * Sets the id.
	 * @param value The id.
	 */
	public void setId(String value) {
		id = value;
	}

	/**
	 * Gets the template.
	 * @return The template.
	 */
	@JsonIgnore
	public Template getTemplate() {
		return this.template;
	}

	/**
	 * Sets the template.
	 * @param value The template.
	 */
	public void setTemplate(Template value) {
		this.template = value;
		setTemplateId(template.getId());
	}
}
