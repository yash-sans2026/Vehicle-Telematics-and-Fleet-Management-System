package com.example.fleet_management_system.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.fleet_management_system.entity.Vehicle;
import com.example.fleet_management_system.entity.enums.VehicleStatus;

@Component
public class DummyVehicleGenerator {
    private static final Logger logger = LoggerFactory.getLogger(DummyVehicleGenerator.class);
    public List<Vehicle> generateVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle(
                "VIN1234567890",
                12345,
                "Sedan",
                "ABC123",
                VehicleStatus.ACTIVE
        ));

        logger.info("Generated dummy vehicles");
        return vehicles;
    }
}
