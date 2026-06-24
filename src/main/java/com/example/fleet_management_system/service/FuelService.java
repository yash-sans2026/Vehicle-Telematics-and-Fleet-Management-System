package com.example.fleet_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.fleet_management_system.entity.FuelLog;
import com.example.fleet_management_system.entity.Vehicle;
import com.example.fleet_management_system.repository.FuelLogRepository;
import com.example.fleet_management_system.repository.VehicleRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fleet_management_system.entity.FuelLog;
import com.example.fleet_management_system.repository.FuelLogRepository;

@Service
public class FuelService {

    private final FuelLogRepository fuelLogRepository;

    public FuelService(FuelLogRepository fuelLogRepository) {
        this.fuelLogRepository = fuelLogRepository;
    }

    public List<FuelLog> getAllFuelLogs() {
        return fuelLogRepository.findAll();
    }

    public long getTotalFuelLogs() {
        return fuelLogRepository.count();
    }

    public double getTotalFuelConsumed() {

        return fuelLogRepository.findAll()
                .stream()
                .mapToDouble(FuelLog::getLitresRefilled)
                .sum();
    }

    public double getTotalFuelCost() {

        return fuelLogRepository.findAll()
                .stream()
                .mapToDouble(FuelLog::getCostAmount)
                .sum();
    }

    public double getAverageRefillAmount() {

        List<FuelLog> logs = fuelLogRepository.findAll();

        if (logs.isEmpty()) {
            return 0;
        }

        return logs.stream()
                .mapToDouble(FuelLog::getLitresRefilled)
                .average()
                .orElse(0);
    }
}