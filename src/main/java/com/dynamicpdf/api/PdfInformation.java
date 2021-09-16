package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

/**
 * Represents the pdf inforamtion.
 */
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

	/**
	 * Represents the pdf inforamtion.
	 */
	PdfInformation() {
	}

	/**
	 * Gets the author.
	 * @return The author.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 * @param value The author.
	 */
	public void setAuthor(String value) {
		author = value;
	}

	/**
	 * Gets the subject.
	 * @return The subject.
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 * @param value The subject.
	 */
	public void setSubject(String value) {
		subject = value;
	}

	/**
	 * Gets the keywords.
	 * @return The keywords.
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * Sets the keywords.
	 * @param value The keywords.
	 */
	public void setKeywords(String value) {
		keywords = value;
	}

	/**
	 * Gets the creator.
	 * @return The creator.
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * Sets the creator.
	 * @param value The creator.
	 */
	public void setCreator(String value) {
		creator = value;
	}

	/**
	 * Gets the producer.
	 * @return The producer.
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * Sets the producer.
	 * @param value The producer.
	 */
	public void setProducer(String value) {
		producer = value;
	}

	/**
	 * Gets the title.
	 * @return The title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * @param value The title.
	 */
	public void setTitle(String value) {
		title = value;
	}

	/**
	 * Gets the collection of PageInformation.
	 * @return The collection of PageInformation.
	 */
	public List<PageInformation> getPages() {
		return pages;
	}

	/**
	 * Sets the collection of PageInformation.
	 * @param value The collection of PageInformation.
	 */
	public void setPages(List<PageInformation> value) {
		pages = value;
	}

	/**
	 * Gets the form fields.
	 * @return The form fields.
	 */
	public FormFieldInformation getFormFields() {
		return formFields;
	}

	/**
	 * Sets the form fields.
	 * @param value The form fields.
	 */
	public void setFormFields(FormFieldInformation value) {
		formFields = value;
	}

	/**
	 * Gets the custom properties.
	 * @return The custom properties.
	 */
	public Dictionary<String, String> getCustomProperties() {
		return customProperties;
	}

	/**
	 * Sets the custom properties.
	 * @param value The collection of keys and values of customProperties
	 */
	public void setCustomProperties(Dictionary<String, String> value) {
		customProperties = value;
	}

	/**
	 * Gets the boolean representing xmp meta data.
	 * @return The boolean representing xmp meta data.
	 */
	public boolean getXmpMetaData() {
		return xmpMetaData;
	}

	/**
	 * Sets the boolean representing xmp meta data.
	 * @param value The boolean representing xmp meta data.
	 */
	public void setXmpMetaData(boolean value) {
		xmpMetaData = value;
	}

	/**
	 * Gets the boolean, indicating whether the pdf is signed.
	 * @return The boolean, indicating whether the pdf is signed.
	 */
	public boolean getSigned() {
		return signed;
	}

	/**
	 * Sets the boolean, indicating whether the pdf is signed.
	 * @param value The boolean, indicating whether the pdf is signed.
	 */
	public void setSigned(boolean value) {
		signed = value;
	}

	/**
	 * Gets the boolean, indicating whether the pdf is tagged.
	 * @return  The boolean, indicating whether the pdf is tagged.
	 */
	public boolean getTagged() {
		return tagged;
	}

	/**
	 * Sets the boolean, indicating whether the pdf is tagged.
	 * @param value The boolean, indicating whether the pdf is tagged.
	 */
	public void setTagged(boolean value) {
		tagged = value;
	}
}
