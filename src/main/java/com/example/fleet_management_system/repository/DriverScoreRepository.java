package com.example.fleet_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fleet_management_system.entity.DriverScore;
import com.example.fleet_management_system.entity.User;

@Repository
public interface DriverScoreRepository extends JpaRepository<DriverScore, Integer> {
    List<DriverScore> findByDriver(User driver);
    DriverScore findTopByDriverOrderByScoringDateDesc(User driver);
}
