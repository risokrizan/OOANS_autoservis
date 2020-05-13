package ooans.OOANS_autoservis.service.report;

import ooans.OOANS_autoservis.domain.ReportTypeEnum;

public class CreditNoteReportService extends BaseReportService {

    @Override
    public String selectDataByInput(String reportDataInput) {
        return "user:"  + reportDataInput + "; dobropisy: vratene peniaze za servis, reklamacia laku" ;
    }

    @Override
    public void doGenerateReport(String fileName, String reportData) {
        System.out.println("Generate report type" + getReportType() + "to file : " + fileName );
        System.out.println("Used CREDIT NOTE TEMPLATE");
        System.out.println("Data print to report " + reportData);
    }

    @Override
    public ReportTypeEnum getReportType() {
        return ReportTypeEnum.CREDIT_NOTE_REPORT;
    }
}
