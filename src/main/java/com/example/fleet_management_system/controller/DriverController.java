package com.example.fleet_management_system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleet_management_system.entity.DriverScore;
import com.example.fleet_management_system.entity.Trip;
import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.service.DriverService;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {

    Map<String, Object> response = new HashMap<>();

    response.put("driver", driverService.getDriver());
    response.put("totalTrips", driverService.getTotalTrips());
    response.put("totalDistance", driverService.getTotalDistance());

    return response;
}
    @GetMapping("/recent-trips")
    public List<Trip> getRecentTrips() {
        return driverService.getRecentTrips();
    }

    @GetMapping("/trips")
    public List<Trip> getTrips() {
        return driverService.getRecentTrips();
    }

    @GetMapping("/scores")
    public List<DriverScore> getScores() {
        return driverService.getDriverScores();
    }

    @GetMapping("/profile")
    public User getProfile() {
        return driverService.getDriver();
    }
}