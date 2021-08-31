package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents different options for merging PDF documents.
 */

@JsonInclude(Include.NON_DEFAULT)
public class MergeOptions {

	private boolean documentInfo = true;
	private boolean documentJavaScript = true;
	private boolean documentProperties = true;
	private boolean embeddedFiles = true;
	private boolean formFields = true;
	private boolean formsXfaData = true;
	private boolean logicalStructure = true;
	private boolean openAction = true;
	private boolean optionalContentInfo = true;
	private boolean outlines = true;
	private boolean outputIntent = true;
	private boolean pageAnnotations = true;
	private boolean pageLabelsAndSections = true;
	private String rootFormField = null;
	private boolean xmpMetadata = true;

	/**
	 * Gets a boolean indicating whether to import document information when merging.
	 * @return A boolean indicating whether to import document information when merging.
	 */
	public boolean getDocumentInfo() {
		return documentInfo;
	}

	/**
	 * Sets a boolean indicating whether to import document information when merging.
	 * @param value A boolean indicating whether to import document information when merging.
	 */
	public void setDocumentInfo(boolean value) {
		documentInfo = value;
	}

	/**
	 * Gets a boolean indicating whether to import document level JavaScript when merging.
	 * @return A boolean indicating whether to import document level JavaScript when merging.
	 */
	public boolean getDocumentJavaScript() {
		return documentJavaScript;
	}

	/**
	 * Sets a boolean indicating whether to import document level JavaScript when merging.
	 * @param value A boolean indicating whether to import document level JavaScript when merging.
	 */
	public void setDocumentJavaScript(boolean value) {
		documentJavaScript = value;
	}

	/**
	 * Gets a boolean indicating whether to import document properties when merging.
	 * @return A boolean indicating whether to import document properties when merging.
	 */
	public boolean getDocumentProperties() {
		return documentProperties;
	}

	/**
	 * Sets a boolean indicating whether to import document properties when merging.
	 * @param value A boolean indicating whether to import document properties when merging.
	 */
	public void setDocumentProperties(boolean value) {
		documentProperties = value;
	}

	/**
	 * Gets a boolean indicating whether to import embedded files when merging.
	 * @return A boolean indicating whether to import embedded files when merging.
	 */
	public boolean getEmbeddedFiles() {
		return embeddedFiles;
	}

	/**
	 * Sets a boolean indicating whether to import embedded files when merging.
	 * @param value A boolean indicating whether to import embedded files when merging.
	 */
	public void setEmbeddedFiles(boolean value) {
		embeddedFiles = value;
	}

	/**
	 * Gets a boolean indicating whether to import form fields when merging.
	 * @return A boolean indicating whether to import form fields when merging.
	 */
	public boolean getFormFields() {
		return formFields;
	}

	/**
	 * Sets a boolean indicating whether to import form fields when merging.
	 * @param value A boolean indicating whether to import form fields when merging.
	 */
	public void setFormFields(boolean value) {
		formFields = value;
	}

	/**
	 * Gets a boolean indicating whether to import XFA form data when merging.
	 * @return A boolean indicating whether to import XFA form data when merging.
	 */
	public boolean getFormsXfaData() {
		return formsXfaData;
	}

	/**
	 * Sets a boolean indicating whether to import XFA form data when merging.
	 * @param value A boolean indicating whether to import XFA form data when merging.
	 */
	public void setFormsXfaData(boolean value) {
		formsXfaData = value;
	}

	/**
	 * Gets a boolean indicating whether to import logical structure 
	 * (tagging information) when merging.
	 * @return A boolean indicating whether to import logical structure
	 */
	public boolean getLogicalStructure() {
		return logicalStructure;
	}

	/**
	 * Sets a boolean indicating whether to import logical structure 
	 * (tagging information) when merging.
	 * @param value A boolean indicating whether to import logical structure 
	 */
	public void setLogicalStructure(boolean value) {
		logicalStructure = value;
	}

