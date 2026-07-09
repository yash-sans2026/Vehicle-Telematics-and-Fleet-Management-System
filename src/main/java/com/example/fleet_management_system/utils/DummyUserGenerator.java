package com.example.fleet_management_system.utils;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.entity.enums.Role;

@Component
public class DummyUserGenerator {
    private final PasswordEncoder passwordEncoder;

    public DummyUserGenerator(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private static final Logger logger = LoggerFactory.getLogger(DummyUserGenerator.class);
    public List<User> generateUsers() {

        List<User> users = new ArrayList<>();

        users.add(new User(
                "Admin User",
                "admin@gmail.com",
                passwordEncoder.encode("admin123"),
                Role.ADMIN
        ));

        users.add(new User(
                "Fleet Manager",
                "fleet@gmail.com",
                passwordEncoder.encode("fleet123"),
                Role.FLEET_MANAGER
        ));

        users.add(new User(
                "Driver One",
                "driver@gmail.com",
                passwordEncoder.encode("driver123"),
                Role.DRIVER
        ));

        users.add(new User(
                "Safety Officer",
                "safety@gmail.com",
                passwordEncoder.encode("safety123"),
                Role.SAFETY_OFFICER
        ));

        users.add(new User(
                "Service Engineer",
                "service@gmail.com",
                passwordEncoder.encode("service123"),
                Role.SERVICE_ENGINEER
        ));

        users.add(new User(
                "Operations Analyst",
                "analyst@gmail.com",
                passwordEncoder.encode("analyst123"),
                Role.OPERATIONS_ANALYST
        ));

        logger.info("Generated dummy users for the fleet management system");
        return users;
    }
}
