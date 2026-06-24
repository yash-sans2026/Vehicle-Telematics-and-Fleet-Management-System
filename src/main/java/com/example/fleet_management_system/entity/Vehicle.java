package com.example.fleet_management_system.entity;

import com.example.fleet_management_system.entity.enums.VehicleStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;
    private String vin;
    private int registrationNumber;
    private String vehicleType;
    private String deviceImei;
    private VehicleStatus vehicleStatus;

    public Vehicle(String vin, int registrationNumber, String vehicleType, String deviceImei, VehicleStatus vehicleStatus) {
        this.vin = vin;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.deviceImei = deviceImei;
        this.vehicleStatus = vehicleStatus;
    }

    public Vehicle() {
    }

    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getVin() {
        return vin;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public int getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getDeviceImei() {
        return deviceImei;
    }
    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei;
    }
    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }
    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

}
