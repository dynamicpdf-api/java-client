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

    static double[] getPaperSize(PageSize size){
    	double[] paperSize = new double[2];
    	
        switch (size)
        {
            case LETTER:
            	paperSize[0] = inchesToPoints(8.5f); paperSize[1] = inchesToPoints(11f); break;
            case LEGAL:
            	paperSize[0] = inchesToPoints(8.5f); paperSize[1] = inchesToPoints(14f); break;
            case EXECUTIVE:
            	paperSize[0] = inchesToPoints(7.25f); paperSize[1] = inchesToPoints(10.5f); break;
            case TABLOID:
            	paperSize[0] = inchesToPoints(11f); paperSize[1] = inchesToPoints(17f); break;
            case ENVELOPE10:
            	paperSize[0] = inchesToPoints(4.125f); paperSize[1] = inchesToPoints(9.5f); break;
            case ENVELOPEMONARCH:
            	paperSize[0] = inchesToPoints(3.875f); paperSize[1] = inchesToPoints(7.5f); break;
            case FOLIO:
            	paperSize[0] = inchesToPoints(8.5f); paperSize[1] = inchesToPoints(13f); break;
            case STATEMENT:
            	paperSize[0] = inchesToPoints(5.5f); paperSize[1] = inchesToPoints(8.5f); break;
            case A4:
            	paperSize[0] = millimetersToPoints(210f); paperSize[1] = millimetersToPoints(297f); break;
            case A5:
            	paperSize[0] = millimetersToPoints(148f); paperSize[1] = millimetersToPoints(210f); break;
            case B4:
            	paperSize[0] = millimetersToPoints(250f); paperSize[1] = millimetersToPoints(353f); break;
            case B5:
            	paperSize[0] = millimetersToPoints(176f); paperSize[1] = millimetersToPoints(250f); break;
            case A3:
            	paperSize[0] = millimetersToPoints(297f); paperSize[1] = millimetersToPoints(420f); break;
            case B3:
            	paperSize[0] = millimetersToPoints(353f); paperSize[1] = millimetersToPoints(500f); break;
            case A6:
            	paperSize[0] = millimetersToPoints(105f); paperSize[1] = millimetersToPoints(148f); break;
            case B5JIS:
            	paperSize[0] = millimetersToPoints(182f); paperSize[1] = millimetersToPoints(257f); break;
            case ENVELOPEDL:
            	paperSize[0] = millimetersToPoints(110f); paperSize[1] = millimetersToPoints(220f); break;
            case ENVELOPEC5:
            	paperSize[0] = millimetersToPoints(162f); paperSize[1] = millimetersToPoints(229f); break;
            case ENVELOPEB5:
            	paperSize[0] = millimetersToPoints(176f); paperSize[1] = millimetersToPoints(250f); break;
            case PRC16K:
            	paperSize[0] = millimetersToPoints(146f); paperSize[1] = millimetersToPoints(215f); break;
            case PRC32K:
            	paperSize[0] = millimetersToPoints(97f); paperSize[1] = millimetersToPoints(151f); break;
            case QUATRO:
            	paperSize[0] = millimetersToPoints(215f); paperSize[1] = millimetersToPoints(275f); break;
            case DOUBLEPOSTCARD:
            	paperSize[0] = millimetersToPoints(148.0f); paperSize[1] = millimetersToPoints(200.0f); break;
            case POSTCARD:
            	paperSize[0] = inchesToPoints(3.94f); paperSize[1] = inchesToPoints(5.83f); break;
            default:
            	paperSize[0] = inchesToPoints(8.5f); paperSize[1] = inchesToPoints(11f); break;
        }
      
        return paperSize;
    }
}
