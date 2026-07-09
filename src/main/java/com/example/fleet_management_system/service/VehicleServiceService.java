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

    // <ServiceRecord> is a generic type, meaning the list will contain only ServiceRecord objects.
    public List<ServiceRecord> getAllServiceRecords() {
        logger.info("Fetching all service records from the database");
        return serviceRecordRepository.findAll();
    }

    public long getTotalServices() {
        logger.info("Counting total service records in the database");
        return serviceRecordRepository.count();
    }

    // mapToDouble() is used because serviceCost is a double value, and we want to perform numeric operations like sum(), average(), etc.
    // This retrieves all records from the database.
    // Convert the list into a stream, A Stream lets you process a collection of objects one by one.
    // Extract the service cost from each record
    // Add all the costs together
    public double getTotalMaintenanceCost() {
        logger.info("Calculating total maintenance cost from all service records");
        return serviceRecordRepository.findAll()
                .stream()
                .mapToDouble(ServiceRecord::getServiceCost) // mapToDouble() is used to convert the stream of ServiceRecord objects into a stream of double values (the service costs).
                .sum(); // sum() adds up all the double values in the stream and returns the total maintenance cost.
    }



    // This method is used to get all service records that have a "Next Service Due Date" set
    // Gets all service records from the database.
    // Convert to Stream
    // Keeps only records where nextServiceDueDate is not null.
    // Collects the filtered records into a new List.
    public List<ServiceRecord> getUpcomingServices() {
        logger.info("Fetching upcoming service records from the database");
        return serviceRecordRepository.findAll()
                .stream()
                .filter(record ->
                        record.getNextServiceDueDate() != null)
                .toList();
    }
}