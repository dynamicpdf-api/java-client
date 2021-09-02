package com.dynamicpdf.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents an outline.
 */

@JsonInclude(Include.NON_NULL)
public class Outline {

	private Color color;
	private String colorName;
	private String text;
	private OutlineStyle style;
	private boolean expanded;
	private OutlineList children;
	private Action action;
	private String fromInputID;

	/**
	 * Initializes a new instance of the <code>Outline</code> class.
	 * @param input The input of type <code>PdfInput</code> .
	 */

	Outline(PdfInput input) {
		fromInputID = input.getId();
		if (input.getMergeOptions() == null)
		{
			MergeOptions mergeOptions =new MergeOptions() ;
			mergeOptions.setOutlines(false);
			input.setMergeOptions(mergeOptions);
		}
		else 
		{
			input.getMergeOptions().setOutlines(false);
		}
	}

	/**
	 * Initializes a new instance of the <code>Outline</code> class.
	 * @param text text for the outline.
	 * @param action Action of the outline.
	 */

	Outline(String text, Action action) {
		this.text = text;
		this.action = action;
	}

	/**
	 * 
	 * @param text text for the outline.
	 */
	Outline(String text) {
		this(text, null);
	}

	@JsonProperty("color")
	String getColorName() {
		return colorName;
	}

	void setColorName(String value) {
		colorName = value;
	}

	/**
	 * Gets the text of the outline.
	 * @return The text of the outline.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text of the outline.
	 * @param value The text of the outline.
	 */
	public void setText(String value) {
		text = value;
	}

	/**
	 * Gets the style of the outline.
	 * @return The style of the outline.
	 */
	public OutlineStyle getStyle() {
		return style;
	}

	/**
	 * Sets the style of the outline.
	 * @param value The style of the outline.
	 */
	public void setStyle(OutlineStyle value) {
		style = value;
	}

	/**
	 * Gets a value specifying if the outline is expanded.
	 * @return A value specifying if the outline is expanded.
	 */
	public boolean getExpanded() {
		return expanded;
	}

	/**
	 * Sets a value specifying if the outline is expanded.
	 * @param value A value specifying if the outline is expanded.
	 */
	public void setExpanded(boolean value) {
		expanded = value;
	}

	/**
	 * Gets a collection of child outlines.
	 * @return A collection of child outlines.
	 */
	@JsonIgnore
	public OutlineList getChildren() {
		if (children == null)
            children = new OutlineList();
		return children;
	}

	/**
	 * Sets a collection of child outlines.
	 * @param value A collection of child outlines.
	 */
	public void setChildren(OutlineList value) {
		if (children == null)
			children = new OutlineList();
		children = value;
	}

	/**
	 * Gets the Action of the outline.
	 * @return The Action of the outline.
	 */
	@JsonProperty("linkTo")
	public Action getAction() {
		return action;
	}

	/**
	 * Sets the Action of the outline.
	 * @param value The Action of the outline.
	 */
	public void setAction(Action value) {
		action = value;
	}

	@JsonProperty()
	String getFromInputID() {
		return fromInputID;
	}

	void setFromInputID(String value) {
		fromInputID = value;
	}

	/**
	 * Gets the color of the outline.
	 * @return  The color of the outline.
	 */
	@JsonIgnore
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of the outline.
	 * @param value The color of the outline.
	 */
	public void setColor(Color value) {
		color = value;
		colorName = color.getColorString();
	}

	@JsonProperty("children")
	List<Outline> getInstructionChildren()
	{
		if (children != null)
			return children.getOutlines();
		return null;

	}

}
