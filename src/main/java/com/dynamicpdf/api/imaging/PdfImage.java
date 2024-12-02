package com.dynamicpdf.api.imaging;

import com.dynamicpdf.api.Endpoint;
import com.dynamicpdf.api.EndpointException;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.imaging.PdfImageResponse.Image;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.List;

/**
 * Represents a PDF Rasterizing endpoint that converts PDF to image.
 */
public class PdfImage extends Endpoint {
    private PdfResource resource;
    private Integer startPageNumber;
    private Integer pageCount;
    private ImageFormat imageFormat;
    private ImageSize imageSize;

    public PdfImage(PdfResource resource) {
        this.resource = resource;
    }

    public String getEndpointName() {
        return "pdf-image";
    }

    /**
     * Gets the starting page number for rasterization.
     * 
     * @return The start Page Number.
     */
    public Integer getStartPageNumber() {
        return startPageNumber;
    }

    /**
     * Sets the starting page number for rasterization.
     * 
     * @param startPageNumber The start Page Number.
     */
    public void setStartPageNumber(Integer startPageNumber) {
        this.startPageNumber = startPageNumber;
    }

    /**
     * Gets the number of pages to rasterize.
     * 
     * @return The page Count.
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * Sets the number of pages to rasterize.
     * 
     * @param pageCount The page Count.
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Gets the image format for rasterization.
     * 
     * @return The image Format.
     */
    public ImageFormat getImageFormat() {
        return imageFormat;
    }

    /**
     * Sets the image format for rasterization.
     * 
     * @param imageFormat The image Format.
     */
    public void setImageFormat(ImageFormat imageFormat) {
        this.imageFormat = imageFormat;
    }

    /**
     * Gets the size of the rasterized images.
     * 
     * @return The image Size.
     */
    public ImageSize getImageSize() {
        return imageSize;
    }

    /**
     * Sets the size of the rasterized images.
     * 
     * @param imageSize The image Size.
     */
    public void setImageSize(ImageSize imageSize) {
        this.imageSize = imageSize;
    }

