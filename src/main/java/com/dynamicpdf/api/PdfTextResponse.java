package com.dynamicpdf.api;

import java.util.List;

public class PdfTextResponse extends JsonResponse {

    private List<PdfContent> content;

    public PdfTextResponse() {
        super();
    }

    public PdfTextResponse(String jsonContent) {
        super(jsonContent);
        //content = JsonConvert.DeserializeObject <List< PdfContent>> (super.getJsonContent());
    }

    public List<PdfContent> getContent() {
        return content;
    }

    private void setContent(List<PdfContent> value) {
        content = value;
    }

}
