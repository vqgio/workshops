package com.pluralsight;

public abstract class Contract {
    private String date;
    private String customerName;
    private String email;
    private Vehicle vehicleSold;

    public Contract(String date, String customerName,
                    String email, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.email = email;
        this.vehicleSold = vehicleSold;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
