package com.crm.ticketSaleSystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/reports")
    public String reportPage() {
        return "report";
    }

    @GetMapping("/orders")
    public String ordersPage() {
        return "orders";
    }


}
