package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String value) {
        resourceName = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        id = value;
    }

    @JsonIgnore
    public Template getTemplate() {
        return this.template;
    }

    public void setTemplate(Template value) {
        this.template = value;
        setTemplateId(template.getId());
    }
}
