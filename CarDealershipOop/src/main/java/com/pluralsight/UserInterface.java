package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public void display() {
        init();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running) {
            displayMenu();
            System.out.println("Enter command: ");
            String command = scanner.nextLine();

            switch(command) {
                case "1":
                    processAllVehicleRequest();
                    break;
                case "q":
                    running = false;
                    System.out.println("quitting program. Exiting now....");
                    break;
                default:
                    System.out.println("Sorry that is not an option, try again!");
            }
        }
        scanner.close();
    }
    private void processAllVehicleRequest() {

    }
    private void displayVehicles(ArrayList<Vehicle> vehicles) {

    }
    private void displayMenu() {


    }

}
