package com.example.fleet_management_system.utils;

import java.time.LocalDate;
import java.util.Random;

import com.example.fleet_management_system.config.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.fleet_management_system.entity.FuelLog;
import com.example.fleet_management_system.entity.Vehicle;

@Component
public class DummyFuelLogGenerator {

    private final Random random = new Random();
    private static final Logger logger = LoggerFactory.getLogger(DummyFuelLogGenerator.class);

    public FuelLog generate(Vehicle vehicle) {

        double litres = 20 + random.nextInt(50);

        FuelLog fuelLog = new FuelLog();

        fuelLog.setVehicle(vehicle);

        fuelLog.setRefillDate(
        LocalDate.now().minusDays(random.nextInt(90)));

        fuelLog.setLitresRefilled(litres);

        fuelLog.setOdometerReading(
                10000 + random.nextInt(90000)
        );

        fuelLog.setCostAmount(
                litres * 95
        );

        logger.info("Generated dummy fuel log for vehicle");
        return fuelLog;
    }
}
