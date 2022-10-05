package com.solvd.metroxml.parse.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.metroxml.Metro;
import com.solvd.metroxml.parse.IPars;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonJSON implements IPars {

    private static final Logger LOGGER = LogManager.getLogger(JacksonJSON.class);

    @Override
    public Metro parse(File file) throws IOException {

        Metro metro;
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        metro = mapper.readValue(file, Metro.class);
        return metro;
    }
}
