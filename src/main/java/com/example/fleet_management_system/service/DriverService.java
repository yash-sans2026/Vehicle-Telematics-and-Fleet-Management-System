package com.example.fleet_management_system.service;

import java.util.List;

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
        return userRepository.findById(3).orElse(null);
    }
    


    public long getTotalTrips() {

        User driver = getDriver();

        if (driver == null) {
            return 0;
        }

        return tripRepository.countByDriver(driver);
    }

    public double getTotalDistance() {

        User driver = getDriver();

        if (driver == null) {
            return 0;
        }

        List<Trip> trips =
                tripRepository.findByDriver(driver);

        return trips.stream()
                .mapToDouble(Trip::getDistanceKm)
                .sum();
    }

    public List<Trip> getRecentTrips() {

        User driver = getDriver();

        if (driver == null) {
            return List.of();
        }

        return tripRepository.findByDriver(driver);
    }

    public List<DriverScore> getDriverScores() {

        User driver = getDriver();

        if (driver == null) {
            return List.of();
        }

        return driverScoreRepository.findByDriver(driver);
    }
}