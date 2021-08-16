package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
@JsonAutoDetect(fieldVisibility = Visibility.NON_PRIVATE)
public class DataMatrixBarcodeElement extends Dim2BarcodeElement {

    private boolean processTilde;
    private DataMatrixSymbolSize dataMatrixSymbolSize;
    private DataMatrixEncodingType dataMatrixEncodingType;
    private DataMatrixFunctionCharacter dataMatrixFunctionCharacter;

    public DataMatrixBarcodeElement(String value, ElementPlacement placement, float xOffset, float yOffset, DataMatrixSymbolSize symbolSize, DataMatrixEncodingType encodingType, DataMatrixFunctionCharacter functionCharacter) {
        super(value, placement, xOffset, yOffset);

        this.dataMatrixSymbolSize = symbolSize;
        this.dataMatrixEncodingType = encodingType;
        this.dataMatrixFunctionCharacter = functionCharacter;
    }

    public DataMatrixBarcodeElement(String value, ElementPlacement placement) {
        this(value, placement, 0, 0, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.NONE);
    }

    public DataMatrixBarcodeElement(byte[] value, ElementPlacement placement, float xOffset, float yOffset, DataMatrixSymbolSize symbolSize, DataMatrixEncodingType encodingType, DataMatrixFunctionCharacter functionCharacter) {
        super(value, placement, xOffset, yOffset);
        
        this.dataMatrixSymbolSize = symbolSize;
        this.dataMatrixEncodingType = encodingType;
        this.dataMatrixFunctionCharacter = functionCharacter;
    }

    public DataMatrixBarcodeElement(byte[] value, ElementPlacement placement) {
        this(value, placement, 0, 0, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.NONE);
    }

    @JsonProperty("type")
    ElementType getType() {
        return ElementType.DATAMATRIXBARCODE;
    }

    public boolean getProcessTilde() {
        return processTilde;
    }

    public void setProcessTilde(boolean value) {
        processTilde = value;
    }

    @JsonProperty("dataMatrixSymbolSize")
    DataMatrixSymbolSize getDataMatrixSymbolSize() {
        return dataMatrixSymbolSize;
    }

    void setDataMatrixSymbolSize(DataMatrixSymbolSize value) {
        dataMatrixSymbolSize = value;
    }

    @JsonProperty("dataMatrixEncodingType")
    DataMatrixEncodingType getDataMatrixEncodingType() {
        return dataMatrixEncodingType;
    }

    void setDataMatrixEncodingType(DataMatrixEncodingType value) {
        dataMatrixEncodingType = value;
    }

    @JsonProperty("dataMatrixFunctionCharacter")
    DataMatrixFunctionCharacter getDataMatrixFunctionCharacter() {
        return dataMatrixFunctionCharacter;
    }

    void setDataMatrixFunctionCharacter(DataMatrixFunctionCharacter value) {
        dataMatrixFunctionCharacter = value;
    }

}
