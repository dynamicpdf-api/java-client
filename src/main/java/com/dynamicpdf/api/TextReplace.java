package com.dynamicpdf.api;

/**
 * Represents the find and replace values and its options.
 */
public class TextReplace {
	String text;
	String replaceText;
	boolean matchCase = false;

	/**
	 * Creates new instance of text replace.
	 * @param text Text to find.
	 * @param replaceText Text to replace.
	 * @param matchCase True value will make the search operation case sensitive.
	 */
	public TextReplace(String text, String replaceText, boolean matchCase) {
		this.text = text;
		this.replaceText = replaceText;
		this.matchCase = matchCase;
	}
        
	/**
	 * Creates new instance of text replace.
	 * @param text Text to find.
	 * @param replaceText Text to replace.
	 */
	public TextReplace(String text, String replaceText) {
		this.text = text;
		this.replaceText = replaceText;
	}

	/**
	 * Gets the find text value. This string will be replaced with <code>ReplaceText</code> during conversion.
	 * @return The find text value.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the find text value. This string will be replaced with <code>ReplaceText</code> during conversion.
	 * @param value The find text value.
	 */
	public void setText(String value) {
		text = value;
	}

	/**
	 * Gets the replace text value. This string will replace the <code>Text</code> during conversion
	 * @return The replace text value.
	 */
	public String getReplaceText() {
		return replaceText;
	}

	/**
	 * Sets the replace text value. This string will replace the <code>Text</code> during conversion
	 * @param value The replace text value.
	 */
	public void setReplaceText(String value) {
		replaceText = value;
	}

	/**
	 * Gets the match case value. If true, the search operation will be case sensitive.
	 * @return The match case value.
	 */
	public boolean getMatchCase() {
		return matchCase;
	}

	/**
	 * Sets the match case value. If true, the search operation will be case sensitive.
	 * @param value The match case value.
	 */
	public void setMatchCase(boolean value) {
		matchCase = value;
	}
}
