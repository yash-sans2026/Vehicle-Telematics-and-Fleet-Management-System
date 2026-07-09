package com.example.fleet_management_system.service;

import com.example.fleet_management_system.entity.ServiceRecord;
import com.example.fleet_management_system.repository.ServiceRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceServiceTest {

    @Mock
    private ServiceRecordRepository serviceRecordRepository;

    @InjectMocks
    private VehicleServiceService vehicleServiceService;

    private ServiceRecord record1;
    private ServiceRecord record2;


    @BeforeEach
    void setUp() {
        record1 = new ServiceRecord();
        record1.setServiceRecordId(1);
        record1.setServiceDate(LocalDate.of(2024, 1, 10));
        record1.setServiceType("Oil Change");
        record1.setServiceCost(1500.0);
        record1.setNextServiceDueDate(LocalDate.of(2024, 7, 10));

        record2 = new ServiceRecord();
        record2.setServiceRecordId(2);
        record2.setServiceDate(LocalDate.of(2024, 2, 15));
        record2.setServiceType("Brake Service");
        record2.setServiceCost(2500.0);
        record2.setNextServiceDueDate(null);
    }


    @Test
    void testGetAllServiceRecords() {
        List<ServiceRecord> records = Arrays.asList(record1, record2);
        when(serviceRecordRepository.findAll()).thenReturn(records);
        List<ServiceRecord> result = vehicleServiceService.getAllServiceRecords();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(records, result);
    }


    @Test
    void testGetTotalServices() {
        when(serviceRecordRepository.count()).thenReturn(2L);
        long result = vehicleServiceService.getTotalServices();
        assertEquals(2L, result);
    }


    @Test
    void testGetTotalMaintenanceCost() {
        List<ServiceRecord> records = Arrays.asList(record1, record2);
        when(serviceRecordRepository.findAll()).thenReturn(records);
        double result = vehicleServiceService.getTotalMaintenanceCost();
        assertEquals(4000.0, result);
    }


    @Test
    void testGetUpcomingServices() {
        List<ServiceRecord> records = Arrays.asList(record1, record2);
        when(serviceRecordRepository.findAll()).thenReturn(records);
        List<ServiceRecord> result = vehicleServiceService.getUpcomingServices();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(record1, result.get(0));
    }

}
