package com.example.fleet_management_system.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuelLogViewController {
    @GetMapping("/analyst/dashboard")
    public String dashboard() {
        return "analyst/dashboard";
    }
}
