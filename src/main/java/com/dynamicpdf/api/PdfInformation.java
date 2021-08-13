package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class PdfInformation {

    private String author;
    private String subject;
    private String keywords;
    private String creator;
    private String producer;
    private String title;

    private List<PageInformation> pages = new ArrayList<PageInformation>();
    private FormFieldInformation formFields;
    private Dictionary<String, String> customProperties;
    private boolean xmpMetaData;
    private boolean signed;
    private boolean tagged;

    PdfInformation() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String value) {
        author = value;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String value) {
        subject = value;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String value) {
        keywords = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String value) {
        creator = value;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String value) {
        producer = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        title = value;
    }

    public List<PageInformation> getPages() {
        return pages;
    }

    public void setPages(List<PageInformation> value) {
        pages = value;
    }

    public FormFieldInformation getFormFields() {
        return formFields;
    }

    public void setFormFields(FormFieldInformation value) {
        formFields = value;
    }

    public Dictionary<String, String> getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(Dictionary<String, String> value) {
        customProperties = value;
    }

    public boolean getXmpMetaData() {
        return xmpMetaData;
    }

    public void setXmpMetaData(boolean value) {
        xmpMetaData = value;
    }

    public boolean getSigned() {
        return signed;
    }

    public void setSigned(boolean value) {
        signed = value;
    }

    public boolean getTagged() {
        return tagged;
    }

    public void setTagged(boolean value) {
        tagged = value;
    }
}
