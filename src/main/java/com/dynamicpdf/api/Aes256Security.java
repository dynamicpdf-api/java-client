package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Aes256Security extends Security{
    
    private EncryptDocumentComponents documentComponents;
    
    public Aes256Security(String userPassword, String ownerPassword){super(userPassword, ownerPassword); }

    @JsonProperty("type")
    SecurityType getType() { return SecurityType.Aes256; }

    public EncryptDocumentComponents getDocumentComponents() { return documentComponents; }
    
    public void setDocumentComponents(EncryptDocumentComponents value){
        documentComponents = value;
    }
}
