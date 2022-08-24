package com.crm.ticketSaleSystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }



    @GetMapping("/orders")
    public String ordersPage() {
        return "orders";
    }


}
