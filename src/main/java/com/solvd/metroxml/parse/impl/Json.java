package com.solvd.metroxml.parse.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.solvd.metroxml.Metro;
import com.solvd.metroxml.parse.CustomConverter;
import com.solvd.metroxml.parse.IPars;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

public class Json implements IPars {

    @Override
    public Metro parse(File file) throws IOException {
        Metro metro;

        String fileForRead;
        fileForRead = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        GsonBuilder builder = new GsonBuilder().registerTypeAdapter(LocalTime.class, new CustomConverter());
        Gson g = builder.create();
        metro = g.fromJson(fileForRead, Metro.class);

        return metro;
    }
}
