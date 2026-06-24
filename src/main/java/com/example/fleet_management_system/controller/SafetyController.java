package com.example.fleet_management_system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleet_management_system.entity.DriverScore;
import com.example.fleet_management_system.service.SafetyService;

@RestController
@RequestMapping("/api/safety")
public class SafetyController {

    private final SafetyService safetyService;

    public SafetyController(SafetyService safetyService) {
        this.safetyService = safetyService;
    }

    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {

        Map<String, Object> response = new HashMap<>();

        response.put(
                "totalSafetyReports",
                safetyService.getTotalSafetyReports());

        response.put(
                "averageSafetyScore",
                safetyService.getAverageSafetyScore());

        response.put(
                "totalOverspeedEvents",
                safetyService.getTotalOverspeedEvents());

        response.put(
                "totalHarshEvents",
                safetyService.getTotalHarshEvents());

        return response;
    }

    @GetMapping("/scores")
    public List<DriverScore> getAllScores() {
        return safetyService.getAllDriverScores();
    }
}