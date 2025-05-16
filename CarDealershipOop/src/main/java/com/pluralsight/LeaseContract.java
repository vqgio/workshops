package com.pluralsight;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String email, Vehicle vehicleSold) {
        super(date, customerName, email, vehicleSold);
    }
    //private double mon

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
    @Override
    public double getTotalPrice() {
        return 0;
    }
}
