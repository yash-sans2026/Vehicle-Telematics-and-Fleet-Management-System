package com.example.fleet_management_system.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fleet_management_system.entity.Telemetry;
import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.entity.Vehicle;
import com.example.fleet_management_system.entity.enums.Role;
import com.example.fleet_management_system.entity.enums.VehicleStatus;
import com.example.fleet_management_system.repository.TelemetryRepository;
import com.example.fleet_management_system.repository.UserRepository;
import com.example.fleet_management_system.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final TelemetryRepository telemetryRepository;
    private final UserRepository userRepository;

    public VehicleService(
            VehicleRepository vehicleRepository,
            TelemetryRepository telemetryRepository,
            UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.telemetryRepository = telemetryRepository;
        this.userRepository = userRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle registerVehicle(
            String vin,
            int registrationNumber,
            String vehicleType,
            String deviceImei,
            String fleetManagerEmail) {

        if (vin == null || vin.isBlank()) {
            throw new IllegalArgumentException("VIN is required");
        }
        if (vehicleType == null || vehicleType.isBlank()) {
            throw new IllegalArgumentException("Vehicle type is required");
        }
        if (deviceImei == null || deviceImei.isBlank()) {
            throw new IllegalArgumentException("Device IMEI is required");
        }

        User fleetManager = userRepository.findByEmail(fleetManagerEmail);
        if (fleetManager == null || fleetManager.getRole() != Role.FLEET_MANAGER) {
            throw new IllegalArgumentException("Only Fleet Manager can register vehicles");
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setVin(vin);
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setVehicleType(vehicleType);
        vehicle.setDeviceImei(deviceImei);
        vehicle.setVehicleStatus(VehicleStatus.ACTIVE);

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        Telemetry telemetry = new Telemetry();
        telemetry.setVehicle(savedVehicle);
        telemetry.setLatitude(0.0);
        telemetry.setLongitude(0.0);
        telemetry.setSpeed(0.0);
        telemetry.setFuelLevel(100.0);
        telemetry.setRecordedAt(LocalDateTime.now());
        telemetryRepository.save(telemetry);

        return savedVehicle;
    }
}
