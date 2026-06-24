package com.example.fleet_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling 
public class FleetManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetManagementSystemApplication.class, args);
	}

}
