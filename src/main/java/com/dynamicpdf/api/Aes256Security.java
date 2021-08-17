package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Aes256Security extends Security{
    
    private EncryptDocumentComponents documentComponents;
    
    public Aes256Security(String userPassword, String ownerPassword){super(userPassword, ownerPassword); }

    @JsonProperty("type")
    SecurityType getType() { return SecurityType.AES256; }

    public EncryptDocumentComponents getDocumentComponents() { return documentComponents; }
    
    public void setDocumentComponents(EncryptDocumentComponents value){
        documentComponents = value;
    }
}
