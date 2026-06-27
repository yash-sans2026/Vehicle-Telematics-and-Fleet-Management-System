package com.example.fleet_management_system.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.repository.TripRepository;
import com.example.fleet_management_system.repository.UserRepository;
import com.example.fleet_management_system.repository.VehicleRepository;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
    private final TripRepository tripRepository;

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    public AdminService(UserRepository userRepository, VehicleRepository vehicleRepository, TripRepository tripRepository) {
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
        this.tripRepository = tripRepository;
    }

    public List<User> getAllUsers() {
        logger.info("Fetching all users from the database");
        return userRepository.findAll();
    }

    public long getTotalUsers() {
        logger.info("Counting total users in the database");
        return userRepository.count();
    }

    public long getTotalVehicles() {
        logger.info("Counting total vehicles in the database");
        return vehicleRepository.count();
    }

    public long getTotalTrips() {
        logger.info("Counting total trips in the database");
        return tripRepository.count();
    }
}