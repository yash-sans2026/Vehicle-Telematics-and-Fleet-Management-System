package com.example.fleet_management_system.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/driver")
public class DriverViewController {
    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "driver/dashboard";
    }
    
}
