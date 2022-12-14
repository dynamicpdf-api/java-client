package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents different types of the page size.
 */
public enum PageSize {

	/**
	 * Page Size of A3.
	 */
	@JsonProperty("a3")
    A3,

    /**
	 * Page Size of A4.
	 */
	@JsonProperty("a4")
    A4,

    /**
	 * Page Size of A5.
	 */
	@JsonProperty("a5")
    A5,

    /**
	 * Page Size of A6.
	 */
	@JsonProperty("a6")
    A6,

    /**
	 * Page Size of B3.
	 */
	@JsonProperty("b3")
    B3,

    /**
	 * Page Size of B4.
	 */
	@JsonProperty("b4")
    B4,

    /**
	 * Page Size of B5.
	 */
	@JsonProperty("b5")
    B5,

    /**
	 * Page Size of B5JIS.
	 */
	@JsonProperty("b5jis")
    B5JIS,

    /**
	 * Page Size of DoublePostcard.
	 */
	@JsonProperty("doublePostcard")
    DOUBLEPOSTCARD,

    /**
	 * Page Size of Envelope10.
	 */
	@JsonProperty("envelope10")
    ENVELOPE10,

    /**
	 * Page Size of EnvelopeDL.
	 */
	@JsonProperty("envelopeDL")
	ENVELOPEDL,

    /**
	 * Page Size of EnvelopeC5.
	 */
	@JsonProperty("envelopeC5")
	ENVELOPEC5,

    /**
	 * Page Size of EnvelopeB5.
	 */
	@JsonProperty("envelopeB5")
	ENVELOPEB5,

    /**
	 * Page Size of EnvelopeMonarch.
	 */
	@JsonProperty("envelopeMonarch")
	ENVELOPEMONARCH,

    /**
	 * Page Size of Executive.
	 */
	@JsonProperty("executive")
    EXECUTIVE,

    /**
	 * Page Size of Legal.
	 */
	@JsonProperty("legal")
    LEGAL,

    /**
	 * Page Size of Folio.
	 */
	@JsonProperty("folio")
    FOLIO,

    /**
	 * Page Size of Letter.
	 */
	@JsonProperty("letter")
    LETTER,

    /**
	 * Page Size of Postcard.
	 */
	@JsonProperty("postcard")
	POSTCARD,

    /**
	 * Page Size of PRC16K.
	 */
	@JsonProperty("prc16k")
    PRC16K,

    /**
	 * Page Size of PRC32K.
	 */
	@JsonProperty("prc32k")
    PRC32K,

    /**
	 * Page Size of Quatro.
	 */
	@JsonProperty("quatro")
    QUATRO,

    /**
	 * Page Size of Statement.
	 */
	@JsonProperty("statement")
    STATEMENT,

    /**
	 * Page Size of Tabloid.
	 */
	@JsonProperty("tabloid")
    TABLOID
}
