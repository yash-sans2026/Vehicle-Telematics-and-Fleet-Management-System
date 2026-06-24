package com.example.fleet_management_system.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SafetyViewController {

    @GetMapping("/safety/dashboard")
    public String dashboard() {
        return "safety/dashboard";
    }
}
