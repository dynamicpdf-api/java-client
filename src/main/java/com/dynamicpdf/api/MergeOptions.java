package com.dynamicpdf.api;

public class MergeOptions {

    private boolean documentInfo;
    private boolean documentJavaScript;
    private boolean documentProperties;
    private boolean embeddedFiles;
    private boolean formFields;
    private boolean formsXfaData;
    private boolean logicalStructure;
    private boolean openAction;
    private boolean optionalContentInfo;
    private boolean outlines;
    private boolean outputIntent;
    private boolean pageAnnotations;
    private boolean pageLabelsAndSections;
    private String rootFormField = null;
    private boolean xmpMetadata;

    public boolean getDocumentInfo() {
        return documentInfo;
    }

    public void setDocumentInfo(boolean value) {
        documentInfo = value;
    }

    public boolean getDocumentJavaScript() {
        return documentJavaScript;
    }

    public void setDocumentJavaScript(boolean value) {
        documentJavaScript = value;
    }

    public boolean getDocumentProperties() {
        return documentProperties;
    }

    public void setDocumentProperties(boolean value) {
        documentProperties = value;
    }

    public boolean getEmbeddedFiles() {
        return embeddedFiles;
    }

    public void setEmbeddedFiles(boolean value) {
        embeddedFiles = value;
    }

    public boolean getFormFields() {
        return formFields;
    }

    public void setFormFields(boolean value) {
        formFields = value;
    }

    public boolean getFormsXfaData() {
        return formsXfaData;
    }

    public void setFormsXfaData(boolean value) {
        formsXfaData = value;
    }

    public boolean getLogicalStructure() {
        return logicalStructure;
    }

    public void setLogicalStructure(boolean value) {
        logicalStructure = value;
    }

    public boolean getOpenAction() {
        return openAction;
    }

    public void setOpenAction(boolean value) {
        openAction = value;
    }

    public boolean getOptionalContentInfo() {
        return optionalContentInfo;
    }

    public void setOptionalContentInfo(boolean value) {
        optionalContentInfo = value;
    }

    public boolean getOutlines() {
        return outlines;
    }

    public void setOutlines(boolean value) {
        outlines = value;
    }

    public boolean getOutputIntent() {
        return outputIntent;
    }

    public void setOutputIntent(boolean value) {
        outputIntent = value;
    }

    public boolean getPageAnnotations() {
        return pageAnnotations;
    }

    public void setPageAnnotations(boolean value) {
        pageAnnotations = value;
    }

    public boolean getPageLabelsAndSections() {
        return pageLabelsAndSections;
    }

    public void setPageLabelsAndSections(boolean value) {
        pageLabelsAndSections = value;
    }

    public String getRootFormField() {
        return rootFormField;
    }

    public void setRootFormField(String value) {
        rootFormField = value;
    }

    public boolean getXmpMetadata() {
        return xmpMetadata;
    }

    public void setXmpMetadata(boolean value) {
        xmpMetadata = value;
    }
}
