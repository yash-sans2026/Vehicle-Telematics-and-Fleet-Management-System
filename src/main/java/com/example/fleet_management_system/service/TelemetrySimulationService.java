package com.example.fleet_management_system.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.entity.Vehicle;
import com.example.fleet_management_system.repository.DriverScoreRepository;
import com.example.fleet_management_system.repository.FuelLogRepository;
import com.example.fleet_management_system.repository.ServiceRecordRepository;
import com.example.fleet_management_system.repository.TelemetryRepository;
import com.example.fleet_management_system.repository.TripRepository;
import com.example.fleet_management_system.repository.UserRepository;
import com.example.fleet_management_system.repository.VehicleRepository;
import com.example.fleet_management_system.utils.DummyDriverScoreGenerator;
import com.example.fleet_management_system.utils.DummyFuelLogGenerator;
import com.example.fleet_management_system.utils.DummyServiceRecordGenerator;
import com.example.fleet_management_system.utils.DummyTelemetryGenerator;
import com.example.fleet_management_system.utils.DummyTripGenerator;

@Service
public class TelemetrySimulationService {

    private final VehicleRepository vehicleRepository;
    private final TelemetryRepository telemetryRepository;
    private final TripRepository tripRepository;
    private final FuelLogRepository fuelLogRepository;
    private final ServiceRecordRepository serviceRecordRepository;
    private final UserRepository userRepository;
    private final DriverScoreRepository driverScoreRepository;
    private final DummyDriverScoreGenerator driverScoreGenerator;
    private final DummyTelemetryGenerator telemetryGenerator;
    private final DummyTripGenerator tripGenerator;
    private final DummyFuelLogGenerator fuelLogGenerator;
    private final DummyServiceRecordGenerator serviceGenerator;

    public TelemetrySimulationService(
            VehicleRepository vehicleRepository,
            TelemetryRepository telemetryRepository,
            TripRepository tripRepository,
            FuelLogRepository fuelLogRepository,
            ServiceRecordRepository serviceRecordRepository,
            UserRepository userRepository,
            DriverScoreRepository driverScoreRepository,
            DummyDriverScoreGenerator driverScoreGenerator,
            DummyTelemetryGenerator telemetryGenerator,
            DummyTripGenerator tripGenerator,
            DummyFuelLogGenerator fuelLogGenerator,
            DummyServiceRecordGenerator serviceGenerator) {

        this.vehicleRepository = vehicleRepository;
        this.telemetryRepository = telemetryRepository;
        this.tripRepository = tripRepository;
        this.fuelLogRepository = fuelLogRepository;
        this.serviceRecordRepository = serviceRecordRepository;
        this.userRepository = userRepository;
        this.driverScoreRepository = driverScoreRepository;
        this.driverScoreGenerator = driverScoreGenerator;
        this.telemetryGenerator = telemetryGenerator;
        this.tripGenerator = tripGenerator;
        this.fuelLogGenerator = fuelLogGenerator;
        this.serviceGenerator = serviceGenerator;
    }

    // Logger is an interface from SLF4J.
    // Passes the current class name to the logger.
    private static final Logger logger = LoggerFactory.getLogger(TelemetrySimulationService.class);

    @Scheduled(fixedRate = 5000)
    public void generateData() {

        List<Vehicle> vehicles = vehicleRepository.findAll();

        User driver = userRepository
                .findByEmail("driver@gmail.com");

        for (Vehicle vehicle : vehicles) {

            // Telemetry every 5 seconds
            telemetryRepository.save(
                    telemetryGenerator.generate(vehicle)
            );

            double x = Math.random();

            // 20% chance to create Trip
            if (x < 0.2 && driver != null) {
                tripRepository.save(
                        tripGenerator.generate(vehicle, driver)
                );
            }

            // 10% chance to create Fuel Log
            if (x < 0.1) {
                fuelLogRepository.save(
                        fuelLogGenerator.generate(vehicle)
                );
            }

            // 5% chance to create Service Record
            if (x < 0.05) {
                serviceRecordRepository.save(
                        serviceGenerator.generate(vehicle)
                );
            }

            if (x < 0.2 && driver != null) {
                driverScoreRepository.save(
                    driverScoreGenerator.generate(
                        driver,
                        vehicle
                    )
                );
            }
        }

        logger.info("Telemetry data generated for all vehicles.");
    }
}