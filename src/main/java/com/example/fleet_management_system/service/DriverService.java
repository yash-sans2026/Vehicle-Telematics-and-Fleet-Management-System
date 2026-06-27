package com.example.fleet_management_system.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.fleet_management_system.entity.DriverScore;
import com.example.fleet_management_system.entity.Trip;
import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.repository.DriverScoreRepository;
import com.example.fleet_management_system.repository.TripRepository;
import com.example.fleet_management_system.repository.UserRepository;

@Service
public class DriverService {

    private final UserRepository userRepository;
    private final TripRepository tripRepository;
    private final DriverScoreRepository driverScoreRepository;
    private static final Logger logger = LoggerFactory.getLogger(DriverService.class);

    public DriverService(
            UserRepository userRepository,
            TripRepository tripRepository,
            DriverScoreRepository driverScoreRepository) {

        this.userRepository = userRepository;
        this.tripRepository = tripRepository;
        this.driverScoreRepository = driverScoreRepository;
    }

    // Since only one driver exists in the system
    public User getDriver() {
        logger.info("Fetching driver with ID 3 from the database");
        return userRepository.findById(3).orElse(null);
    }
    


    public long getTotalTrips() {

        User driver = getDriver();

        if (driver == null) {
            return 0;
        }
        logger.info("Counting total trips for driver with ID 3");
        return tripRepository.countByDriver(driver);
    }

    public double getTotalDistance() {

        User driver = getDriver();

        if (driver == null) {
            return 0;
        }

        List<Trip> trips =
                tripRepository.findByDriver(driver);

        logger.info("Calculating total distance for driver with ID 3");
        return trips.stream()
                .mapToDouble(Trip::getDistanceKm)
                .sum();
    }

    public List<Trip> getRecentTrips() {

        User driver = getDriver();

        if (driver == null) {
            return List.of();
        }
        logger.info("Fetching recent trips for driver with ID 3");
        return tripRepository.findByDriver(driver);
    }

    public List<DriverScore> getDriverScores() {

        User driver = getDriver();

        if (driver == null) {
            return List.of();
        }

        logger.info("Fetching driver scores for driver with ID 3");
        return driverScoreRepository.findByDriver(driver);
    }
}