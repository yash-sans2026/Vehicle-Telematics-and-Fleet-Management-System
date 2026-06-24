package com.example.fleet_management_system.utils;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.example.fleet_management_system.entity.ServiceRecord;
import com.example.fleet_management_system.entity.Vehicle;

@Component
public class DummyServiceRecordGenerator {

    private final Random random = new Random();

    public ServiceRecord generate(Vehicle vehicle) {

        String[] services = {
                "Engine Oil Change",
                "Brake Service",
                "Tyre Replacement",
                "Battery Replacement",
                "General Inspection"
        };

        LocalDate serviceDate =
        LocalDate.now().minusDays(
                30 + random.nextInt(180)
        );

        ServiceRecord record = new ServiceRecord();

        record.setVehicle(vehicle);

        record.setServiceDate(serviceDate);

        record.setServiceType(
                services[random.nextInt(services.length)]
        );

        record.setOdometerReading(
                10000 + random.nextInt(100000)
        );

        record.setServiceCost(
                2000.0 + random.nextInt(20000)
        );

        record.setNextServiceDueDate(
                serviceDate.plusMonths(3)
        );

        return record;
    }
}