package com.dynamicpdf.api;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class FloatJsonSerializer extends JsonSerializer<Float>{

	@Override
	public void serialize(Float value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeNumber(Float.toString(value).replaceAll("\\.?0*$", ""));
	}

}
