package com.pluralsight;

public class Vehicle {
    int vehicleId;
    int modelYear;
    String carMake;
    String carModel;
    String carType;
    String color;
    int mileage;
    double price;

    public Vehicle(int vehicleId, int modelYear, String carMake, String carModel, String color, String carType, int mileage, double price) {
        this.vehicleId = vehicleId;
        this.modelYear = modelYear;
        this.carMake = carMake;
        this.carModel = carModel;
        this.color = color;
        this.carType = carType;
        this.mileage = mileage;
        this.price = price;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
