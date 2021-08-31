package com.dynamicpdf.api;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;

/**
 * Represents a style of line.
 */

public class LineStyle {

	private static DecimalFormatSymbols objFormatter = new DecimalFormatSymbols();
	private String lineStyleString;

	LineStyle(String lineStyle) {
		this.lineStyleString = lineStyle;
	}

	/**
	 * Initializes a new instance of the <code>LineStyle</code> class.
	 * @param dashArray The array specifying the line style.
	 * @param dashPhase The phase of the line style.
	 */

	public LineStyle(float[] dashArray, float dashPhase) {
		DecimalFormat objDF = new DecimalFormat("0.00", objFormatter);
		objDF.setDecimalSeparatorAlwaysShown(true);
		String strLineStyle = "[";
		StringBuffer strBuff;
		for (int i = 0; i < dashArray.length; i++) {
			float fltSegment = dashArray[i];
			if (i == dashArray.length - 1) {
				strBuff = objDF.format(fltSegment, new StringBuffer(), new FieldPosition(0));
				strLineStyle += strBuff.toString();
			} else {
				strBuff = objDF.format(fltSegment, new StringBuffer(), new FieldPosition(0));
				strLineStyle += strBuff.toString() + ",";
			}
		}
		strLineStyle += "]";
		if (dashPhase != 0) {
			strBuff = objDF.format(dashPhase, new StringBuffer(), new FieldPosition(0));
			strLineStyle += strBuff.toString();
		}
		this.lineStyleString = strLineStyle;
	}

	/**
	 * 
	 * @param dashArray The array specifying the line style.
	 */
	public LineStyle(float[] dashArray) {
		this(dashArray, 0);
	}
	/**
	 * 
	 * @return The array specifying the line style.
	 */
	public String getLineStyleString() {
		return lineStyleString;
	}

	void setLineStyleString(String value) {
		lineStyleString = value;
	}

	/**
	 * Gets a solid line.
	 * @return A solid line.
	 */
	public static LineStyle getSolid() {
		return new LineStyle("solid");
	}

	/**
	 * Gets a dotted line.
	 * @return A dotted line.
	 */
	public static LineStyle getDots() {
		return new LineStyle("dots");
	}

	/**
	 * Gets a line with small dashes.
	 * @return A line with small dashes.
	 */
	public static LineStyle getDashSmall() {
		return new LineStyle("dashSmall");
	}

	/**
	 * Gets a dashed line.
	 * @return A dashed line.
	 */
	public static LineStyle getDash() {
		return new LineStyle("dash");
	}

	/**
	 * Gets a line with large dashes. 
	 * @return A line with large dashes. 
	 */
	public static LineStyle getDashLarge() {
		return new LineStyle("dashLarge");
	}

	/**
	 * Gets a invisible line. 
	 * @return A invisible line. 
	 */
	public static LineStyle getNone() {
		return new LineStyle("none");
	}
}
