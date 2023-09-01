package com.example.java_cw2_2237934;

import java.time.LocalDate;

public class Race {

    private String Location;
    private LocalDate raceDate;

    private int driverPosition;
    private String driverNumber;
    private int driverPoints;


    public Race(String location, LocalDate raceDate, int driverPosition, String driverNumber, int driverPoints) {
        Location = location;
        this.raceDate = raceDate;
        this.driverPosition = driverPosition;
        this.driverNumber = driverNumber;
        this.driverPoints = driverPoints;
    }

    public String getLocation() {
        return Location;
    }

    public LocalDate getRaceDate() {
        return raceDate;
    }

    public int getDriverPosition() {
        return driverPosition;
    }

    public String getDriverNumber() {
        return driverNumber;
    }

    public int getDriverPoints() {
        return driverPoints;
    }

    public void setDriverPoints(int driverPoints) {
        this.driverPoints = driverPoints;
    }
}

