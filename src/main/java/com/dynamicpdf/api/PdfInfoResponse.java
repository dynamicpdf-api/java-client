package com.dynamicpdf.api;

public class PdfInfoResponse extends JsonResponse {

    private PdfInformation content;

    public PdfInfoResponse() {
        super();
    }

    public PdfInfoResponse(String jsonContent) {
        super(jsonContent);
        //content = JsonConvert.DeserializeObject <PdfInformation> (super.getJsonContent());
    }

    public PdfInformation getContent() {
        return content;
    }

    private void setContent(PdfInformation value) {
        content = value;
    }

}
