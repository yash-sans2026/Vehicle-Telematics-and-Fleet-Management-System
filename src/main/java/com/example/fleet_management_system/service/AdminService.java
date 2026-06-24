package com.example.fleet_management_system.service;

import java.util.List;

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

    public AdminService(UserRepository userRepository, VehicleRepository vehicleRepository, TripRepository tripRepository) {
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
        this.tripRepository = tripRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public long getTotalUsers() {
        return userRepository.count();
    }

    public long getTotalVehicles() {
        return vehicleRepository.count();
    }

    public long getTotalTrips() {
        return tripRepository.count();
    }
}