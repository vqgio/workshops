package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class DealershipFileManager {
    private final String fileName;
    //This will read csv file without me specifying path bc using relative path, as long as its stored in the java app

    public DealershipFileManager(String fileName) {
        this.fileName = fileName;
    }
    public Dealership getDealership() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Empty file");
            }
            String[] info = scanner.nextLine().split("\\|");
            Dealership dealer = new Dealership(info[0], info[1], info[2]);
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("\\|");
                if (parts.length < 8) {
                    continue;
                }
                Vehicle v = new Vehicle(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        parts[2], parts[3], parts[4], parts[5],
                        Integer.parseInt(parts[6]),
                        Double.parseDouble(parts[7]));
                dealer.addVehicle(v);
            }
            return dealer;
        } catch (IOException e) {
            throw new RuntimeException("Sorry, Unable to load " + fileName, e);
        }
    }
    public void saveDealership(Dealership dealer) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.println(dealer.getName() + "|" + dealer.getAddress() + "|" + dealer.getPhone());
            for (Vehicle v : dealer.getAllVehicles()) {
                out.println(v.toFileString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Sorry Unable to succesfully save " + fileName, e);
        }
    }
}
