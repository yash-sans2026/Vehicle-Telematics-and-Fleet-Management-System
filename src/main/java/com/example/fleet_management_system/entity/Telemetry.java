package com.example.fleet_management_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Telemetry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int telemetryId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id") // It is used to establish a many-to-one relationship between Telemetry and Vehicle. Each telemetry record is associated with one vehicle.
    private Vehicle vehicle;         // Each vehicle can have multiple telemetry records.

    private Double latitude;

    private Double longitude;

    private Double speed;

    private Double fuelLevel;

    private LocalDateTime recordedAt;


    public int getTelemetryId() {
        return telemetryId;
    }

    public void setTelemetryId(int telemetryId) {
        this.telemetryId = telemetryId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(Double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}
