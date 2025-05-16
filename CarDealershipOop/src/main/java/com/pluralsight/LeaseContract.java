package com.pluralsight;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String email, Vehicle vehicleSold) {
        super(date, customerName, email, vehicleSold);
    }
    //private double mon


    public double getMonthlyPayment() {
        return 0;
    }
    public double getTotalPrice() {
        return 0;
    }
}
