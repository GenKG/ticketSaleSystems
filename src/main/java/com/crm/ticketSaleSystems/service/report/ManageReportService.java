package com.crm.ticketSaleSystems.service.report;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public interface ManageReportService {
    byte[] create(Date dateAfter, Date dateBefore) throws IOException;

    void save(byte[] file);
}
