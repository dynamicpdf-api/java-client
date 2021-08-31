package com.dynamicpdf.api;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Represents the base class resource.
 */
public abstract class Resource {

	private String filePath;
	private byte[] data;
	private String resourceName;

	Resource() {
	}

	Resource(String filePath, String resourceName) {
		File file = new File(filePath);
		if (file.exists()) {
			this.data = Resource.getFileData(filePath);
			this.filePath = filePath;
		} else {
			throw new EndpointException("File does not exist.");
		}
		if (resourceName == null) {
			this.resourceName = UUID.randomUUID().toString() + this.getFileExtension();
		} else {
			this.resourceName = resourceName;
		}
	}

	Resource(byte[] value, String resourceName) {
		if (value.length > 0) {
			data = value;
		} else {
			throw new EndpointException("Byte array is empty.");
		}
		if (resourceName == null) {
			this.resourceName = UUID.randomUUID().toString() + getFileExtension();
		} else {
			this.resourceName = resourceName;
		}
	}

	Resource(InputStream steam, String resourceName) {
		if (steam != null) {
			data = Resource.getSteamData(steam);
		} else {
			throw new EndpointException("Stream is null.");
		}
		if (resourceName == null) {
			this.resourceName = UUID.randomUUID().toString() + getFileExtension();
		} else {
			this.resourceName = resourceName;
		}
	}

	String getFilePath() {
		return filePath;
	}

	void setFilePath(String value) {
		filePath = value;
	}

	byte[] getData() {
		return data;
	}

	void setData(byte[] value) {
		data = value;
	}

	abstract ResourceType getType();

	abstract String getFileExtension();

	String getMimeType() {
		return null;
	}

	void setMimeType(String value) {
	}

	/**
	 * Gets the resource name.
	 * @return The resource name.
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * Sets the resource name.
	 * @param value The resource name.
	 */
	public void setResourceName(String value) {
		resourceName = value;
	}

	static byte[] getSteamData(InputStream stream) {
		byte[] data = null;
		try {
			if (stream != null) {
				byte[] buffer = new byte[8192];
				int bytesRead;
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				while ((bytesRead = stream.read(buffer)) != -1) {
					output.write(buffer, 0, bytesRead);
				}
				data = output.toByteArray();
			}
		} catch (IOException ex) {
		}
		return data;
	}

	static byte[] getUTF8FileData(String filePath) {
		try {
			String content = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)
					.collect(Collectors.joining(System.lineSeparator()));
			return content.getBytes("UTF8");
		} catch (IOException ex) {
		}
		return null;
	}

	static byte[] getFileData(String filePath) {
		byte[] data = null;
		try {
			data = Files.readAllBytes(Paths.get(filePath));
		} catch (IOException ex) {
		}
		return data;
	}
}
