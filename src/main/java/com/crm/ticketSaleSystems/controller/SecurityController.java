package com.crm.ticketSaleSystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/register")
    public String getLoginPage() {
        return "redirect:/home";
    }
}
