package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
class PdfInstructions {

	private List<FormField> formFields = null;
	private HashSet<Template> templates = null;
	private HashSet<Font> fonts = null;
	private OutlineList outlines = null;

	private String author;
	private String title;
	private String subject;
	private String creator;
	private String producer;
	private boolean tag;
	private String keywords;
	private Security security = null;
	
	@JsonInclude(Include.NON_DEFAULT)
	private boolean flattenAllFormFields;
	
	@JsonInclude(Include.NON_DEFAULT)
	private boolean retainSignatureFormFields;
	private List<Input> inputs = new ArrayList<Input>();

	PdfInstructions(){    	
	}

	HashSet<Template> getTemplates() {
		if (templates == null) {
			templates = new HashSet<Template>();
		}
		return templates;
	}

	HashSet<Font> getFonts() {
		if (fonts == null) {
			fonts = new HashSet<Font>();
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

	String getProducer() {
		return producer;
	}

	void setProducer(String value) {
		producer = value;
	}

	boolean getTag() {
		return tag;
	}

	void setTag(boolean value) {
		tag = value;
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

	@JsonIgnore
	OutlineList getOutlines()
    {
        if (outlines == null)
            outlines = new OutlineList();
        return outlines;
        
    }
	
	@JsonProperty("outlines")
	List<Outline> getInstructionsOutlines() {
		if (outlines != null) {
			return outlines.getOutlines();
		}
		return null;
	}

}
