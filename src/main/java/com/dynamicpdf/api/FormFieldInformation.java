package com.dynamicpdf.api;

import java.util.List;

/**
 * Represents the form field information containing the collection 
 * of different types of field informations.
 */

public class FormFieldInformation {

	private List<SignatureFieldInformation> signatureFields;
	private List<TextFieldInformation> textFields;
	private List<ChoiceFieldInformation> choiceFields;
	private List<ButtonFieldInformation> buttonFields;
	private List<PushButtonInformation> pushButtons;
	private List<MultiSelectListBoxInformation> multiSelectListBoxFields;

	FormFieldInformation() {
	}

	/**
	 * Gets a collection of <code>SignatureFieldInformation</code>.
	 * @return A collection of <code>SignatureFieldInformation</code>.
	 */
	public List<SignatureFieldInformation> getSignatureFields() {
		return signatureFields;
	}

	/**
	 * Sets a collection of <code>SignatureFieldInformation</code>.
	 * @param value A collection of <code>SignatureFieldInformation</code>.
	 */
	public void setSignatureFields(List<SignatureFieldInformation> value) {
		signatureFields = value;
	}

	/**
	 * Gets a collection of <code>TextFieldInformation</code>.
	 * @return A collection of <code>TextFieldInformation</code>.
	 */
	public List<TextFieldInformation> getTextFields() {
		return textFields;
	}

	/**
	 * Sets a collection of <code>TextFieldInformation</code>.
	 * @param value A collection of <code>TextFieldInformation</code>.
	 */
	public void setTextFields(List<TextFieldInformation> value) {
		textFields = value;
	}

	/**
	 * Gets a collection of <code>ChoiceFieldInformation</code>.
	 * @return A collection of <code>ChoiceFieldInformation</code>.
	 */
	public List<ChoiceFieldInformation> getChoiceFields() {
		return choiceFields;
	}

	/**
	 * Sets a collection of <code>ChoiceFieldInformation</code>.
	 * @param value A collection of <code>ChoiceFieldInformation</code>.
	 */
	public void setChoiceFields(List<ChoiceFieldInformation> value) {
		choiceFields = value;
	}

	/**
	 * Gets a collection of <code>ButtonFieldInformation</code>.
	 * @return A collection of <code>ButtonFieldInformation</code>.
	 */
	public List<ButtonFieldInformation> getButtonFields() {
		return buttonFields;
	}

	/**
	 * Gets a collection of <code>ButtonFieldInformation</code>.
	 * @param value A collection of <code>ButtonFieldInformation</code>.
	 */
	public void setButtonFields(List<ButtonFieldInformation> value) {
		buttonFields = value;
	}

	/**
	 * Gets a collection of <code>PushButtonInformation</code>.
	 * @return A collection of <code>PushButtonInformation</code>.
	 */
	public List<PushButtonInformation> getPushButtons() {
		return pushButtons;
	}

	/**
	 * Sets a collection of <code>PushButtonInformation</code>.
	 * @param value A collection of <code>PushButtonInformation</code>.
	 */
	public void setPushButtons(List<PushButtonInformation> value) {
		pushButtons = value;
	}

	/**
	 * Gets a collection of <code>MultiSelectListBoxInformation</code>.
	 * @return A collection of <code>MultiSelectListBoxInformation</code>.
	 */
	public List<MultiSelectListBoxInformation> getMultiSelectListBoxFields() {
		return multiSelectListBoxFields;
	}

	/**
	 * Sets a collection of <code>MultiSelectListBoxInformation</code>.
	 * @param value A collection of <code>MultiSelectListBoxInformation</code>.
	 */
	public void setMultiSelectListBoxFields(List<MultiSelectListBoxInformation> value) {
		multiSelectListBoxFields = value;
	}
}
