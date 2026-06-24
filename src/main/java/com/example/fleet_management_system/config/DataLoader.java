package com.example.fleet_management_system.config;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.fleet_management_system.entity.User;
import com.example.fleet_management_system.entity.Vehicle;
import com.example.fleet_management_system.repository.UserRepository;
import com.example.fleet_management_system.repository.VehicleRepository;
// import com.example.fleet_management_system.utils.DummyTelemetryGenerator;
import com.example.fleet_management_system.utils.DummyUserGenerator;
import com.example.fleet_management_system.utils.DummyVehicleGenerator;


@Configuration // It is used to indicate that this class is a configuration class. It will be picked up by Spring Boot and executed at startup
public class DataLoader implements CommandLineRunner {
   
    private UserRepository userRepository;
    private DummyUserGenerator userGenerator;
    private VehicleRepository vehicleRepository;
    private DummyVehicleGenerator vehicleGenerator;


    public DataLoader(UserRepository userRepository, DummyUserGenerator userGenerator, VehicleRepository vehicleRepository, DummyVehicleGenerator vehicleGenerator) {
        this.userRepository = userRepository;
        this.userGenerator = userGenerator;
        this.vehicleRepository = vehicleRepository;
        this.vehicleGenerator = vehicleGenerator;
    }

    @Override
    public void run(String... args) {

        loadUsers();
        loadVehicles();


        System.out.println("Dummy data loaded successfully.");
    }

    private void loadUsers() {
        if (userRepository.count() == 0) {

            List<User> users = userGenerator.generateUsers();
            userRepository.saveAll(users);
            System.out.println("Dummy users inserted.");
        }
    }


    private void loadVehicles() {
        if (vehicleRepository.count() == 0) {

            List<Vehicle> vehicles = vehicleGenerator.generateVehicles();
            vehicleRepository.saveAll(vehicles);
            System.out.println("Dummy vehicles inserted.");
        }
    }
}
