package com.dynamicpdf.api;

import java.io.InputStream;

public class ImageResource extends Resource {

    ResourceType resourceType = ResourceType.Image;
    String mimeType;

    public ImageResource(String filePath, String resourceName) {
        super(filePath, resourceName);
    }

    public ImageResource(String filePath) {
        super(filePath, null);
    }

    public ImageResource(byte[] value, String resourceName) {
        super(value, resourceName);
    }

    public ImageResource(byte[] value) {
        super(value, null);
    }

    public ImageResource(InputStream data, String resourceName) {
        super(data, resourceName);
    }

    public ImageResource(InputStream data) {
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
        byte[] fileHeader = new byte[16];
        System.arraycopy(getData(), 0, fileHeader, 0, 16);
        if (isPngImage(fileHeader)) {
            mimeType = "image/png";
            return ".png";
        } else if (isJpegImage(fileHeader)) {
            mimeType = "image/jpeg";
            return ".jpeg";
        } else if (isGifImage(fileHeader)) {
            mimeType = "image/gif";
            return ".gif";
        } else if (isTiffImage(fileHeader)) {
            mimeType = "image/tiff";
            return ".tiff";
        } else if (isJpeg2000Image(fileHeader)) {
            mimeType = "image/jpeg";
            return ".jpeg";
        } else if (isValidBitmapImage(fileHeader)) {
            mimeType = "image/bmp";
            return ".bmp";
        } else {
            throw new EndpointException("Not supported image type or invalid image.");
        }
    }

    private static boolean isJpeg2000Image(byte[] header) {
        return (header[0] == 0x00 && header[1] == 0x00 && header[2] == 0x00 && header[3] == 0x0C && header[4] == 0x6A
                && header[5] == 0x50 && (header[6] == 0x1A || header[6] == 0x20) && (header[7] == 0x1A || header[7] == 0x20)
                && header[8] == 0x0D && header[9] == 0x0A && header[10] == 0x87 && header[11] == 0x0A)
                || (header[0] == 0xFF && header[1] == 0x4F && header[2] == 0xFF && header[3] == 0x51 && header[6] == 0x00 && header[7] == 0x00);
    }

    private static boolean isPngImage(byte[] header) {
        return header[0] == 0x89 && header[1] == 0x50 && header[2] == 0x4E && header[3] == 0x47
                && header[4] == 0x0D && header[5] == 0x0A && header[6] == 0x1A && header[7] == 0x0A;
    }

    private static boolean isTiffImage(byte[] header) {
        return (header[0] == 0x49 && header[1] == 0x49 && header[2] == 0x2A && header[3] == 0x00)
                || (header[0] == 0x4D && header[1] == 0x4D && header[2] == 0x00 && header[3] == 0x2A);
    }

    private static boolean isGifImage(byte[] header) {
        return header[0] == 0x47 && header[1] == 0x49 && header[2] == 0x46 && header[3] == 0x38 && (header[4] == 0x37 || header[4] == 0x39) && header[5] == 0x61;
    }

    private static boolean isJpegImage(byte[] header) {
        return header[0] == 0xFF && header[1] == 0xD8 && header[2] == 0xFF;
    }

    private static boolean isValidBitmapImage(byte[] header) {
        return header[0] == 0x42 && header[1] == 0x4D;
    }
}