	/**
	 * Gets a boolean indicating whether to import document's opening 
	 * action (initial page and zoom settings) when merging.
	 * @return A boolean indicating whether to import document's opening 
	 */
	public boolean getOpenAction() {
		return openAction;
	}

	/**
	 * Sets a boolean indicating whether to import document's opening 
	 * action (initial page and zoom settings) when merging.
	 * @param value A boolean indicating whether to import document's opening 
	 */
	public void setOpenAction(boolean value) {
		openAction = value;
	}

	/**
	 * Gets a boolean indicating whether to import optional content when merging.
	 * @return A boolean indicating whether to import optional content when merging.
	 */
	public boolean getOptionalContentInfo() {
		return optionalContentInfo;
	}

	/**
	 * Sets a boolean indicating whether to import optional content when merging.
	 * @param value A boolean indicating whether to import optional content when merging.
	 */
	public void setOptionalContentInfo(boolean value) {
		optionalContentInfo = value;
	}

	/**
	 * Gets a boolean indicating whether to import outlines and bookmarks when merging.
	 * @return A boolean indicating whether to import outlines and bookmarks when merging.
	 */
	public boolean getOutlines() {
		return outlines;
	}

	/**
	 * Sets a boolean indicating whether to import outlines and bookmarks when merging.
	 * @param value A boolean indicating whether to import outlines and bookmarks when merging.
	 */
	public void setOutlines(boolean value) {
		outlines = value;
	}

	/**
	 * Gets a boolean indicating whether to import OutputIntent when merging.
	 * @return A boolean indicating whether to import OutputIntent when merging.
	 */
	public boolean getOutputIntent() {
		return outputIntent;
	}

	/**
	 * Sets a boolean indicating whether to import OutputIntent when merging.
	 * @param value A boolean indicating whether to import OutputIntent when merging.
	 */
	public void setOutputIntent(boolean value) {
		outputIntent = value;
	}

	/**
	 * Gets a boolean indicating whether to import PageAnnotations when merging.
	 * @return A boolean indicating whether to import PageAnnotations when merging.
	 */
	public boolean getPageAnnotations() {
		return pageAnnotations;
	}

	/**
	 * Sets a boolean indicating whether to import PageAnnotations when merging.
	 * @param value A boolean indicating whether to import PageAnnotations when merging.
	 */
	public void setPageAnnotations(boolean value) {
		pageAnnotations = value;
	}

	/**
	 * Gets a boolean indicating whether to import PageLabelsAndSections when merging.
	 * @return A boolean indicating whether to import PageLabelsAndSections when merging.
	 */
	public boolean getPageLabelsAndSections() {
		return pageLabelsAndSections;
	}

	/**
	 * Sets a boolean indicating whether to import PageLabelsAndSections when merging.
	 * @param value A boolean indicating whether to import PageLabelsAndSections when merging.
	 */
	public void setPageLabelsAndSections(boolean value) {
		pageLabelsAndSections = value;
	}

	/**
	 * Gets the root form field for imported form fields. 
	 * Useful when merging a PDF repeatedly to have a better 
	 * contorl on the form field names.
	 * @return The root form field for imported form fields. 
	 */
	public String getRootFormField() {
		return rootFormField;
	}

	/**
	 * Gets the root form field for imported form fields. 
	 * Useful when merging a PDF repeatedly to have a better 
	 * contorl on the form field names.
	 * @param value The root form field for imported form fields. 
	 */
	public void setRootFormField(String value) {
		rootFormField = value;
	}

	/**
	 * Gets a boolean indicating whether to import XmpMetadata when merging.
	 * @return A boolean indicating whether to import XmpMetadata when merging.
	 */
	public boolean getXmpMetadata() {
		return xmpMetadata;
	}

	/**
	 * Sets a boolean indicating whether to import XmpMetadata when merging.
	 * @param value A boolean indicating whether to import XmpMetadata when merging.
	 */
	public void setXmpMetadata(boolean value) {
		xmpMetadata = value;
	}
}
