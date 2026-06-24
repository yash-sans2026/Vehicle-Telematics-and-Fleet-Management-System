package com.example.fleet_management_system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleet_management_system.entity.ServiceRecord;
import com.example.fleet_management_system.service.VehicleServiceService;

@RestController
@RequestMapping("/api/service")
public class VehicleServiceController {

    private final VehicleServiceService vehicleServiceService;

    public VehicleServiceController(VehicleServiceService vehicleServiceService) {
        this.vehicleServiceService = vehicleServiceService;
    }

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {

        Map<String, Object> response = new HashMap<>();

        response.put("totalServices", vehicleServiceService.getTotalServices());
        response.put("totalMaintenanceCost", vehicleServiceService.getTotalMaintenanceCost());
        response.put("upcomingServicesCount", vehicleServiceService.getUpcomingServices().size());

        return response;
    }

    @GetMapping("/records")
    public List<ServiceRecord> getAllServiceRecords() {
        return vehicleServiceService.getAllServiceRecords();
    }

    @GetMapping("/upcoming")
    public List<ServiceRecord> getUpcomingServices() {
        return vehicleServiceService.getUpcomingServices();
    }
}
