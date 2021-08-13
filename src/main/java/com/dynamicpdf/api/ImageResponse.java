package com.dynamicpdf.api;

import java.util.List;

public class ImageResponse extends JsonResponse {

    private List<ImageInformation> content;

    public ImageResponse() {
        super();
    }

    public ImageResponse(String jsonContent) {
        super(jsonContent);
        //content = JsonConvert.DeserializeObject <List <ImageInformation>> (super.getJsonContent());
    }

    public List<ImageInformation> getContent() {
        return content;
    }

    private void setContent(List<ImageInformation> value) {
        content = value;
    }

}
