package com.dynamicpdf.api;

public class AdditionalResource extends Resource{

	private String mimeType ="";
	private ResourceType type = ResourceType.LAYOUTDATA;
	AdditionalResource(String resourcePath, String resourceName){
		super(resourcePath, resourceName);
        setType(getResourceType(resourcePath));
    }

    AdditionalResource(byte[] resourceData, String resourceName, ResourceType type){
    	super(resourceData, resourceName);
    	setType(type);
    }

    private ResourceType getResourceType(String resourcePath){
        ResourceType type = ResourceType.PDF;
        int extIndex = resourcePath.lastIndexOf('.');
        String fileExtension = resourcePath.substring(extIndex).toLowerCase();
        switch(fileExtension)
        {
            case ".pdf":
                type = ResourceType.PDF;
                break;
            case ".dlex":
                type = ResourceType.DLEX;
                break;
            case ".json":
                type = ResourceType.LAYOUTDATA;
                break;
            case ".ttf":
            case ".otf":
                type = ResourceType.FONT;
                break;
            case ".tiff":
            case ".tif":
            case ".png":
            case ".gif":
            case ".jpeg":
            case ".jpg":
            case ".bmp":
                type = ResourceType.IMAGE;
                break;
        }
        return type;
    }
    
    ResourceType getType() { 
        return type;
    }
    
    void setType(ResourceType value) {
    	type = value;
    }

    String getFileExtension(){
    	switch(getType()) {
    	case IMAGE:
    		 byte[] fileHeader = new byte[16];
             System.arraycopy(getData(), 0,fileHeader, 0, 16);
             if (ImageResource.isPngImage(fileHeader))
             {
                 setMimeType("image/png");
                 return ".png";
             }
             else if (ImageResource.isJpegImage(fileHeader))
             {
             	setMimeType("image/jpeg");
                 return ".jpeg";
             }
             else if (ImageResource.isGifImage(fileHeader))
             {
             	setMimeType("image/gif");
                 return ".gif";
             }
             else if (ImageResource.isTiffImage(fileHeader))
             {
             	setMimeType("image/tiff");
                 return ".tiff";
             }
             else if (ImageResource.isJpeg2000Image(fileHeader))
             {
             	setMimeType("image/jpeg");
                 return ".jpeg";
             }
             else if (ImageResource.isValidBitmapImage(fileHeader))
             {
             	setMimeType("image/bmp");
                 return ".bmp";
             }
             else
                 throw new EndpointException("Not supported image type or invalid image.");
    	case PDF:
    		setMimeType("application/pdf");
            return ".pdf";
    	case LAYOUTDATA:
    		setMimeType("application/json");
            return ".json";
    	case DLEX:
    		setMimeType("application/xml");
            return ".dlex";
    	case FONT:
    		if (getData()[0] == 0x4f && getData()[1] == 0x54 && getData()[2] == 0x54 && getData()[3] == 0x4f)
            {
            	setMimeType("font/otf");
                return ".otf";
            }
            else if (getData()[0] == 0x00 && getData()[1] == 0x01 && getData()[2] == 0x00 && getData()[3] == 0x00)
            {
            	setMimeType("font/ttf");
                return ".ttf";
            }
            else
            {
                throw new EndpointException("Unsupported font");
            }
    	}
    	
		/*
		 * if (getType() == ResourceType.IMAGE) { byte[] fileHeader = new byte[16];
		 * System.arraycopy(getData(), 0,fileHeader, 0, 16); if
		 * (ImageResource.isPngImage(fileHeader)) { setMimeType("image/png"); return
		 * ".png"; } else if (ImageResource.isJpegImage(fileHeader)) {
		 * setMimeType("image/jpeg"); return ".jpeg"; } else if
		 * (ImageResource.isGifImage(fileHeader)) { setMimeType("image/gif"); return
		 * ".gif"; } else if (ImageResource.isTiffImage(fileHeader)) {
		 * setMimeType("image/tiff"); return ".tiff"; } else if
		 * (ImageResource.isJpeg2000Image(fileHeader)) { setMimeType("image/jpeg");
		 * return ".jpeg"; } else if (ImageResource.isValidBitmapImage(fileHeader)) {
		 * setMimeType("image/bmp"); return ".bmp"; } else throw new
		 * EndpointException("Not supported image type or invalid image."); } else if
		 * (getType() == ResourceType.PDF) { setMimeType("application/pdf"); return
		 * ".pdf"; } else if (getType() == ResourceType.LAYOUTDATA) {
		 * setMimeType("application/json"); return ".json"; } else if (getType() ==
		 * ResourceType.DLEX) { setMimeType("application/xml"); return ".dlex"; } else
		 * if (getType() == ResourceType.FONT) { if (getData()[0] == 0x4f &&
		 * getData()[1] == 0x54 && getData()[2] == 0x54 && getData()[3] == 0x4f) {
		 * setMimeType("font/otf"); return ".otf"; } else if (getData()[0] == 0x00 &&
		 * getData()[1] == 0x01 && getData()[2] == 0x00 && getData()[3] == 0x00) {
		 * setMimeType("font/ttf"); return ".ttf"; } else { throw new
		 * EndpointException("Unsupported font"); } }
		 */
            return null;

    }

    String getMimeType() { 
      return mimeType;
    }
    
    void setMimeType(String value) {
    	mimeType = value;
    }
}
