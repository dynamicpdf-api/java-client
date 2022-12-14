package com.dynamicpdf.api;

class UnitConverter {

	/**
	 * Method to convert inches to points.
	 * @param size Size in points.
	 */
    public static double inchesToPoints(double size){
        return size * 72.0;
    }

    /**
	 * Method to convert millimeters to points.
	 * @param size Size in points.
	 */
    public static double millimetersToPoints(double size){
        return size * 2.8346456692913385826771653543307;
    }

    static void getPaperSize(PageSize size, double smaller, double larger){
        switch (size)
        {
            case LETTER:
                smaller = inchesToPoints(8.5f); larger = inchesToPoints(11f); break;
            case LEGAL:
                smaller = inchesToPoints(8.5f); larger = inchesToPoints(14f); break;
            case EXECUTIVE:
                smaller = inchesToPoints(7.25f); larger = inchesToPoints(10.5f); break;
            case TABLOID:
                smaller = inchesToPoints(11f); larger = inchesToPoints(17f); break;
            case ENVELOPE10:
                smaller = inchesToPoints(4.125f); larger = inchesToPoints(9.5f); break;
            case ENVELOPEMONARCH:
                smaller = inchesToPoints(3.875f); larger = inchesToPoints(7.5f); break;
            case FOLIO:
                smaller = inchesToPoints(8.5f); larger = inchesToPoints(13f); break;
            case STATEMENT:
                smaller = inchesToPoints(5.5f); larger = inchesToPoints(8.5f); break;
            case A4:
                smaller = millimetersToPoints(210f); larger = millimetersToPoints(297f); break;
            case A5:
                smaller = millimetersToPoints(148f); larger = millimetersToPoints(210f); break;
            case B4:
                smaller = millimetersToPoints(250f); larger = millimetersToPoints(353f); break;
            case B5:
                smaller = millimetersToPoints(176f); larger = millimetersToPoints(250f); break;
            case A3:
                smaller = millimetersToPoints(297f); larger = millimetersToPoints(420f); break;
            case B3:
                smaller = millimetersToPoints(353f); larger = millimetersToPoints(500f); break;
            case A6:
                smaller = millimetersToPoints(105f); larger = millimetersToPoints(148f); break;
            case B5JIS:
                smaller = millimetersToPoints(182f); larger = millimetersToPoints(257f); break;
            case ENVELOPEDL:
                smaller = millimetersToPoints(110f); larger = millimetersToPoints(220f); break;
            case ENVELOPEC5:
                smaller = millimetersToPoints(162f); larger = millimetersToPoints(229f); break;
            case ENVELOPEB5:
                smaller = millimetersToPoints(176f); larger = millimetersToPoints(250f); break;
            case PRC16K:
                smaller = millimetersToPoints(146f); larger = millimetersToPoints(215f); break;
            case PRC32K:
                smaller = millimetersToPoints(97f); larger = millimetersToPoints(151f); break;
            case QUATRO:
                smaller = millimetersToPoints(215f); larger = millimetersToPoints(275f); break;
            case DOUBLEPOSTCARD:
                smaller = millimetersToPoints(148.0f); larger = millimetersToPoints(200.0f); break;
            case POSTCARD:
                smaller = inchesToPoints(3.94f); larger = inchesToPoints(5.83f); break;
            default:
                smaller = inchesToPoints(8.5f); larger = inchesToPoints(11f); break;
        }
    }
}
