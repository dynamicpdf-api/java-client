package com.dynamicpdf.api;

/**
 * Represents the find and replace values and its options.
 */
public class TextReplace {
	String text;
	String replaceText;
	boolean matchCase = false;

	/**
	 * Represents the find and replace values and its options.
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
	 * Represents the find and replace values and its options.
	 * @param text Text to find.
	 * @param replaceText Text to replace.
	 */
	public TextReplace(String text, String replaceText) {
		this.text = text;
		this.replaceText = replaceText;
	}

	/**
	 * Gets the Find Text value. This string will be replaced with <code>ReplaceText</code> during conversion.
	 * @return The Find Text value.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the Find Text value. This string will be replaced with <code>ReplaceText</code> during conversion.
	 * @param value The Find Text value.
	 */
	public void setText(String value) {
		text = value;
	}

	/**
	 * Gets the ReplaceText value. This string will replace the <code>Text</code> during conversion
	 * @return The ReplaceText value.
	 */
	public String getReplaceText() {
		return replaceText;
	}

	/**
	 * Sets the ReplaceText value. This string will replace the <code>Text</code> during conversion
	 * @param value The ReplaceText value.
	 */
	public void setReplaceText(String value) {
		replaceText = value;
	}

	/**
	 * Gets the MatchCase value. If True, the search operation will be case sensitive.
	 * @return The MatchCase value.
	 */
	public boolean getMatchCase() {
		return matchCase;
	}

	/**
	 * Sets the MatchCase value. If True, the search operation will be case sensitive.
	 * @param value The MatchCase value.
	 */
	public void setMatchCase(boolean value) {
		matchCase = value;
	}
}
