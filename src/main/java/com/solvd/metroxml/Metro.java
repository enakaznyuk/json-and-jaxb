package com.solvd.metroxml;

import com.solvd.metroxml.employee.Employee;
import com.solvd.metroxml.station.Station;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Metros")
@XmlType(propOrder = {"stations", "employees", "timeTable"})
public class Metro {

    private List<Station> stations;
    private List<Employee> employees;
    private Timetable timeTable;

    @XmlElementWrapper(name = "Stations")
    @XmlElement(name = "Station")
    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @XmlElementWrapper(name = "Employees")
    @XmlElement(name = "Employee")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @XmlElement
    public Timetable getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(Timetable timetable) {
        this.timeTable = timetable;
    }
}
