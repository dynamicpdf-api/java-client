package com.dynamicpdf.api;

import java.io.InputStream;

/**
 * Represents a Dlex resource object that is created using the DLEX file and a name.
 */
public class DlexResource extends Resource {

    private String layoutDataResourceName;
    private ResourceType type = ResourceType.DLEX;    

    /**
     * Initializes a new instance of the <code>DlexResource</code> class 
     * with DLEX file path and resource name as parameters.
     * @param dlexPath The dlex file path.
     * @param resourceName The name of the resource.
     */
    public DlexResource(String dlexPath, String resourceName) {
        super(dlexPath, resourceName);
    }

    /**
     * Initializes a new instance of the <code>DlexResource</code> class 
     * with DLEX file path as parameter.
     * @param dlexPath The dlex file path.
     */
    public DlexResource(String dlexPath) {
        super(dlexPath, null);
    }

    /**
     * Initializes a new instance of the <code>DlexResource</code> class
     * with byte data of the DLEX file and resource name as parameters.
     * @param value The byte array of the dlex file.
     * @param resourceName The name of the resource.
     */
    public DlexResource(byte[] value, String resourceName) {
        super(value, resourceName);
    }

    /**
     * Initializes a new instance of the <code>DlexResource</code> class
     * with byte data of the DLEX file as parameter.
     * @param value The byte array of the dlex file.
     */
    public DlexResource(byte[] value) {
        super(value, null);
    }

    /**
     * Initializes a new instance of the <code>DlexResource</code> class 
     * with stream of the DLEX file and resource name as parameters.
     * @param data The stream of the dlex file.
     * @param resourceName The name of the resource.
     */
    public DlexResource(InputStream data, String resourceName) {
        super(data, resourceName);
    }

    /**
     * Initializes a new instance of the <code>DlexResource</code> class 
     * with stream of the DLEX file as parameter.
     * @param data The stream of the dlex file.
     */
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

    /**
     * Gets the name for layout data resource.
     * @return The name for layout data resource.
     */
    public String getLayoutDataResourceName() {
        return layoutDataResourceName;
    }

    /**
     * Sets the name for layout data resource.
     * @param value The name for layout data resource.
     */
    public void setLayoutDataResourceName(String value) {
        layoutDataResourceName = value;
    }
}
