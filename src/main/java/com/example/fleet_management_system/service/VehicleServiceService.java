package com.example.fleet_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fleet_management_system.entity.ServiceRecord;
import com.example.fleet_management_system.repository.ServiceRecordRepository;

@Service
public class VehicleServiceService {

    private final ServiceRecordRepository serviceRecordRepository;

    public VehicleServiceService(ServiceRecordRepository serviceRecordRepository) {
        this.serviceRecordRepository = serviceRecordRepository;
    }

    public List<ServiceRecord> getAllServiceRecords() {
        return serviceRecordRepository.findAll();
    }

    public long getTotalServices() {
        return serviceRecordRepository.count();
    }

    public double getTotalMaintenanceCost() {

        return serviceRecordRepository.findAll()
                .stream()
                .mapToDouble(ServiceRecord::getServiceCost)
                .sum();
    }

    public List<ServiceRecord> getUpcomingServices() {

        return serviceRecordRepository.findAll()
                .stream()
                .filter(record ->
                        record.getNextServiceDueDate() != null)
                .toList();
    }
}