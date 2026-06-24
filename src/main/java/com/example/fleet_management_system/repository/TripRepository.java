package com.example.fleet_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fleet_management_system.entity.Trip;
import com.example.fleet_management_system.entity.User;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
    long countByDriver(User driver);
    List<Trip> findByDriver(User driver);
}
