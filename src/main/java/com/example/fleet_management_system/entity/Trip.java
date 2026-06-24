package com.example.fleet_management_system.entity;

import java.time.LocalDateTime;

import com.example.fleet_management_system.entity.enums.TripStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id") // Assuming Vehicle is the vehicle entity. one vehicle can have multiple trips 
    private Vehicle vehicle;         

    @ManyToOne
    @JoinColumn(name = "driver_id") // Assuming User is the driver entity. one driver can have multiple trips
    private User driver;
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double distanceKm;
    private TripStatus tripStatus;

    public Trip(Vehicle vehicle, User driver, LocalDateTime startTime, LocalDateTime endTime, Double distanceKm,
            TripStatus tripStatus) {
        this.vehicle = vehicle;
        this.driver = driver;
        this.startTime = startTime;
        this.endTime = endTime;
        this.distanceKm = distanceKm;
        this.tripStatus = tripStatus;
    }
    public Trip() {
    }

    public int getTripId() {
        return tripId;
    }
    public void setTripId(int tripId) {
        this.tripId = tripId;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public User getDriver() {
        return driver;
    }
    public void setDriver(User driver) {
        this.driver = driver;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public Double getDistanceKm() {
        return distanceKm;
    }
    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }
    public TripStatus getTripStatus() {
        return tripStatus;
    }
    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }
    
}
