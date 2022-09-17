package com.crm.ticketSaleSystems.controller;

import com.crm.ticketSaleSystems.model.DateRange;
import com.crm.ticketSaleSystems.service.report.ManageReportService;
import com.crm.ticketSaleSystems.util.ReportNameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/reports")
public class ReportController {
    private final ManageReportService eventReport;

    @Autowired
    public ReportController(ManageReportService eventReport) {
        this.eventReport = eventReport;
    }

    @GetMapping
    public String reportPage(Model model) {
        DateRange range = new DateRange();
        range.setDateFrom(new Date());
        range.setDateTo(new Date());
        model.addAttribute("dateRange", range);
        return "report";
    }
    @PostMapping(produces = "application/xlsx")
    public ResponseEntity<byte[]> getEventReport(DateRange dateRange, Model model) throws IOException {
        model.addAttribute("dateRange", dateRange);
        byte[] file = eventReport.create(dateRange.getDateTo(), dateRange.getDateFrom());
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment;filename=" +
                        ReportNameGenerator.reportNameGenerate("Event-report", LocalDate.now(), "xlsx"))
                .body(file);
    }
}
