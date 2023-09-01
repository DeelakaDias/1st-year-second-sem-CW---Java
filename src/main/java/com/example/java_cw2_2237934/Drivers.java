package com.example.java_cw2_2237934;

public class Drivers {
    String driverNumber;
    String name;
    int age;
    String team;
    String model;
    int points;


    Drivers( String driverNumber, String name, int age, String team, String model, int points) {
        this.driverNumber = driverNumber;
        this.name = name;
        this.age = age;
        this.team = team;
        this.model = model;
        this.points = points;

    }
    // obtaining Driver's name form the user
    public String getDriverNumber() {return this.driverNumber;}
    //obtaining Driver's age from the user
    public String getName() {return this.name;}
    //obtaining Driver's team from the user
    public int getAge() {return this.age;}
    //obtaining car model from the user
    public  String getTeam() {return this.team;}
    //obtaining Driver's current points from the user
    public String getModel() {return this.model;}
    //obtaining Driver's current points from the user
    public int getPoints() {return this.points;}
    // this will update driver points, drivers who got 1st, 2nd and 3rd positions
    public void setPoints(int newPoints) {this.points = newPoints;}
}