package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the pdf security info endpoint.
 */
public class PdfSecurityInfo {

    private Boolean allowEdit;
    private Boolean allowPrint;
    private Boolean allowUpdateAnnotsAndFields;
    private Boolean allowCopy;
    private Boolean allowHighResolutionPrinting;
    private Boolean allowDocumentAssembly;
    private Boolean allowFormFilling;
    private Boolean allowAccessibility;
    private Boolean encryptAllExceptMetadata;
    private Boolean encryptOnlyFileAttachments;

    @JsonProperty("hasUserPassword")
    private boolean hasUserPassword;

    @JsonProperty("hasOwnerPassword")
    private boolean hasOwnerPassword;

    /**
     * Represents the pdf security info endpoint.
     */
    @JsonProperty("encryptionType")
    private String EncryptionTypeString;

    /*
     * Gets the encryption type
     */
    public String getEncryptionTypeString() {
        return EncryptionTypeString;
    }

    /*
     * Sets the encryption type
     */
    public void setEncryptionTypeString(String encryptionType) {
        this.EncryptionTypeString = encryptionType;
    }

    @JsonIgnore
    public EncryptionType getEncryptionType() {
        switch (EncryptionTypeString) {
            case "rc4-40":
                return EncryptionType.RC440;
            case "rc4-128":
                return EncryptionType.RC4128;
            case "aes-128-cbc":
                return EncryptionType.AES128CBC;
            case "aes-256-cbc":
                return EncryptionType.AES256CBC;
            default:
                return EncryptionType.None;
        }
    }

    /**
     * Gets if the document can be edited by the user.
     * 
     * @return If the document can be edited by the user.
     */
    public Boolean getAllowEdit() {
        return allowEdit;
    }

    /**
     * Sets if the document can be edited by the user.
     * 
     * @param value If the document can be edited by the user.
     */
    public void setAllowEdit(Boolean value) {
        allowEdit = value;
    }

    /**
     * Gets if the document can be printed by the user.
     * 
     * @return If the document can be printed by the user.
     */
    public Boolean getAllowPrint() {
        return allowPrint;
    }

    /**
     * Sets if the document can be printed by the user.
     * 
     * @param value If the document can be printed by the user.
     */
    public void setAllowPrint(Boolean value) {
        allowPrint = value;
    }

    /**
     * Gets if annotations and form fields can be added, edited
     * and modified by the user.
     * 
     * @return If annotations and form fields can be added, edited
     */
    public Boolean getAllowUpdateAnnotsAndFields() {
        return allowUpdateAnnotsAndFields;
    }

    /**
     * Sets if annotations and form fields can be added, edited
     * and modified by the user.
     * 
     * @param value If annotations and form fields can be added, edited
     */
    public void setAllowUpdateAnnotsAndFields(Boolean value) {
        allowUpdateAnnotsAndFields = value;
    }

    /**
     * Gets if text and images can be copied to the clipboard by the user.
     * 
     * @return If text and images can be copied to the clipboard by the user.
     */
    public Boolean getAllowCopy() {
        return allowCopy;
    }

    /**
     * Sets if text and images can be copied to the clipboard by the user.
     * 
     * @param value If text and images can be copied to the clipboard by the user.
     */
    public void setAllowCopy(Boolean value) {
        allowCopy = value;
    }

    /**
     * Gets if the document can be printed at a high resolution by the user.
     * 
     * @return If the document can be printed at a high resolution by the user.
     */
    public Boolean getAllowHighResolutionPrinting() {
        return allowHighResolutionPrinting;
    }

    /**
     * Sets if the document can be printed at a high resolution by the user.
     * 
     * @param value If the document can be printed at a high resolution by the user.
     */
    public void setAllowHighResolutionPrinting(Boolean value) {
        allowHighResolutionPrinting = value;
    }

    /**
     * Gets if the document can be assembled and manipulated by the user.
     * 
     * @return If the document can be assembled and manipulated by the user.
     */
    public Boolean getAllowDocumentAssembly() {
        return allowDocumentAssembly;
    }

    /**
     * Sets if the document can be assembled and manipulated by the user.
     * 
     * @param value If the document can be assembled and manipulated by the user.
     */
    public void setAllowDocumentAssembly(Boolean value) {
        allowDocumentAssembly = value;
    }

    /**
     * Gets if form filling should be allowed by the user.
     * 
     * @return If form filling should be allowed by the user.
     */
    public Boolean getAllowFormFilling() {
        return allowFormFilling;
    }

    /**
     * Sets if form filling should be allowed by the user.
     * 
     * @param value If form filling should be allowed by the user.
     */
    public void setAllowFormFilling(Boolean value) {
        allowFormFilling = value;
    }

    /**
     * Gets if accessibility programs should be able to read
     * the documents text and images for the user.
     * 
     * @return If accessibility programs should be able to read
     */
    public Boolean getAllowAccessibility() {
        return allowAccessibility;
    }

    /**
     * Sets if accessibility programs should be able to read
     * the documents text and images for the user.
     * 
     * @param value If accessibility programs should be able to read
     */
    public void setAllowAccessibility(Boolean value) {
        allowAccessibility = value;
    }

    /**
     * Gets a value indicating whether all data should be encrypted except for
     * metadata.
     * 
     * @return Value indicating whether all data should be encrypted
     */
    public Boolean getEncryptAllExceptMetadata() {
        return encryptAllExceptMetadata;
    }

    /**
     * Sets a value indicating whether all data should be encrypted except for
     * metadata.
     * 
     * @param value Indicating whether all data should be encrypted
     */
    public void setEncryptAllExceptMetadata(Boolean value) {
        encryptAllExceptMetadata = value;
    }

    /**
     * Gets a value indicating whether only file attachments should be encrypted.
     * 
     * @return Value indicating whether only file attachments should be encrypted
     */
    public Boolean getEncryptOnlyFileAttachments() {
        return encryptOnlyFileAttachments;
    }

    /**
     * Sets a value indicating whether only file attachments should be encrypted.
     * 
     * @param value Indicating whether only file attachments should be encrypted.
     */
    public void setEncryptOnlyFileAttachments(Boolean value) {
        encryptOnlyFileAttachments = value;
    }

    /**
     * Gets a value indicating whether the PDF document has an owner password set.
     * 
     * @return The owner password.
     */
    public boolean getOwnerPassword() {
        return hasOwnerPassword;
    }

    /**
     * Sets a value indicating whether the PDF document has an owner password set.
     * 
     * @param value The owner password.
     */
    public void setOwnerPassword(boolean value) {
        hasOwnerPassword = value;
    }

    /**
     * Gets a value indicating whether the PDF document has an user password set.
     * 
     * @return The user password.
     */
    public boolean getUserPassword() {
        return hasUserPassword;
    }

    /**
     * Sets a value indicating whether the PDF document has an user password set.
     * 
     * @param value The user password.
     */
    public void setUserPassword(boolean value) {
        hasUserPassword = value;
    }

}
