package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private ArrayList<Vehicle> inventory;
    private String location;
    private String name;

    public Dealership(String name, String location) {
        this.inventory = new ArrayList<Vehicle>();
        this.location = location;
        this.name = name;
    }
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }
    public Vehicle searchByMake(String make) {
        return null;
    }
    public Vehicle searchByModel(String model) {
        return null;
    }
    public Vehicle searchByYear(int year) {
        return null;
    }
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
    }

}
