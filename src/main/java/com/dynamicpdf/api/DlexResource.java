package com.dynamicpdf.api;

import java.io.InputStream;

public class DlexResource extends Resource {

    private String layoutDataResourceName;
    private ResourceType type = ResourceType.Dlex;    

    public DlexResource(String dlexPath, String resourceName) {
        super(dlexPath, resourceName);
    }

    public DlexResource(String dlexPath) {
        super(dlexPath, null);
    }

    public DlexResource(byte[] value, String resourceName) {
        super(value, resourceName);
    }

    public DlexResource(byte[] value) {
        super(value, null);
    }

    public DlexResource(InputStream data, String resourceName) {
        super(data, resourceName);
    }

    public DlexResource(InputStream data) {
        super(data, null);
    }

    ResourceType getType() {
        return type;
    }

    String getFileExtension() {
        return ".dlex";
    }

    String getMimeType() {
        return "application/xml";
    }

    public String getLayoutDataResourceName() {
        return layoutDataResourceName;
    }

    public void setLayoutDataResourceName(String value) {
        layoutDataResourceName = value;
    }
}
