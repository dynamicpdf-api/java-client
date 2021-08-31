package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
class PdfInstructions {

	private List<FormField> formFields = null;
	private List<Template> templates = null;
	private List<Font> fonts = null;
	private List<Outline> outlines = null;

	private String author = "CeteSoftware";
	private String title;
	private String subject;
	private String creator = "DynmaicPDF Cloud Api";
	private String keywords;
	private Security security = null;
	private boolean flattenAllFormFields;
	private boolean retainSignatureFormFields;
	private List<Input> inputs = new ArrayList<Input>();

	PdfInstructions(){    	
	}

	List<Template> getTemplates() {
		if (templates == null) {
			templates = new ArrayList<Template>();
		}
		return templates;
	}

	List<Font> getFonts() {
		if (fonts == null) {
			fonts = new ArrayList<Font>();
		}
		return fonts;
	}

	String getAuthor() {
		return author;
	}

	void setAuthor(String value) {
		author = value;
	}

	String getTitle() {
		return title;
	}

	void setTitle(String value) {
		title = value;
	}

	String getSubject() {
		return subject;
	}

	void setSubject(String value) {
		subject = value;
	}

	String getCreator() {
		return creator;
	}

	void setCreator(String value) {
		creator = value;
	}

	String getKeywords() {
		return keywords;
	}

	void setKeywords(String value) {
		keywords = value;
	}

	Security getSecurity() {
		return security;
	}

	void setSecurity(Security value) {
		security = value;
	}

	boolean getFlattenAllFormFields() {
		return flattenAllFormFields;
	}

	void setFlattenAllFormFields(boolean value) {
		flattenAllFormFields = value;
	}

	boolean getRetainSignatureFormFields() {
		return retainSignatureFormFields;
	}

	void setRetainSignatureFormFields(boolean value) {
		retainSignatureFormFields = value;
	}

	List<Input> getInputs() {
		return inputs;
	}

	void setInputs(List<Input> value) {
		inputs = value;
	}

	List<FormField> getFormFields() {
		if (formFields == null) {
			formFields = new ArrayList<FormField>();
		}
		return formFields;
	}

	List<Outline> getOutlines() {
		if (outlines == null) {
			outlines = new ArrayList<Outline>();
		}
		return outlines;
	}

}
