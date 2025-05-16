package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private Dealership dealership;
    private DealershipFileManager dealershipFm;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        init();
        int choice;
        do {
            showMenu();
            choice = readInt("Enter command: ");
            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 0 -> System.out.println("Good-bye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void init() {
        dealershipFm = new DealershipFileManager("C:\\Users\\rsant\\pluralsight\\workshops\\CarDealershipOop\\src\\main\\resources\\inventory.csv");
        dealership = dealershipFm.getDealership();
    }

    private void showMenu() {
        System.out.println("|--------------- CAR DEALERSHIP ---------------|");
        System.out.println("1) Find vehicles within a price range");
        System.out.println("2) Find vehicles by make / model");
        System.out.println("3) Find vehicles by year range");
        System.out.println("4) Find vehicles by color");
        System.out.println("5) Find vehicles by mileage range");
        System.out.println("6) Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7) List ALL vehicles");
        System.out.println("8) Add a vehicle");
        System.out.println("9) Remove a vehicle");
        System.out.println("0) Quit");
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    private void displayVehicles(ArrayList<Vehicle> list) {
        if (list.isEmpty()) {
            System.out.println("No matching vehicles.\n");
        } else {
            for (Vehicle v : list) {
                System.out.println(v);
            }
            System.out.println();
        }
    }

    private void processGetByPriceRequest() {
        double min = readDouble("Minimum price: ");
        double max = readDouble("Maximum price: ");
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Make : ");
        String make = scanner.nextLine().trim();
        System.out.print("Model: ");
        String model = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    private void processGetByYearRequest() {
        int min = readInt("Earliest year: ");
        int max = readInt("Latest year : ");
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    private void processGetByColorRequest() {
        System.out.print("Color: ");
        String color = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processGetByMileageRequest() {
        int min = readInt("Minimum mileage: ");
        int max = readInt("Maximum mileage: ");
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Type (car/truck/suv/van): ");
        String type = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    private void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processAddVehicleRequest() {
        int vin = readInt("VIN: ");
        int year = readInt("Year: ");
        System.out.print("Make: ");
        String make = scanner.nextLine().trim();
        System.out.print("Model: ");
        String model = scanner.nextLine().trim();
        System.out.print("Type (car/truck/suv/van): ");
        String vehicleType = scanner.nextLine().trim();
        System.out.print("Color: ");
        String color = scanner.nextLine().trim();
        int odometer = readInt("Odometer: ");
        double price = readDouble("Price: ");

        Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(v);
        dealershipFm.saveDealership(dealership);
        System.out.println("Vehicle added.\n");
    }

    private void processRemoveVehicleRequest() {
        int vin = readInt("Enter VIN to remove: ");
        Vehicle target = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                target = v;
                break;
            }
        }
        if (target == null) {
            System.out.println("VIN not found.\n");
        } else {
            dealership.removeVehicle(target);
            dealershipFm.saveDealership(dealership);
            System.out.println("Vehicle removed.\n");
        }
    }
}
