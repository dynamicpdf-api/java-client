package com.dynamicpdf.api;

import java.io.InputStream;

public class PdfResource extends Resource {

    private ResourceType resourceType = ResourceType.Pdf;

    
    public PdfResource(String filePath, String resourceName) {
        super(filePath, resourceName);
    }

    public PdfResource(String filePath) {
        super(filePath, null);
    }

    public PdfResource(byte[] value, String resourceName) {
        super(value, resourceName);
    }

    public PdfResource(byte[] value) {
        super(value, null);
    }

    public PdfResource(InputStream data, String resourceName) {
        super(data, resourceName);
    }

    public PdfResource(InputStream data) {
        super(data, null);
    }    

    ResourceType getType() {
        return resourceType;
    }

    String getFileExtension() {
        return ".pdf";
    }

    String getMimeType() {
        return "application/pdf";
    }

}
