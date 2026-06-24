package com.example.fleet_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fleet_management_system.entity.Telemetry;

@Repository
public interface TelemetryRepository extends JpaRepository<Telemetry, Integer> {
    
}
