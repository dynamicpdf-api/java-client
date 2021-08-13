package com.dynamicpdf.api;

import java.util.List;

public class FormFieldInformation {

    private List<SignatureFieldInformation> signatureFields;
    private List<TextFieldInformation> textFields;
    private List<ChoiceFieldInformation> choiceFields;
    private List<ButtonFieldInformation> buttonFields;
    private List<PushButtonInformation> pushButtons;
    private List<MultiSelectListBoxInformation> multiSelectListBoxFields;

    FormFieldInformation() {
    }

    public List<SignatureFieldInformation> getSignatureFields() {
        return signatureFields;
    }

    public void setSignatureFields(List<SignatureFieldInformation> value) {
        signatureFields = value;
    }

    public List<TextFieldInformation> getTextFields() {
        return textFields;
    }

    public void setTextFields(List<TextFieldInformation> value) {
        textFields = value;
    }

    public List<ChoiceFieldInformation> getChoiceFields() {
        return choiceFields;
    }

    public void setChoiceFields(List<ChoiceFieldInformation> value) {
        choiceFields = value;
    }

    public List<ButtonFieldInformation> getButtonFields() {
        return buttonFields;
    }

    public void setButtonFields(List<ButtonFieldInformation> value) {
        buttonFields = value;
    }

    public List<PushButtonInformation> getPushButtons() {
        return pushButtons;
    }

    public void setPushButtons(List<PushButtonInformation> value) {
        pushButtons = value;
    }

    public List<MultiSelectListBoxInformation> getMultiSelectListBoxFields() {
        return multiSelectListBoxFields;
    }

    public void setMultiSelectListBoxFields(List<MultiSelectListBoxInformation> value) {
        multiSelectListBoxFields = value;
    }
}
