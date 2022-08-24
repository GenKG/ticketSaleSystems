package com.crm.ticketSaleSystems.controller;

import com.crm.ticketSaleSystems.model.DateRange;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @GetMapping
    public String reportPage(Model model) {
        DateRange range = new DateRange();
        range.setDateFrom(new Date());
        range.setDateTo(new Date());
        model.addAttribute("dateRange", range);
        return "report";
    }

    @PostMapping
    public String saveData(DateRange dateRange, Model model) {
        model.addAttribute("dateRange", dateRange);
        return "saved";
    }
}
