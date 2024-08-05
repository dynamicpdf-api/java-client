package com.dynamicpdf.api.imaging;

import com.dynamicpdf.api.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the response from a rasterization operation.
 */
public class PdfImageResponse extends Response {

    private String imageFormat;
    private List<Image> images = new ArrayList<>();
    private String contentType;
    private int horizontalDpi;
    private int verticalDpi;
    /**
     * Initializes a new instance of the PdfImageResponse class.
     */
    public PdfImageResponse() { }

    /**
     * Gets the image format.
     * @return The image format.
     */
    public String getImageFormat() {
        return imageFormat;
    }

    /**
     * Sets the image format.
     * @param imageFormat The image format.
     */
    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    /**
     * Gets the data of the images.
     * @return The list of images data.
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * Sets the data of the images.
     * @param images The list of images data.
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getHorizontalDpi() {
        return horizontalDpi;
    }

    public void setHorizontalDpi(int horizontalDpi) {
        this.horizontalDpi = horizontalDpi;
    }

    public int getVerticalDpi() {
        return verticalDpi;
    }

    public void setVerticalDpi(int verticalDpi) {
        this.verticalDpi = verticalDpi;
    }

    public static class Image {

        private int pageNumber;
        private String data;
        private int billedPages;
        private int width;
        private int height;
    
        // Getters and Setters
    
        public int getPageNumber() {
            return pageNumber;
        }
    
        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }
    
        public String getData() {
            return data;
        }
    
        public void setData(String data) {
            this.data = data;
        }
    
        public int getBilledPages() {
            return billedPages;
        }
    
        public void setBilledPages(int billedPages) {
            this.billedPages = billedPages;
        }
    
        public int getWidth() {
            return width;
        }
    
        public void setWidth(int width) {
            this.width = width;
        }
    
        public int getHeight() {
            return height;
        }
    
        public void setHeight(int height) {
            this.height = height;
        }
    }
    
}


