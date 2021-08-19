package com.dynamicpdf.api;

import java.io.InputStream;

class FontResource extends Resource {

    ResourceType resourceType = ResourceType.FONT;
    String mimeType;

    FontResource(String filePath, String resourceName) {
        super(filePath, resourceName);
    }

    FontResource(String filePath) {
        super(filePath, null);
    }

    FontResource(InputStream data, String resourceName) {
        super(data, resourceName);
    }

    FontResource(InputStream data) {
        super(data, null);
    }

    ResourceType getType() {
        return resourceType;
    }

    String getMimeType() {
        return mimeType;
    }

    void setMimeType(String value) {
        mimeType = value;
    }

    String getFileExtension() {

        if (getData()[0] == 0x4f && getData()[1] == 0x54 && getData()[2] == 0x54 && getData()[3] == 0x4f) {
            mimeType = "font/otf";
            return ".otf";
        } else if (getData()[0] == 0x00 && getData()[1] == 0x01 && getData()[2] == 0x00 && getData()[3] == 0x00) {
            mimeType = "font/ttf";
            return ".ttf";
        } else {
            throw new EndpointException("Unsupported font");
        }

    }
}
