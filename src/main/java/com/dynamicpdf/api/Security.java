package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Base class from which all security classes are derived.
 */
@JsonInclude(Include.NON_NULL)
public abstract class Security {

	private String userPassword = "";
	private String ownerPassword = "";
	private boolean allowCopy = true;
	private boolean allowEdit = true;
	private boolean allowPrint = true;
	private boolean allowUpdateAnnotsAndFields = true;
	private boolean allowAccessibility = true;
	private boolean allowFormFilling;
	private boolean allowHighResolutionPrinting = true;
	private boolean allowDocumentAssembly;

	Security() {
	}

	Security(String userPwd, String ownerPwd) {
		userPassword = userPwd;
		ownerPassword = ownerPwd;
	}

	@JsonProperty("type")
	abstract SecurityType getType();

	/**
	 * Gets if text and images can be copied to the clipboard by the user.
	 * @return If text and images can be copied to the clipboard by the user.
	 */
	public boolean getAllowCopy() {
		return allowCopy;
	}

	/**
	 * Sets if text and images can be copied to the clipboard by the user.
	 * @param value If text and images can be copied to the clipboard by the user.
	 */
	public void setAllowCopy(boolean value) {
		allowCopy = value;
	}

	/**
	 * Gets if the document can be edited by the user.
	 * @return If the document can be edited by the user.
	 */
	public boolean getAllowEdit() {
		return allowEdit;
	}

	/**
	 * Sets if the document can be edited by the user.
	 * @param value If the document can be edited by the user.
	 */
	public void setAllowEdit(boolean value) {
		allowEdit = value;
	}

	/**
	 * Gets if the document can be printed by the user.
	 * @return If the document can be printed by the user.
	 */
	public boolean getAllowPrint() {
		return allowPrint;
	}

	/**
	 * Sets if the document can be printed by the user.
	 * @param value If the document can be printed by the user.
	 */
	public void setAllowPrint(boolean value) {
		allowPrint = value;
	}

	/**
	 * Gets if annotations and form fields can be added, edited
	 * and modified by the user.
	 * @return If annotations and form fields can be added, edited
	 */
	public boolean getAllowUpdateAnnotsAndFields() {
		return allowUpdateAnnotsAndFields;
	}

	/**
	 * Sets if annotations and form fields can be added, edited
	 * and modified by the user.
	 * @param value If annotations and form fields can be added, edited
	 */
	public void setAllowUpdateAnnotsAndFields(boolean value) {
		allowUpdateAnnotsAndFields = value;
	}

	/**
	 * Gets the owner password.
	 * @return The owner password.
	 */
	public String getOwnerPassword() {
		return ownerPassword;
	}

	/**
	 * Sets the owner password.
	 * @param value The owner password.
	 */
	public void setOwnerPassword(String value) {
		ownerPassword = value;
	}

	/**
	 * Gets the user password.
	 * @return The user password.
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * Sets the user password.
	 * @param value The user password.
	 */
	public void setUserPassword(String value) {
		userPassword = value;
	}

	/**
	 * Gets if accessibility programs should be able to read
	 * the documents text and images for the user.
	 * @return If accessibility programs should be able to read
	 */
	public boolean getAllowAccessibility() {
		return allowAccessibility;
	}

	/**
	 * Sets if accessibility programs should be able to read
	 * the documents text and images for the user.
	 * @param value If accessibility programs should be able to read
	 */
	public void setAllowAccessibility(boolean value) {
		allowAccessibility = value;
	}

	/**
	 * Gets if form filling should be allowed by the user.
	 * @return If form filling should be allowed by the user.
	 */
	public boolean getAllowFormFilling() {
		return allowFormFilling;
	}

	/**
	 * Sets if form filling should be allowed by the user.
	 * @param value If form filling should be allowed by the user.
	 */
	public void setAllowFormFilling(boolean value) {
		allowFormFilling = value;
	}

	/**
	 * Gets if the document can be printed at a high resolution by the user.
	 * @return If the document can be printed at a high resolution by the user.
	 */
	public boolean getAllowHighResolutionPrinting() {
		return allowHighResolutionPrinting;
	}

	/**
	 * Sets if the document can be printed at a high resolution by the user.
	 * @param value If the document can be printed at a high resolution by the user.
	 */
	public void setAllowHighResolutionPrinting(boolean value) {
		allowHighResolutionPrinting = value;
	}

	/**
	 * Gets if the document can be assembled and manipulated by the user.
	 * @return If the document can be assembled and manipulated by the user.
	 */
	public boolean getAllowDocumentAssembly() {
		return allowDocumentAssembly;
	}

	/**
	 * Sets if the document can be assembled and manipulated by the user.
	 * @param value If the document can be assembled and manipulated by the user.
	 */
	public void setAllowDocumentAssembly(boolean value) {
		allowDocumentAssembly = value;
	}
}
