package com.example.fleet_management_system.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FuelLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fuelLogId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private LocalDate refillDate;

    private Double litresRefilled;

    private int odometerReading;

    private Double costAmount;

    public FuelLog() {

    }


    public int getFuelLogId() {
        return fuelLogId;
    }

    public void setFuelLogId(int fuelLogId) {
        this.fuelLogId = fuelLogId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getRefillDate() {
        return refillDate;
    }

    public void setRefillDate(LocalDate refillDate) {
        this.refillDate = refillDate;
    }

    public Double getLitresRefilled() {
        return litresRefilled;
    }

    public void setLitresRefilled(Double litresRefilled) {
        this.litresRefilled = litresRefilled;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public Double getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(Double costAmount) {
        this.costAmount = costAmount;
    }
}
