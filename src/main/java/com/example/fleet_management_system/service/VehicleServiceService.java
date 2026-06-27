package com.example.fleet_management_system.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.fleet_management_system.entity.ServiceRecord;
import com.example.fleet_management_system.repository.ServiceRecordRepository;

@Service
public class VehicleServiceService {

    private final ServiceRecordRepository serviceRecordRepository;
    private static final Logger logger = LoggerFactory.getLogger(VehicleServiceService.class);

    public VehicleServiceService(ServiceRecordRepository serviceRecordRepository) {
        this.serviceRecordRepository = serviceRecordRepository;
    }

    public List<ServiceRecord> getAllServiceRecords() {
        logger.info("Fetching all service records from the database");
        return serviceRecordRepository.findAll();
    }

    public long getTotalServices() {
        logger.info("Counting total service records in the database");
        return serviceRecordRepository.count();
    }

    public double getTotalMaintenanceCost() {
        logger.info("Calculating total maintenance cost from all service records");
        return serviceRecordRepository.findAll()
                .stream()
                .mapToDouble(ServiceRecord::getServiceCost)
                .sum();
    }

    public List<ServiceRecord> getUpcomingServices() {
        logger.info("Fetching upcoming service records from the database");
        return serviceRecordRepository.findAll()
                .stream()
                .filter(record ->
                        record.getNextServiceDueDate() != null)
                .toList();
    }
}