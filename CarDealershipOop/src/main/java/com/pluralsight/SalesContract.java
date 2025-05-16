package com.pluralsight;

public class SalesContract extends Contract {
    private static final double RECORDING_FEE = 100;
    private static final double SALES_TAX_RATE = 0.05;
    private static final double PROCESSING_FEE_UNDER_10K = 295;
    private static final double PROCESSING_FEE_OVER_10K = 495;
    private static final double INTEREST_RATE_UNDER_10K = 0.0525;
    private static final double INTEREST_RATE_OVER_10K = 0.0425;
    private static final int TERM_UNDER_10K = 24;
    private static final int TERM_OVER_10K = 48;

    private double salesTaxAmount;
    private double processingFee;
    private boolean finance;

    public SalesContract(String date, String customerName, String email, Vehicle vehicleSold, double salesTaxAmount, double processingFee, boolean finance) {
        super(date, customerName, email, vehicleSold);
        this.salesTaxAmount = vehicleSold.getYear() * SALES_TAX_RATE;
        this.processingFee = (vehicleSold.getPrice() < 10000) ? PROCESSING_FEE_UNDER_10K : PROCESSING_FEE_OVER_10K;
        this.finance = finance;

    }
    @Override
    public double getTotalPrice() {
        return vehicleSold().getPrice() + salesTaxAmount + RECORDING_FEE + processingFee;
    }
    @Override
    public double getMonthlyPayment() {
        if (!finance) {
            return 0;
        }

        double loanAmount = getTotalPrice();
        double interestRate = (vehicleSold().getPrice() < 10000) ? INTEREST_RATE_UNDER_10K : INTEREST_RATE_OVER_10K;
        int term = (vehicleSold().getPrice() < 10000) ? TERM_UNDER_10K : TERM_OVER_10K;

        return (loanAmount * (interestRate / 12)) / (1 - Math.pow(1 + (interestRate / 12), -term));
    }


}
