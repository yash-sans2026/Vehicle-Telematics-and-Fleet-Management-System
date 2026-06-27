package com.example.fleet_management_system.utils;

import java.time.LocalDateTime;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.fleet_management_system.entity.Trip;
import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.entity.Vehicle;
import com.example.fleet_management_system.entity.enums.TripStatus;


@Component
public class DummyTripGenerator {

    private final Random random = new Random();
    private static final Logger logger = LoggerFactory.getLogger(DummyTripGenerator.class);

    private LocalDateTime lastTripEnd =
            LocalDateTime.now().minusDays(5);

    public Trip generate(Vehicle vehicle, User driver) {

        int gapHours = 1 + random.nextInt(3);

        LocalDateTime start =
                lastTripEnd.plusHours(gapHours);

        int durationHours =
                1 + random.nextInt(8);

        LocalDateTime end =
                start.plusHours(durationHours);

        Trip trip = new Trip();

        trip.setVehicle(vehicle);
        trip.setDriver(driver);

        trip.setStartTime(start);
        trip.setEndTime(end);

        trip.setDistanceKm(
                50 + random.nextDouble() * 450
        );

        trip.setTripStatus(
                TripStatus.COMPLETED
        );

        lastTripEnd = end;

        logger.info("Generated dummy trip for vehicle and driver");
        return trip;
    }
}