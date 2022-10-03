package com.solvd.metroxml.parse.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.solvd.metroxml.Metro;
import com.solvd.metroxml.employee.Employee;
import com.solvd.metroxml.parse.CustomConverter;
import com.solvd.metroxml.parse.IPars;
import com.solvd.metroxml.station.Station;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalTime;
import java.util.List;

public class Parse implements IPars {

    private static final Logger LOGGER = LogManager.getLogger(Parse.class);

    @Override
    public Metro parse(File file) {

        Metro metro = new Metro();

        try {
            JAXBContext jaxbContextOne = JAXBContext.newInstance(Metro.class);
            Unmarshaller jaxbUnmarshaller = jaxbContextOne.createUnmarshaller();

            metro = (Metro) jaxbUnmarshaller.unmarshal(file);

            List<Employee> employees = metro.getEmployees();
            List<Station> stations = metro.getStations();

            int i=0;
            for(Employee employee : employees)
            {
                i++;
                System.out.println("employee:" + i + " " + employee.getFirstName());
            }
            int j=0;
            for(Station station : stations)
            {
                j++;
                System.out.println("station:" + j + " " + station.getName());
            }
            LOGGER.info("start:" + metro.getTimeTable().getStartWorking());
            LOGGER.info("end:" + metro.getTimeTable().getEndWorking());

            GsonBuilder builderN = new GsonBuilder().registerTypeAdapter(LocalTime.class, new CustomConverter());
            Gson gN = builderN.create();
            String Jstring = gN.toJson(metro);
            System.out.println(Jstring);

        } catch (JAXBException e) {
            LOGGER.error(e);
        }

        return metro;
    }
}
