package com.example.fleet_management_system.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DriverScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scoreId;

    // Create/use a foreign key column called driver_id in the driver_score table.
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private LocalDate scoringDate;

    private int harshEventCount;

    private int overspeedCount;

    private Double safetyScore;

    public DriverScore(User driver, Vehicle vehicle, LocalDate scoringDate, int harshEventCount, int overspeedCount,
            Double safetyScore) {
        this.driver = driver;
        this.vehicle = vehicle;
        this.scoringDate = scoringDate;
        this.harshEventCount = harshEventCount;
        this.overspeedCount = overspeedCount;
        this.safetyScore = safetyScore;
    }

    public DriverScore() {
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getScoringDate() {
        return scoringDate;
    }

    public void setScoringDate(LocalDate scoringDate) {
        this.scoringDate = scoringDate;
    }

    public int getHarshEventCount() {
        return harshEventCount;
    }

    public void setHarshEventCount(int harshEventCount) {
        this.harshEventCount = harshEventCount;
    }

    public int getOverspeedCount() {
        return overspeedCount;
    }

    public void setOverspeedCount(int overspeedCount) {
        this.overspeedCount = overspeedCount;
    }

    public Double getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(Double safetyScore) {
        this.safetyScore = safetyScore;
    }
}
