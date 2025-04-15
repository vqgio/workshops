package com.pluralsight;

import java.util.Scanner;

public class FutureValueCalc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the deposit amount (Principal): ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (as a percentage, e.g., 1.75): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        int daysPerYear = 365;
        double dailyRate = annualRate / 100 / daysPerYear;
        int totalDays = years * daysPerYear;

        double futureValue = principal * Math.pow(1 + dailyRate, totalDays);
        double totalInterest = futureValue - principal;

        System.out.println("\n- Future Value Calculation -");
        System.out.printf("Future Value: $%.2f%n", futureValue);
        System.out.printf("Total Interest Earned: $%.2f%n", totalInterest);

        scanner.close();

    }

}
