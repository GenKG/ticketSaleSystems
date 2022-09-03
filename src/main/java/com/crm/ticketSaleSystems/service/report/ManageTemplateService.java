package com.crm.ticketSaleSystems.service.report;

import com.haulmont.yarg.structure.ReportOutputType;
import com.haulmont.yarg.structure.impl.ReportTemplateBuilder;

import java.io.IOException;

public interface ManageTemplateService {
    ReportTemplateBuilder create(String docName, ReportOutputType outputType) throws IOException;
}
