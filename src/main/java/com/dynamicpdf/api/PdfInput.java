package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class PdfInput extends Input {

    private MergeOptions mergeOptions = null;
    private int startPage;
    private int pageCount;

    public PdfInput(PdfResource resource, MergeOptions options) {
        super(resource);
        mergeOptions = options;
    }

    public PdfInput(PdfResource resource) {
        super(resource);
    }

    public PdfInput(String cloudResourcePath, MergeOptions options) {
        super(cloudResourcePath);
        mergeOptions = options;
    }

    public PdfInput(String cloudResourcePath) {
        super(cloudResourcePath);
    }

    @JsonProperty("type")
    InputType getType() {
        return InputType.PDF;
    }

    public MergeOptions getMergeOptions() {
        return mergeOptions;
    }

    public void setMergeOptions(MergeOptions value) {
        mergeOptions = value;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setSatrtPage(int value) {
        startPage = value;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int value) {
        pageCount = value;
    }
}
