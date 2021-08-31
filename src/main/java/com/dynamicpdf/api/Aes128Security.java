package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

/**
 * Represents AES 128 bit PDF document security.
 * AES 128 bit PDF security is compatible with PDF version 1.5 and higher and, 
 * Adobe Acrobat Reader version 7 or higher is needed to open these documents. 
 * Older readers will not be able to read documents encrypted with this security.
 */
public class Aes128Security extends Security {

	private EncryptDocumentComponents documentComponents;

	/**
	 * Initializes a new instance of the <code>Aes128Security</code> class by 
	 * taking the owner and user passwords as parameters to create PDF.
	 * @param ownerPassword The owner password to open the document.
	 * @param userPassword The user password to open the document.
	 */

	public Aes128Security(String userPassword, String ownerPassword) {
		super(userPassword, ownerPassword);
	}

	@JsonProperty("type")
	SecurityType getType() {
		return SecurityType.AES128;
	}

	/**
	 * Gets the <code>EncryptDocumentComponents</code>, components of the document to be encrypted. 
	 * We can encrypt all the PDF content or the content, excluding the metadata.
	 * @return The documents components to be encrypted.
	 */

	public EncryptDocumentComponents getDocumentComponents() {
		return documentComponents;
	}

	/**
	 * Sets the <code>EncryptDocumentComponents</code>, components of the document to be encrypted. 
	 * We can encrypt all the PDF content or the content, excluding the metadata.
	 * @param value The documents components to be encrypted.
	 */

	public void setDocumentComponents(EncryptDocumentComponents value) {
		documentComponents = value;
	}
}
