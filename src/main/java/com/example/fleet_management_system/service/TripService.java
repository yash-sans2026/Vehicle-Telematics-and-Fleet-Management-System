package com.example.fleet_management_system.service;

import com.example.fleet_management_system.entity.Trip;
import com.example.fleet_management_system.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public long getTotalTrips() {
        return tripRepository.count();
    }
}