package com.dynamicpdf.api;

import java.io.InputStream;

/**
 * Represents a pdf resource.
 */
public class PdfResource extends Resource {

	private ResourceType resourceType = ResourceType.PDF;

	/**
	 * Initializes a new instance of the <code>PdfResource</code> class.
	 * @param filePath The pdf file path.
	 * @param resourceName The name of the resource.
	 */
	public PdfResource(String filePath, String resourceName) {
		super(filePath, resourceName);
	}

	/**
	 * Initializes a new instance of the <code>PdfResource</code> class.
	 * @param filePath The pdf file path.
	 */
	public PdfResource(String filePath) {
		super(filePath, null);
	}

	/**
	 * Initializes a new instance of the <code>PdfResource</code> class.
	 * @param value The byte array of the pdf file.
	 * @param resourceName The name of the resource.
	 */
	public PdfResource(byte[] value, String resourceName) {
		super(value, resourceName);
	}

	/**
	 * Initializes a new instance of the <code>PdfResource</code> class.
	 * @param value The byte array of the pdf file.
	 */
	public PdfResource(byte[] value) {
		super(value, null);
	}

	/**
	 * Initializes a new instance of the <code>PdfResource</code> class.
	 * @param data The stream of the pdf file.
	 * @param resourceName The name of the resource.
	 */
	public PdfResource(InputStream data, String resourceName) {
		super(data, resourceName);
	}

	/**
	 * Initializes a new instance of the <code>PdfResource</code> class.
	 * @param data The stream of the pdf file.
	 */
	public PdfResource(InputStream data) {
		super(data, null);
	}    

	ResourceType getType() {
		return resourceType;
	}

	String getFileExtension() {
		return ".pdf";
	}

	String getMimeType() {
		return "application/pdf";
	}

}
