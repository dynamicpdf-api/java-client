package com.dynamicpdf.api;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Represents the Layout data resource used to create PDF reports. 
 */
public class LayoutDataResource extends Resource {

    private ResourceType type = ResourceType.LAYOUTDATA;    
    private String layoutDataResourceName;

    /**
     * Initializes a new instance of the <code>LayoutDataResource</code> class 
     * using the layout data object and a resource name.
     * @param layoutData Serializable object data to create PDF report.
     * @param layoutDataResourceName The name for layout data resource.
     */
    public LayoutDataResource(Object layoutData, String layoutDataResourceName) {
    	super();   
    	String jsonText = null;
    	ObjectMapper basicMapper = new ObjectMapper();
    	try {
    		jsonText =  basicMapper.writeValueAsString(layoutData);
    	} catch (JsonProcessingException e1) {
    		e1.printStackTrace();
    	}

    	try {
    		setData(jsonText.getBytes("UTF8"));
    	} catch (UnsupportedEncodingException ex) {
    	}        
    	if (layoutDataResourceName == null) {
    		this.layoutDataResourceName = UUID.randomUUID().toString() + ".json";
    	} else {
    		this.layoutDataResourceName = layoutDataResourceName;
    	}

    }

    /**
     * Initializes a new instance of the <code>LayoutDataResource</code> class 
     * using the layout data object.
     * @param layoutData Serializable object data to create PDF report.
     */
    public LayoutDataResource(Object layoutData) {
        this(layoutData, null);
    }

    /**
     * Initializes a new instance of the <code>LayoutDataResource</code> class 
     * using a JSON file with data and a resource name.
     * @param layoutData The layout data JSON file path.
     * @param layoutDataResourceName The name for layout data resource.
     */
    public LayoutDataResource(String layoutData, String layoutDataResourceName) {
        super();
        setData(Resource.getUTF8FileData(layoutData));
        if (layoutDataResourceName == null) {
            this.layoutDataResourceName = UUID.randomUUID().toString() + ".json";
        } else {
            this.layoutDataResourceName = layoutDataResourceName;
        }
    }

    /**
     * Initializes a new instance of the <code>LayoutDataResource</code> class 
     * using a JSON file with data.
     * @param layoutData The layout data JSON file path.
     */
    public LayoutDataResource(String layoutData) {
        this(layoutData, null);
    }

    ResourceType getType() {
        return type;
    }

    String getFileExtension() {
        return ".json";
    }

    String getMimeType() {
        return "application/json";
    }

    /**
     * Gets the name of the layout data resource.
     * @return The name of the layout data resource.
     */
    public String getLayoutDataResourceName() {
        return layoutDataResourceName;
    }

    /**
     * Sets the name of the layout data resource.
     * @param value The name of the layout data resource.
     */
    public void setLayoutDataResourceName(String value) {
        layoutDataResourceName = value;
    }
}
