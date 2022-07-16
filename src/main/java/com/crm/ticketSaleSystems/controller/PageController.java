package com.crm.ticketSaleSystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/reports")
    public String reportPage() {
        return "report";
    }

    @RequestMapping("/orders")
    public String ordersPage() {
        return "orders";
    }


}
