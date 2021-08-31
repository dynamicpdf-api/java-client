package com.dynamicpdf.api.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the symbol size of a Datamatrix barcode.
 */
public enum DataMatrixSymbolSize {

	/**
	 * Calculates symbol size based on the value.
	 */
	@JsonProperty("auto")
	AUTO,

	/**
	 * 10 rows by 10 columns.
	 */
	@JsonProperty("r10xC10")
	R10XC10,

	/**
	 * 12 rows by 12 columns.
	 */
	@JsonProperty("r12xC12")
	R12XC12,

	/**
	 * 14 rows by 14 columns.
	 */
	@JsonProperty("r14xC14")
	R14XC14,

	/**
	 * 16 rows by 16 columns.
	 */
	@JsonProperty("r16xC16")
	R16XC16,

	/**
	 * 18 rows by 18 columns.
	 */
	@JsonProperty("r18xC18")
	R18XC18,

	/**
	 * 20 rows by 20 columns.
	 */
	@JsonProperty("r20xC20")
	R20XC20,

	/**
	 * 22 rows by 22 columns.
	 */
	@JsonProperty("r22xC22")
	R22XC22,

	/**
	 * 24 rows by 24 columns.
	 */
	@JsonProperty("r24xC24")
	R24XC24,

	/**
	 * 26 rows by 26 columns.
	 */
	@JsonProperty("r26xC26")
	R26XC26,

	/**
	 * 32 rows by 32 columns.
	 */
	@JsonProperty("r32xC32")
	R32XC32,

	/**
	 * 36 rows by 36 columns.
	 */
	@JsonProperty("r36xC36")
	R36XC36,

	/**
	 * 40 rows by 40 columns.
	 */
	@JsonProperty("r40xC40")
	R40XC40,

	/**
	 * 44 rows by 44 columns.
	 */
	@JsonProperty("r44xC44")
	R44XC44,

	/**
	 * 48 rows by 48 columns.
	 */
	@JsonProperty("r48xC48")
	R48XC48,

	/**
	 * 52 rows by 52 columns.
	 */
	@JsonProperty("r52xC52")
	R52XC52,

	/**
	 * 64 rows by 64 columns.
	 */
	@JsonProperty("r52xC52")
	R64XC64,

	/**
	 * 72 rows by 72 columns.
	 */
	@JsonProperty("r72xC72")
	R72XC72,

	/**
	 * 80 rows by 80 columns.
	 */
	@JsonProperty("r80xC80")
	R80XC80,

	/**
	 * 88 rows by 88 columns.
	 */
	@JsonProperty("r88xC88")
	R88XC88,

	/**
	 * 96 rows by 96 columns.
	 */
	@JsonProperty("r96xC96")
	R96XC96,

	/**
	 * 104 rows by 104 columns.
	 */
	@JsonProperty("r104xC104")
	R104XC104,

	/**
	 * 120 rows by 120 columns.
	 */
	@JsonProperty("r120xC120")
	R120XC120,

	/**
	 * 132 rows by 132 columns.
	 */
	@JsonProperty("r132xC132")
	R132XC132,

	/**
	 * 144 rows by 144 columns.
	 */
	@JsonProperty("r144xC144")
	R144XC144,

	/**
	 * 8 rows by 18 columns.
	 */
	@JsonProperty("r8xC18")
	R8XC18,

	/**
	 * 8 rows by 32 columns.
	 */
	@JsonProperty("r8xC32")
	R8XC32,

	/**
	 * 12 rows by 26 columns.
	 */
	@JsonProperty("r12xC26")
	R12XC26,

	/**
	 * 12 rows by 36 columns.
	 */
	@JsonProperty("r12xC36")
	R12XC36,

	/**
	 * 16 rows by 36 columns.
	 */
	@JsonProperty("r16xC36")
	R16XC36,

	/**
	 * 16 rows by 48 columns.
	 */
	@JsonProperty("r16xC48")
	R16XC48
}
