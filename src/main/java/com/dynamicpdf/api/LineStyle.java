package com.dynamicpdf.api;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;

public class LineStyle {

    private static DecimalFormatSymbols objFormatter = new DecimalFormatSymbols();
    private String lineStyleString;

    LineStyle(String lineStyle) {
        this.lineStyleString = lineStyle;
    }

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

    public LineStyle(float[] dashArray) {
        this(dashArray, 0);
    }

    public String getLineStyleString() {
        return lineStyleString;
    }

    void setLineStyleString(String value) {
        lineStyleString = value;
    }

    public static LineStyle getSolid() {
        return new LineStyle("solid");
    }

    public static LineStyle getDots() {
        return new LineStyle("dots");
    }

    public static LineStyle getDashSmall() {
        return new LineStyle("dashSmall");
    }

    public static LineStyle getDash() {
        return new LineStyle("dash");
    }

    public static LineStyle getDashLarge() {
        return new LineStyle("dashLarge");
    }

    public static LineStyle getNone() {
        return new LineStyle("none");
    }
}
