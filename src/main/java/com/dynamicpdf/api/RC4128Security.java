package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents RC4 128 bit PDF document security.
 * <p>RC4 128 bit PDF security, with UseCryptFilter property set to false is compatible with PDF version 1.4 or higher and can be read
 * with Adobe Acrobat Reader version 5 or higher. By default UseCryptFilter property is false. RC4 128 bit PDF security with crypt filter 
 * is compatible with PDF version 1.5 or higher and can be read with Adobe Acrobat Reader version 6 and higher. 
 * Older readers will not be able to read document encrypted with this security.</p>
 */
@JsonInclude(Include.NON_NULL)
public class RC4128Security extends Security {

	private boolean encryptMetadata = true;

	/**
	 * Initializes a new instance of the <code>RC4128Security</code> class.
	 * @param userPassword The owner password to open the document.
	 * @param ownerPassword The user password to open the document.
	 */
	public RC4128Security(String userPassword, String ownerPassword) {
		super(userPassword, ownerPassword);
	}

	SecurityType getType() {
		return SecurityType.RC4128;
	}

	/**
	 * Gets the documents components to be encrypted.
	 * @return The documents components to be encrypted.
	 */
	public boolean getEncryptMetadata() {
		return encryptMetadata;
	}

	/**
	 * Sets the documents components to be encrypted.
	 * @param value The documents components to be encrypted.
	 */
	public void setEncryptMetadata(boolean value) {
		encryptMetadata = value;
	}
}
