package ooans.OOANS_autoservis.service.report;

import ooans.OOANS_autoservis.domain.Report;
import ooans.OOANS_autoservis.domain.ReportTypeEnum;

import java.io.File;

public interface ReportService {
    void generateReport(Report r, String fileName, String reportDataInput);
    ReportTypeEnum getReportType();
}
