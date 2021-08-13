package com.dynamicpdf.api;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class LayoutDataResource extends Resource {

    private ResourceType type = ResourceType.LayoutData;    
    private String layoutDataResourceName;

    public LayoutDataResource(Object layoutData, String layoutDataResourceName) {
        super();        
//        String jsonText = JsonConvert.SerializeObject(layoutData, new JsonSerializerSettings
//            {
//                ContractResolver = new CamelCasePropertyNamesContractResolver()
//            });
//
//            try {
//                setData(jsonText.getBytes("UTF8"));
//            } catch (UnsupportedEncodingException ex) {
//            }        
//        if (layoutDataResourceName == null) {
//            this.layoutDataResourceName = UUID.randomUUID().toString() + ".json";
//        } else {
//            this.layoutDataResourceName = layoutDataResourceName;
//        }

    }

    public LayoutDataResource(Object layoutData) {
        this(layoutData, null);
    }

    public LayoutDataResource(String layoutData, String layoutDataResourceName) {
        super();
        setData(Resource.getUTF8FileData(layoutData));
        if (layoutDataResourceName == null) {
            this.layoutDataResourceName = UUID.randomUUID().toString() + ".json";
        } else {
            this.layoutDataResourceName = layoutDataResourceName;
        }
    }

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

    public String getLayoutDataResourceName() {
        return layoutDataResourceName;
    }

    public void setLayoutDataResourceName(String value) {
        layoutDataResourceName = value;
    }
}