    public PdfImageResponse process() {
        CompletableFuture<PdfImageResponse> cf = processAsync();
        try {
            return cf.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CompletableFuture<PdfImageResponse> processAsync() {
        return CompletableFuture.supplyAsync(() -> {
            RequestSpecification spec = super.createRequestSpecification();
            PdfImageResponse imagingResponse = null;

            if (startPageNumber != null) {
                spec.queryParam("sp", startPageNumber);
            }
            if (pageCount != null) {
                spec.queryParam("pc", pageCount);
            }

            if (imageSize != null) {
                if (imageSize instanceof DpiImageSize) {
                    DpiImageSize dpi = (DpiImageSize) imageSize;
                    spec.queryParam("is", dpi.getType());
                    if (dpi.getHorizontalDpi() != null) {
                        spec.queryParam("hd", dpi.getHorizontalDpi());
                    }
                    if (dpi.getVerticalDpi() != null) {
                        spec.queryParam("vd", dpi.getVerticalDpi());
                    }
                } else if (imageSize instanceof FixedImageSize) {
                    FixedImageSize fixedSize = (FixedImageSize) imageSize;
                    spec.queryParam("is", fixedSize.getType());
                    if (fixedSize.getHeight() != null) {
                        spec.queryParam("ht", fixedSize.getHeight());
                    }
                    if (fixedSize.getWidth() != null) {
                        spec.queryParam("wd", fixedSize.getWidth());
                    }
                    if (fixedSize.getUnit() != null) {
                        spec.queryParam("ut", fixedSize.getUnit());
                    }
                } else if (imageSize instanceof MaxImageSize) {
                    MaxImageSize maxSize = (MaxImageSize) imageSize;
                    spec.queryParam("is", maxSize.getType().toString());
                    if (maxSize.getMaxHeight() != null)
                        spec.queryParam("mh", maxSize.getMaxHeight().toString());
                    if (maxSize.getMaxWidth() != null)
                        spec.queryParam("mw", maxSize.getMaxWidth().toString());
                    if (maxSize.getUnit() != null)
                        spec.queryParam("ut", maxSize.getUnit().toString());
                } else if (imageSize instanceof PercentageImageSize) {
                    PercentageImageSize percent = (PercentageImageSize) imageSize;
                    spec.queryParam("is", percent.getType().toString());
                    if (percent.getHorizontalPercentage() != null)
                        spec.queryParam("hp", percent.getHorizontalPercentage().toString());
                    if (percent.getVerticalPercentage() != null)
                        spec.queryParam("vp", percent.getVerticalPercentage().toString());
                }
            }

            if (imageFormat != null) {
                if (imageFormat instanceof GifImageFormat) {
                    GifImageFormat gif = (GifImageFormat) imageFormat;
                    spec.queryParam("if", gif.getType().toString());
                    if (gif.getDitheringPercent() != null)
                        spec.queryParam("dp", gif.getDitheringPercent().toString());
                    if (gif.getDitheringAlgorithm() != null)
                        spec.queryParam("da", gif.getDitheringAlgorithm().toString());
                } else if (imageFormat instanceof JpegImageFormat) {
                    JpegImageFormat jpeg = (JpegImageFormat) imageFormat;
                    spec.queryParam("if", jpeg.getType().toString());
                    if (jpeg.getQuality() != null)
                        spec.queryParam("qt", jpeg.getQuality().toString());
                } else if (imageFormat instanceof PngImageFormat) {
                    PngImageFormat png = (PngImageFormat) imageFormat;
                    spec.queryParam("if", png.getType().toString());
                    if (png.getColorFormat() != null) {
                        spec.queryParam("cf", png.getColorFormat().getType().toString());
                        if (png.getColorFormat() instanceof PngIndexedColorFormat) {
                            PngIndexedColorFormat pngicf = (PngIndexedColorFormat) png.getColorFormat();
                            if (pngicf.getDitheringAlgorithm() != null)
                                spec.queryParam("da", pngicf.getDitheringAlgorithm().toString());
                            if (pngicf.getDitheringPercent() != null)
                                spec.queryParam("dp", pngicf.getDitheringPercent().toString());
                            if (pngicf.getQuantizationAlgorithm() != null)
                                spec.queryParam("qa", pngicf.getQuantizationAlgorithm().toString());
                        } else if (png.getColorFormat() instanceof PngMonochromeColorFormat) {
                            PngMonochromeColorFormat pngmccf = (PngMonochromeColorFormat) png.getColorFormat();
                            if (pngmccf.getBlackThreshold() != null)
                                spec.queryParam("bt", pngmccf.getBlackThreshold().toString());
                            if (pngmccf.getDitheringAlgorithm() != null)
                                spec.queryParam("da", pngmccf.getDitheringAlgorithm().toString());
                            if (pngmccf.getDitheringPercent() != null)
                                spec.queryParam("dp", pngmccf.getDitheringPercent().toString());
                        }
                    }
                } else if (imageFormat instanceof TiffImageFormat) {
                    TiffImageFormat tiff = (TiffImageFormat) imageFormat;
                    spec.queryParam("if", tiff.getType().toString());
                    if (tiff.isMultiPage())
                        spec.queryParam("mp", "true");
                    if (tiff.getColorFormat() != null) {
                        spec.queryParam("cf", tiff.getColorFormat().getType().toString());
                        if (tiff.getColorFormat() instanceof TiffIndexedColorFormat) {
                            TiffIndexedColorFormat tifficf = (TiffIndexedColorFormat) tiff.getColorFormat();
                            if (tifficf.getDitheringAlgorithm() != null)
                                spec.queryParam("da", tifficf.getDitheringAlgorithm().toString());
                            if (tifficf.getDitheringPercent() != null)
                                spec.queryParam("dp", tifficf.getDitheringPercent().toString());
                            if (tifficf.getQuantizationAlgorithm() != null)
                                spec.queryParam("qa", tifficf.getQuantizationAlgorithm().toString());
                        } else if (tiff.getColorFormat() instanceof TiffMonochromeColorFormat) {
                            TiffMonochromeColorFormat tiffmccf = (TiffMonochromeColorFormat) tiff.getColorFormat();
                            if (tiffmccf.getCompressionType() != null)
                                spec.queryParam("ct", tiffmccf.getCompressionType().toString());
                            if (tiffmccf.getBlackThreshold() != null)
                                spec.queryParam("bt", tiffmccf.getBlackThreshold().toString());
                            if (tiffmccf.getDitheringAlgorithm() != null)
                                spec.queryParam("da", tiffmccf.getDitheringAlgorithm().toString());
                            if (tiffmccf.getDitheringPercent() != null)
                                spec.queryParam("dp", tiffmccf.getDitheringPercent().toString());
                        }
                    }
                } else if (imageFormat instanceof BmpImageFormat) {
                    BmpImageFormat bmp = (BmpImageFormat) imageFormat;
                    spec.queryParam("if", bmp.getType().toString());
                    if (bmp.getColorFormat() != null && bmp.getColorFormat() instanceof BmpMonochromeColorFormat) {
                        BmpMonochromeColorFormat bmpmcf = (BmpMonochromeColorFormat) bmp.getColorFormat();
                        if (bmpmcf.getBlackThreshold() != null)
                            spec.queryParam("bt", bmpmcf.getBlackThreshold().toString());
                        if (bmpmcf.getDitheringPercent() != null)
                            spec.queryParam("dp", bmpmcf.getDitheringPercent().toString());
                        if (bmpmcf.getDitheringAlgorithm() != null)
                            spec.queryParam("da", bmpmcf.getDitheringAlgorithm().toString());
                    }
                }
            }

            imagingResponse = new PdfImageResponse();
            if (resource == null) {
                throw new EndpointException("Required a PDF Resource.");
            }
            spec.multiPart("pdf", resource.getResourceName(), resource.getData(), resource.getMimeType());

            Response response = RestAssured
                    .given()
                    .header("Accept", "*/*")
                    .header("Content-Type", "multipart/form-data")
                    .spec(spec)
                    .post(getDefaultBaseUrl() + "/" + getEndpointVersion() + "/" + getEndpointName());

            if (response.getStatusCode() == 200) {
                String jsonString = response.getBody().asString();
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    PdfImageResponse imageResponse = objectMapper.readValue(jsonString, PdfImageResponse.class);
                    String imageType = imageResponse.getContentType();
                    imagingResponse.setImageFormat(imageType.substring(imageType.indexOf('/') + 1));
                    List<Image> images = imageResponse.getImages();
                    for (Image image : images) {
                        imagingResponse.getImages().add(image);
                    }                 
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imagingResponse.setIsSuccessful(true);
                imagingResponse.setStatusCode(response.getStatusCode());
            } else {
                if (response.getStatusCode() == 401) {
					throw new EndpointException("Invalid api key specified.");
				}
                String errorMessage = response.jsonPath().getString("message");
                UUID errorId = response.jsonPath().getUUID("id");
                imagingResponse.setErrorId(errorId);
                imagingResponse.setErrorJson(response.asString());
                imagingResponse.setErrorMessage(errorMessage);
                imagingResponse.setIsSuccessful(false);
                imagingResponse.setStatusCode(response.getStatusCode());
            }
            return imagingResponse;
        });
    }
}
