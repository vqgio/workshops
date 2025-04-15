package com.pluralsight;

import java.util.Scanner;

public class MortgageCalc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //nextDouble allows me to read the value of the user that can be decimals
        System.out.print("Enter the principal loan amount : ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (as a percentage, ex: 7.625): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter the loan term in years: ");
        int loanYears = scanner.nextInt();
        int totalPayments = loanYears * 12;
        double monthlyRate = annualRate / 100 / 12;

        //used fractions in order to calculate loan monthly payment
        double numerator = monthlyRate * Math.pow(1 + monthlyRate, totalPayments);
        double denominator = Math.pow(1 + monthlyRate, totalPayments) - 1;
        double monthlyPayment = principal * (numerator / denominator);

        double totalPaid = monthlyPayment * totalPayments;

        double totalInterest = totalPaid - principal;
        /*
        % is a placeholder for a variable value
        .2f specifies it only wants 2 digits after decimal point (floating point number)
        $ means its money
        %n adds a new line after the output
        */
        System.out.println("\n- Mortgage Details -");
        System.out.printf("Monthly Payment: $%.2f%n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f%n", totalInterest);

        scanner.close();

    }
}
