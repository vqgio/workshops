package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {

    @Test
    void getAllVehicles() {
        //Arange
        Vehicle myCar = new Vehicle();
        Dealership dealership = new Dealership();
        dealership.addVehicle(myCar);

        //Act
        ArrayList<Vehicle> actual = dealership.getAllVehicles();

        //Assert
        assertTrue(actual.contains(myCar));
    }
}