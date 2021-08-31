
package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Represents AES 256 bit PDF document security.
 * <p> AES 256 bit PDF security is compatible with PDF version 1.5 and higher. 
 * This class is FIPS compliant when used in applications targetting .NET framework v3.5 or higher. 
 * Adobe Acrobat Reader version X or higher is needed to open these documents. </p>
 */

@JsonInclude(Include.NON_NULL)
public class Aes256Security extends Security{

	private EncryptDocumentComponents documentComponents;

	/**
	 * Initializes a new instance of the <code>Aes256Security</code> class by 
	 * taking the owner and user passwords as parameters to create PDF.
	 * @param ownerPassword The owner password to open the document.
	 * @param userPassword The user password to open the document.
	 */

	public Aes256Security(String userPassword, String ownerPassword){super(userPassword, ownerPassword); }

	@JsonProperty("type")
	SecurityType getType() { return SecurityType.AES256; }

	/**
	 * Gets or sets the <code>EncryptDocumentComponents</code>, components of the document to be encrypted. 
	 * We can encrypt all the PDF content or the content, excluding the metadata.
	 * @return The documents components to be encrypted.
	 */

	public EncryptDocumentComponents getDocumentComponents() { return documentComponents; }

	/**
	 * Sets or sets the <code>EncryptDocumentComponents</code>, components of the document to be encrypted. 
	 * We can encrypt all the PDF content or the content, excluding the metadata.
	 * @param value The documents components to be encrypted.
	 */
	public void setDocumentComponents(EncryptDocumentComponents value){
		documentComponents = value;
	}
}
