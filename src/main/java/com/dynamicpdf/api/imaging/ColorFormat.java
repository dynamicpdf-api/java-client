package com.dynamicpdf.api.imaging;

/**
 * Base class for all color formats
 */
public abstract class ColorFormat {

    private ColorFormatType type;

    /**
	 * Gets the color format type.
	 * @return The type of the color format.
	 */
	public ColorFormatType getType() {
		return type;
	}

	/**
	 * Sets the color format type.
	 * @param value Type of the color format
	 */
	public void setType(ColorFormatType value) {
		type = value;
	}
}
