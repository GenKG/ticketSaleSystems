package com.crm.ticketSaleSystems.service.report;

import com.haulmont.yarg.structure.ReportOutputType;
import com.haulmont.yarg.structure.impl.ReportTemplateBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class DefaultManageTemplate implements ManageTemplateService {
    @Value("${report.template.path}")
    private String templatePath;

    @Override
    public ReportTemplateBuilder create(String docName, ReportOutputType outputType) throws IOException {
        return new ReportTemplateBuilder()
                .documentContent(getClass().getResourceAsStream(templatePath + docName))
                .documentName(docName)
                .outputType(outputType)
                .documentPath("/");
    }
}
