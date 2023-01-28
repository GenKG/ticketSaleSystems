package com.crm.ticketSaleSystems.service.report;

import com.haulmont.yarg.formatters.factory.DefaultFormatterFactory;
import com.haulmont.yarg.loaders.factory.DefaultLoaderFactory;
import com.haulmont.yarg.loaders.impl.SqlDataLoader;
import com.haulmont.yarg.reporting.Reporting;
import com.haulmont.yarg.reporting.RunParams;
import com.haulmont.yarg.structure.Report;
import com.haulmont.yarg.structure.ReportBand;
import com.haulmont.yarg.structure.ReportOutputType;
import com.haulmont.yarg.structure.impl.BandBuilder;
import com.haulmont.yarg.structure.impl.ReportBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@Service
@Qualifier("eventManageReport")
public class EventManageReport implements ManageReportService {
    private static final String EVENTS_SQL_SCRIPT =
            "SELECT e.event_name,\n" +
                    "       e.event_date         AS event_date,\n" +
                    "       e.venue              AS venue,\n" +
                    "       e.venue_address      AS venue_address,\n" +
                    "       count(t.id)          AS ticket_count,\n" +
                    "       sum(t.sum)           AS tickets_sum,\n" +
                    "       count(DISTINCT o.id) AS order_count\n" +
                    "FROM events AS e\n" +
                    "         JOIN tickets t on e.id = t.event_id\n" +
                    "         JOIN orders o on t.order_id = o.id\n" +
                    "WHERE e.event_date between ${dateBefore} AND ${dateAfter}\n" +
                    "GROUP BY e.event_name,\n" +
                    "         e.event_date,\n" +
                    "         e.venue,\n" +
                    "         e.venue_address";
    private final DataSource dataSource;
    private final ManageTemplateService templateService;
    @Value("${report.path.report}")
    private String reportPath;

    public EventManageReport(DataSource dataSource, ManageTemplateService manageTemplateService) {
        this.dataSource = dataSource;
        this.templateService = manageTemplateService;
    }

    private void initDirectory() {
        File path = new File(reportPath);
        if (!path.exists()) path.mkdirs();
    }


    @Override
    public byte[] create(Date dateAfter, Date dateBefore) throws IOException {
        initDirectory();
        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.template(templateService.create("eventsTemplate.xlsx", ReportOutputType.xlsx).build());
        BandBuilder bandBuilder = new BandBuilder();
        ReportBand result = bandBuilder.name("EventReport")
                .query("EventReport", EVENTS_SQL_SCRIPT, "sql")
                .build();
        Report report = reportBuilder
                .band(new BandBuilder().name("header").build())
                .band(result).build();
        Reporting reporting = new Reporting();
        reporting.setFormatterFactory(new DefaultFormatterFactory());
        reporting.setLoaderFactory(new DefaultLoaderFactory().setSqlDataLoader(new SqlDataLoader(dataSource)));
        return reporting.runReport(
                new RunParams(report)
                        .param("dateAfter", new Timestamp(dateAfter.getTime()))
                        .param("dateBefore", new Timestamp(dateBefore.getTime())))
                .getContent();
    }

    @Override
    public void save(byte[] file) {

    }
}
