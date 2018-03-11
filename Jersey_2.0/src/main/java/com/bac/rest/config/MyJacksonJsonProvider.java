package com.bac.rest.config;

import javax.ws.rs.ext.ContextResolver;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MyJacksonJsonProvider implements ContextResolver<ObjectMapper> {
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	static {
	      //MAPPER.setSerializationInclusion(Include.NON_EMPTY);
	      //MAPPER.disable(MapperFeature.USE_GETTERS_AS_SETTERS);
	      MAPPER.configure(SerializationFeature.INDENT_OUTPUT, true);
	      //MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	      //MAPPER.disable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
	    }

	public MyJacksonJsonProvider() {
        System.out.println("Instantiate MyJacksonJsonProvider");
    }
     
    @Override
    public ObjectMapper getContext(Class<?> type) {
        System.out.println("MyJacksonProvider.getContext() called with type: "+type);
        return MAPPER;
    } 

}
