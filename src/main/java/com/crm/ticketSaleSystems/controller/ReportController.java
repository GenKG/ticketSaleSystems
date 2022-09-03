package com.crm.ticketSaleSystems.controller;

import com.crm.ticketSaleSystems.model.DateRange;
import com.crm.ticketSaleSystems.service.report.ManageReportService;
import com.crm.ticketSaleSystems.util.ReportNameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                        ReportNameGenerator.reportNameGenerate("Отчет по событиям", LocalDate.now(), "xlsx"))
                .body(file);
    }

    @GetMapping(value = "test", produces = "application/xlsx")
    public ResponseEntity<byte[]> testBack(@RequestParam("firstDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate,
                                           @RequestParam("secondDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate) throws IOException {
        byte[] file = eventReport.create(fromDate, toDate);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment;filename=" +
                        ReportNameGenerator.reportNameGenerate("отчет по событиям", LocalDate.now(), "xlsx"))
                .body(file);
    }
}
