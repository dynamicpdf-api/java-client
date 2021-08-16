package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.Resource;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class ImageElement extends Element {

    private Resource resource;
    private String resourceName;
    private float scaleX;
    private float scaleY;
    private float maxHeight;
    private float maxWidth;

    public ImageElement(ImageResource resource, ElementPlacement placement, float xOffset, float yOffset) {
        super();
        this.resource = resource;
        this.resourceName = resource.getResourceName();
        setPlacement(placement);
        setXOffset(xOffset);
        setYOffset(yOffset);
    }

    public ImageElement(ImageResource resource, ElementPlacement placement) {
        this(resource, placement, 0, 0);
    }

    public ImageElement(String resourceName, ElementPlacement placement, float xOffset, float yOffset) {
        super();
        this.resourceName = resourceName;
        setPlacement(placement);
        setXOffset(xOffset);
        setYOffset(yOffset);
    }

    public ImageElement(String resourceName, ElementPlacement placement) {
        this(resourceName, placement, 0, 0);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.IMAGE;
    }

    @JsonIgnore
    public Resource getResource() {
        return resource;
    }

    void setResource(Resource value) {
        resource = value;
    }

    @JsonProperty("resourceName")
    String getResourceName() {
        return resourceName;
    }

    void setResourceName(String value) {
        resourceName = value;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float value) {
        scaleX = value;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float value) {
        scaleY = value;
    }

    public float getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(float value) {
        maxHeight = value;
    }

    public float getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(float value) {
        maxWidth = value;
    }
}
