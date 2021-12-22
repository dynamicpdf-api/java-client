package com.dynamicpdf.api.elements;

import com.dynamicpdf.api.Color;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.Resource;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents a page numbering label page element.
 * 
 * <p>This class can be used to add page numbering to a PDF document. The following tokens can be used within the
 * text of a PageNumberingLabel. They will be replaced with the appropriate value when the PDF is output.<br><br>
 * 
 * <table style="border-collapse:collapse; border-spacing:0;" border="1">
 * <caption>The following table shows how to use the tokens</caption>
 * <tr class='TableRowColor'><th class='TableHeadingColor'>Token</th><th class='TableHeadingColor'>Description</th></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>CP</b></td><td>Current page. The default numbering style is numeric.</td></tr>

 * <tr class='TableRowColor'><td style="text-align:center"><b>TP</b></td><td>Total pages. The default numbering style is numeric.</td></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>SP</b></td><td>Section page.</td></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>ST</b></td><td>Section Total.</td></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>PR</b></td><td>Prefix.</td></tr>
 * </table>
 *
 * <br>All tokens except the %%PR%% token can also contain a numbering style specifier. The numbering style specifier
 * is placed in parenthesis after the token.<br><br>
 *
 * <table style="border-collapse:collapse; border-spacing:0;" border="1">
 * <caption>The following table shows the Numbering Styles</caption>
 * <tr class='TableRowColor'><th class='TableHeadingColor'>Numbering Style</th><th class='TableHeadingColor'>Description</th></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>1</b></td><td>Numeric. Arabic numbers are used: 1, 2, 3, etc. Example: "%%CP(1)%%"</td></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>i</b></td><td>Lower Case Roman Numerals. Lower case roman numerals are used: i, ii, iii, etc.
 * Example: "%%CP(i)%%".</td></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>I</b></td><td>Upper Case Roman Numerals. Upper case roman numerals are used: I, II, III, etc.
 * Example: "%%CP(I)%%".</td></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>a</b></td><td>Lower Latin Letters. Lower case Latin letters are used: a, b, c, etc. After z, aa is used
 * followed by bb, cc, ect. Example: "%%CP(a)%%".</td></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>A</b></td><td>Upper Latin Letters. Upper case Latin letters are used: A, B, C, etc. After Z, AA is used
 * followed by BB, CC, ect. Example: "%%CP(A)%%".</td></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>b</b></td><td>Lower Latin Letters. Lower case Latin letters are used: a, b, c, etc. After z, aa is used
 * followed by ab, ac, ect. Example: "%%CP(b)%%".</td></tr>
 *
 * <tr class='TableRowColor'><td style="text-align:center"><b>B</b></td><td>Lower Latin Letters. Lower case Latin letters are used: A, B, C, etc. After Z, AA is used
 * followed by AB, AC, ect. Example: "%%CP(B)%%".</td></tr>
 * </table>
 * <p>There should be no spaces within a token, only the token and optional numbering style specifier. This 
 * token is <b>invalid</b> %%CP ( i )%% because of the extra spaces.</p> Here are some examples of valid tokens: 
 * <ul style="margin-top: 0px;">
 * <li>%%SP%%</li>
 * <li>%%SP(I)%%</li>
 * <li>%%PR%%</li>
 * <li>%%ST(B)%%</li>
 * </ul>
 */
@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class PageNumberingElement extends Element {

	private Color color;
	private Font font;
	private Resource resource;
	private String fontName;
	private String colorName;
	private float fontSize;

	/**
	 * Initializes a new instance of the <code>PageNumberingElement</code> class.
	 * 
	 * @param text Text to display in the label.
	 * @param placement The placement of the page numbering element on the page.
	 * @param xOffset X coordinate of the label.
	 * @param yOffset Y coordinate of the label.
	 */
	public PageNumberingElement(String text, ElementPlacement placement, float xOffset, float yOffset) {
		super(text, placement, xOffset, yOffset);
	}

	/**
	 * Initializes a new instance of the <code>PageNumberingElement</code> class.
	 * 
	 * @param text Text to display in the label.
	 * @param placement The placement of the page numbering element on the page.
	 */
	public PageNumberingElement(String text, ElementPlacement placement) {
		this(text, placement, 0, 0);
	}

	@JsonProperty("type")
	ElementType getType() {
		return ElementType.PAGENUMBERING;
	}

    /**
    * <p><b>This method is meant for DynamicPDF's internal usage and not supposed to be used by the client programs.</b></p>
    */
	@JsonIgnore
	public Resource getResource() {
		return resource;
	}

	void setResource(Resource value) {
		resource = value;
	}

    /**
    * <p><b>This method is meant for DynamicPDF's internal usage and not supposed to be used by the client programs.</b></p>
    */
	@JsonIgnore
	public Font getTextFont() {
		return font;
	}

	@JsonProperty("font")
	String getFontName() {
		return fontName;
	}

	void setFontName(String value) {
		fontName = value;
	}

	@JsonProperty("color")
	String getColorName() {
		return colorName;
	}

	void setColorName(String value) {
		colorName = value;
	}

	/**
	 * Gets the <code>Color</code> object to use for the text of the label
	 * @return The <code>Color</code> object to use for the text of the label
	 */
	@JsonIgnore
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the <code>Color</code> object to use for the text of the label
	 * @param value The <code>Color</code> object to use for the text of the label
	 */
	public void setColor(Color value) {
		color = value;
		colorName = value.getColorString();
	}

	/**
	 * Gets the <code>Font</code> object to use for the text of the label.
	 * @return The <code>Font</code> object to use for the text of the label.
	 */
	@JsonIgnore
	public Font getFont() {
		return font;
	}

	/**
	 * Sets the <code>Font</code> object to use for the text of the label.
	 * @param value The <code>Font</code> object to use for the text of the label.
	 */
	public void setFont(Font value) {
		font = value;
		fontName = font.getName();
		resource = font.getResource();
	}

	/**
	 * Gets the font size for the text of the label.
	 * @return The font size for the text of the label.
	 */
	public float getFontSize() {
		return fontSize;
	}

	/**
	 * Sets the font size for the text of the label.
	 * @param value The font size for the text of the label.
	 */
	public void setFontSize(float value) {
		fontSize = value;
	}

	/**
	 * Gets the text to display in the label.
	 * @return The text to display in the label.
	 */
	public String getText() {
		return getInputValue();
	}

	/**
	 * Sets the text to display in the label.
	 * @param value The text to display in the label.
	 */
	public void setText(String value) {
		setInputValue(value);
	}

}
