package com.dynamicpdf.api;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PdfSecurityInfoResponse extends JsonResponse {
    private PdfSecurityInfo content;

    public PdfSecurityInfoResponse() {
        super();
    }

    public PdfSecurityInfoResponse(String jsonContent) {
        super(jsonContent);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.content = objectMapper.readValue(super.getJsonContent(), PdfSecurityInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the pdf security information content.
     * 
     * @return The pdf security information content.
     */
    public PdfSecurityInfo getContent() {
        return content;
    }

    /**
     * Sets the pdf security information content.
     * 
     * @param value The pdf security information content.
     */
    private void setContent(PdfSecurityInfo value) {
        content = value;
    }
}
