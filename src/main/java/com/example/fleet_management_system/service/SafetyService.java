package com.example.fleet_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fleet_management_system.entity.DriverScore;
import com.example.fleet_management_system.repository.DriverScoreRepository;

@Service
public class SafetyService {

    private final DriverScoreRepository driverScoreRepository;

    public SafetyService(DriverScoreRepository driverScoreRepository) {
        this.driverScoreRepository = driverScoreRepository;
    }

    public List<DriverScore> getAllDriverScores() {
        return driverScoreRepository.findAll();
    }

    public long getTotalSafetyReports() {
        return driverScoreRepository.count();
    }

    public double getAverageSafetyScore() {

        List<DriverScore> scores =
                driverScoreRepository.findAll();

        if (scores.isEmpty()) {
            return 0;
        }

        return scores.stream()
                .mapToDouble(DriverScore::getSafetyScore)
                .average()
                .orElse(0);
    }

    public int getTotalOverspeedEvents() {

        return driverScoreRepository.findAll()
                .stream()
                .mapToInt(DriverScore::getOverspeedCount)
                .sum();
    }

    public int getTotalHarshEvents() {

        return driverScoreRepository.findAll()
                .stream()
                .mapToInt(DriverScore::getHarshEventCount)
                .sum();
    }
}