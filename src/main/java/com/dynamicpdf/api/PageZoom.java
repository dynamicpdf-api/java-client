package com.dynamicpdf.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PageZoom {

	@JsonProperty("retain")
    RETAIN,
    @JsonProperty("fitPage")
    FITPAGE,
    @JsonProperty("fitWidth")
    FITWIDTH,
    @JsonProperty("fitHeight")
    FITHEIGHT,
    @JsonProperty("fitBox")
    FITBOX
}
