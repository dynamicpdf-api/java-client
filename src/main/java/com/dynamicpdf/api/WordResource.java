package com.dynamicpdf.api;

import java.io.File;
import java.io.InputStream;

/**
 * Represents a Word resource.
 */
public class WordResource extends Resource {
	private ResourceType type = ResourceType.WORD;
	private String mimeType;

	/**
	 * Initializes a new instance of the <code>WordResource</code> class.
	 * @param filePath The Word file path.
	 */
	public WordResource(String filePath) {
		this(filePath, null);
	}

	/**
	 * Initializes a new instance of the <code>WordResource</code> class.
	 * @param filePath The Word file path.
	 * @param resourceName The resource name with file extension.
	 */
	public WordResource(String filePath, String resourceName) {
		super(filePath, resourceName);
		
		if ((resourceName == null || resourceName.isBlank()) == false) {
			setMimeType();
		} else if (resourceName != null) {
			throw new EndpointException("Unsupported file type or invalid file extension.");
		}
	}
	
	/**
	 * Initializes a new instance of the <code>WordResource</code> class.
	 * @param value The byte array of the Word file.
	 * @param resourceName The resource name with file extension.
	 */
	public WordResource(byte[] value, String resourceName) {
		super(value, resourceName);

		if ((resourceName == null || resourceName.isBlank()) == false) {
			setMimeType();
		} else if (resourceName != null) {
			throw new EndpointException("Unsupported file type or invalid file extension.");
		}
	}

	/**
	 * Initializes a new instance of the <code>WordResource</code> class.
	 * @param data The stream of the Word file.
	 * @param resourceName The resource name with file extension.
	 */
	public WordResource(InputStream data, String resourceName) {
		super(data, resourceName);

		if ((resourceName == null || resourceName.isBlank()) == false) {
			setMimeType();
		} else if (resourceName != null) {
			throw new EndpointException("Unsupported file type or invalid file extension.");
		}
	}
	
	/**
	 * Sets the resource name.
	 * @param value The resource name.
	 * <p>The resource name should be specified with a file extension.</p>
	 */
	public void setResourceName(String value) {
		if ((value == null || value.isBlank()) == true
				|| (value.contains(".") && value.length() > value.lastIndexOf('.') + 1) == false) {
			throw new EndpointException("Invalid resource name.");
		}

		super.setResourceName(value);
		setMimeType();
	}

	ResourceType getType() {
		return type;
	}

	void setMimeType(String value) {
		mimeType = value;
	}

	String getMimeType() {
		return mimeType;
	}

	String getFileExtension() {

		String inputFileExtension = "";
		
		if ((getResourceName() == null || getResourceName().isBlank()) == false) {
			if ((getResourceName().contains(".")
					&& getResourceName().trim().length() > getResourceName().lastIndexOf('.') + 1) == true) {
				inputFileExtension = getResourceName().substring(getResourceName().lastIndexOf('.')).toLowerCase();
			} else {
				throw new EndpointException("Invalid resource name.");
			}
		} else if ((getFilePath() == null || getFilePath().isBlank()) == false) {
			String fileName = new File(getFilePath()).getName();
			if ((fileName.contains(".") && fileName.trim().length() > fileName.lastIndexOf('.') + 1) == true) {
				inputFileExtension = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
			} else {
				throw new EndpointException("Invalid file path specified.");
			}
		} else {
			throw new EndpointException("Invalid file path or resource name.");
		}
		
		if (inputFileExtension.equals(".doc")) {
			mimeType = "application/msword";
			return ".doc";
		} else if (inputFileExtension.equals(".docx") && getData()[0] == 0x50 && getData()[1] == 0x4b) {
			mimeType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
			return ".docx";
		} else if (inputFileExtension.equals(".odt") && getData()[0] == 0x50 && getData()[1] == 0x4b) {
			mimeType = "application/vnd.oasis.opendocument.text";
			return ".odt";
		} else {
			throw new EndpointException("Unsupported file type or invalid file extension.");
		}
	}
	
	private void setMimeType() {
		getFileExtension();
	}
}
