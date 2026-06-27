package com.example.fleet_management_system.service;

import com.example.fleet_management_system.entity.Trip;
import com.example.fleet_management_system.repository.TripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private static final Logger logger = LoggerFactory.getLogger(TripService.class);

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips() {
        logger.info("Fetching all trips from the database");
        return tripRepository.findAll();
    }

    public long getTotalTrips() {
        logger.info("Counting total trips in the database");
        return tripRepository.count();
    }
}