package com.example.fleet_management_system.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.fleet_management_system.entity.Vehicle;
import com.example.fleet_management_system.entity.enums.VehicleStatus;

@Component
public class DummyVehicleGenerator {
    public List<Vehicle> generateVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle(
                "VIN1234567890",
                12345,
                "Sedan",
                "ABC123",
                VehicleStatus.ACTIVE
        ));

        // vehicles.add(new Vehicle(
        //         "VIN0987654321",
        //         67890,
        //         "Truck",
        //         "DEF456",
        //         VehicleStatus.IN_SERVICE
        // ));

        // vehicles.add(new Vehicle(
        //         "VIN9876543210",
        //         23456,
        //         "SUV",
        //         "GHI789",
        //         VehicleStatus.ACTIVE
        // ));

        // vehicles.add(new Vehicle(
        //         "VIN1234567890",
        //         12345,
        //         "Sedan",
        //         "ABC123",
        //         VehicleStatus.ACTIVE
        // ));

        // vehicles.add(new Vehicle(
        //         "VIN0987654321",
        //         67890,
        //         "Truck",
        //         "DEF456",
        //         VehicleStatus.IN_SERVICE
        // ));

        return vehicles;
    }
}
