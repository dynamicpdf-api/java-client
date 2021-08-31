package com.dynamicpdf.api;

class FontInformation {

	private String fontName;
	private String filePath;

	FontInformation(String fontName, String filePath) {
		this.fontName = fontName;
		this.filePath = filePath;
	}

	String getFontName() {
		return this.fontName;
	}

	String getFilePath() {
		return this.filePath;
	}
}
