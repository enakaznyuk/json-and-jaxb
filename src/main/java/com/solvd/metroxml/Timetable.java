package com.solvd.metroxml;

import com.solvd.metroxml.jaxb.LocalTimeAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalTime;

@XmlType(propOrder = {"startWorking", "endWorking"})
public class Timetable {

    private LocalTime startWorking;
    private LocalTime endWorking;

    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
    @XmlElement
    public LocalTime getStartWorking() {
        return startWorking;
    }

    public void setStartWorking(LocalTime startWorking) {
        this.startWorking = startWorking;
    }

    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
    @XmlElement
    public LocalTime getEndWorking() {
        return endWorking;
    }

    public void setEndWorking(LocalTime endWorking) {
        this.endWorking = endWorking;
    }
}
