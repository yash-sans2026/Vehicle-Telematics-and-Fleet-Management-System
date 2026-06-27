package com.example.fleet_management_system.utils;

import java.time.LocalDateTime;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.fleet_management_system.entity.Telemetry;
import com.example.fleet_management_system.entity.Vehicle;

@Component
public class DummyTelemetryGenerator {

    private final Random random = new Random(); // It is used to generate random telemetry data
    private static final Logger logger = LoggerFactory.getLogger(DummyTelemetryGenerator.class);

    public Telemetry generate(Vehicle vehicle) {

        Telemetry telemetry = new Telemetry();

        telemetry.setVehicle(vehicle);

        telemetry.setLatitude(9.9252 + random.nextDouble() * 0.02);

        telemetry.setLongitude(78.1198 + random.nextDouble() * 0.02);

        telemetry.setSpeed(40 + random.nextDouble() * 60);

        telemetry.setFuelLevel(20 + random.nextDouble() * 80);

        telemetry.setRecordedAt(
        LocalDateTime.now().minusMinutes(random.nextInt(30)));

        logger.info("Generated dummy telemetry data for vehicle");
        return telemetry;
    }
}
