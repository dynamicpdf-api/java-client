package com.dynamicpdf.api;

public abstract class Security {

    private String userPassword = "";
    private String ownerPassword = "";
    private boolean allowCopy;
    private boolean allowEdit;
    private boolean allowPrint;
    private boolean allowUpdateAnnotsAndFields;
    private boolean allowAccessibility;
    private boolean allowFormFilling;
    private boolean allowHighResolutionPrinting;
    private boolean allowDocumentAssembly;

    Security() {
    }

    Security(String userPwd, String ownerPwd) {
        userPassword = userPwd;
        ownerPassword = ownerPwd;
    }

    abstract SecurityType getType();

    public boolean getAllowCopy() {
        return allowCopy;
    }

    public void setAllowCopy(boolean value) {
        allowCopy = value;
    }

    public boolean getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(boolean value) {
        allowEdit = value;
    }

    public boolean getAllowPrint() {
        return allowPrint;
    }

    public void setAllowPrint(boolean value) {
        allowPrint = value;
    }

    public boolean getAllowUpdateAnnotsAndFields() {
        return allowUpdateAnnotsAndFields;
    }

    public void setAllowUpdateAnnotsAndFields(boolean value) {
        allowUpdateAnnotsAndFields = value;
    }

    public String getOwnerPassword() {
        return ownerPassword;
    }

    public void setOwnerPassword(String value) {
        ownerPassword = value;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String value) {
        userPassword = value;
    }

    public boolean getAllowAccessibility() {
        return allowAccessibility;
    }

    public void setAllowAccessibility(boolean value) {
        allowAccessibility = value;
    }

    public boolean getAllowFormFilling() {
        return allowFormFilling;
    }

    public void setAllowFormFilling(boolean value) {
        allowFormFilling = value;
    }

    public boolean getAllowHighResolutionPrinting() {
        return allowHighResolutionPrinting;
    }

    public void setAllowHighResolutionPrinting(boolean value) {
        allowHighResolutionPrinting = value;
    }

    public boolean getAllowDocumentAssembly() {
        return allowDocumentAssembly;
    }

    public void setAllowDocumentAssembly(boolean value) {
        allowDocumentAssembly = value;
    }
}
