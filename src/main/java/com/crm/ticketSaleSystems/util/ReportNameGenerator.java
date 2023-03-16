package com.crm.ticketSaleSystems.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ReportNameGenerator {
    private ReportNameGenerator() {
    }

    public static String reportNameGenerate(String baseName, LocalDate reportDate, String extensionType) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        StringBuilder builder = new StringBuilder();
        StringBuilder append = builder
                .append(baseName)
                .append("-")
                .append(reportDate.format(formatter))
                .append(".")
                .append(extensionType);
        return append.toString();
    }
}
