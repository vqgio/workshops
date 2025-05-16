package com.pluralsight;

public class SalesContract extends Contract {
    private static final double recordingFee = 100;
    private double salesTaxAmount;
    private double processingFee;
    private boolean finance;
    public SalesContract(String date, String customerName, String email, Vehicle vehicleSold, double salesTaxAmount, double processingFee, boolean finance) {
        super(date, customerName, email, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.processingFee = processingFee;
        this.finance = finance;

    }
    public double getMonthlyPayment() {
        return 0;
    }
    public double getTotalPrice() {
        return 0;
    }


}
