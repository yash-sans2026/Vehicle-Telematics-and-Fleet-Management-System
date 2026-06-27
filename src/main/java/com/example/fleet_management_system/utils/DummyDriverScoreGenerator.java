package com.example.fleet_management_system.utils;

import java.time.LocalDate;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.fleet_management_system.entity.DriverScore;
import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.entity.Vehicle;

@Component
public class DummyDriverScoreGenerator {

    private final Random random = new Random();
    private static final Logger logger = LoggerFactory.getLogger(DummyDriverScoreGenerator.class);

    public DriverScore generate(User driver, Vehicle vehicle) {

        DriverScore score = new DriverScore();

        score.setDriver(driver);
        score.setVehicle(vehicle);

        score.setScoringDate(
                LocalDate.now()
                        .minusDays(random.nextInt(30))
        );

        int harshEventCount = random.nextInt(6); // 
        int overspeedCount = random.nextInt(8);       

        score.setHarshEventCount(
                harshEventCount
        );

        score.setOverspeedCount(
                overspeedCount
        );

        double safetyScore = 100.0;

        safetyScore -= harshEventCount * 8;
        safetyScore -= overspeedCount * 5;

        if (safetyScore < 0) {
            safetyScore = 0;
        }

        score.setSafetyScore(
                Math.round(safetyScore * 100.0) / 100.0
        );

        logger.info("Generated dummy driver score for driver");
        return score;
    }
}