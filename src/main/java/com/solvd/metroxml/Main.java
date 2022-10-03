package com.solvd.metroxml;

import com.solvd.metroxml.parse.IPars;
import com.solvd.metroxml.parse.impl.Json;
import com.solvd.metroxml.parse.impl.Parse;
import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {

        IPars iPars = new Parse();
        File XMLfile = new File("D:/Java/metro-xml/src/main/resources/metroJaxB.xml");
        Metro metro1 = iPars.parse(XMLfile);

        File JSONfile = new File("D:/Java/metro-xml/src/main/resources/metroJson.json");
        IPars json = new Json();
        Metro metro2 = json.parse(JSONfile);
       }
}