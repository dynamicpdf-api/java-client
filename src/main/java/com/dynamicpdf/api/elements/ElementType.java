package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ElementType {

	@JsonProperty("image")
    IMAGE,
    @JsonProperty("text")
    TEXT,
    @JsonProperty("pageNumbering")
    PAGENUMBERING,
    @JsonProperty("code128Barcode")
    CODE128BARCODE,
    @JsonProperty("code39Barcode")
    CODE39BARCODE,
    @JsonProperty("code25Barcode")
    CODE25BARCODE,
    @JsonProperty("code93Barcode")
    CODE93BARCODE,
    @JsonProperty("code11Barcode")
    CODE11BARCODE,
    @JsonProperty("gs1DataBarBarcode")
    GS1DATABARBARCODE,
    @JsonProperty("iata25Barcode")
    IATA25BARCODE,
    @JsonProperty("msiBarcode")
    MSIBARCODE,
    @JsonProperty("stackedGs1DataBarBarcode")
    STACKEDGS1DATABARBARCODE,
    @JsonProperty("aztecBarcode")
    AZTECBARCODE,
    @JsonProperty("qrCode")
    QRCODE,
    @JsonProperty("pdf417Barcode")
    PDF417BARCODE,
    @JsonProperty("dataMatrixBarcode")
    DATAMATRIXBARCODE,
    @JsonProperty("rectangle")
    RECTANGLE,
    @JsonProperty("line")
    LINE
}
