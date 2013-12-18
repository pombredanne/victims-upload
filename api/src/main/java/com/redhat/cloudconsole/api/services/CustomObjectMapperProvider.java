package com.redhat.cloudconsole.api.services;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Provider
public class CustomObjectMapperProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper objectMapper;

    public CustomObjectMapperProvider() {
        objectMapper = new ObjectMapper();
        /* Register JodaModule to handle Joda DateTime Objects. */
        objectMapper.registerModule(new JodaModule());
        /* We want dates to be treated as ISO8601 not timestamps. */
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public ObjectMapper getContext(Class<?> arg0) {
        return objectMapper;
    }
}

