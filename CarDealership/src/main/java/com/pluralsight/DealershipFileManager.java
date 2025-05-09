package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    private static final string FILE_PATH = "inventory.csv";

    public static Dealership getDealership() {
        Dealership dealership = new Dealership("Default, Location unknown");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if(data.length == 8) {
                    int vehicleId = Integer.parseInt(data[0]);
                    int modelYear = Integer.parseInt(data[1]);
                    String make = data[2];
                    String model = data[3];
                    String carType = data[4];
                    String color = data[5];
                    int mileage = Integer.parseInt(data[6]);
                    double price = Double.parseDouble(data[7]);
                    Vehicle vehicle = new Vehicle(vehicleId, modelYear, make, model, carType, color, mileage, price);
                    dealership.addVehicle(vehicle);
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR, failed reading inventory, please try again" + e.getMessage());
        }
        return dealership;
    }
    public static void saveDealership(Dealership dealership) {
        //for later
    }
}
