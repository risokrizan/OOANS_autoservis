package ooans.OOANS_autoservis.service.report;

import ooans.OOANS_autoservis.domain.ReportTypeEnum;

public class CustomerInvoiceServiceReportService extends BaseReportService {
    @Override
    public String selectDataByInput(String reportDataInput) {
        return "user:"  + reportDataInput + "; faktury: [{1.5.209, 50eur}, {17.9.2017, 120eur} ] " ;
    }

    @Override
    public void doGenerateReport(String fileName, String reportData) {
        System.out.println("Generate report type" + getReportType() + "to file : " + fileName );
        System.out.println("Used INVOICE TEMPLATE");
        System.out.println("Data print to report " + reportData);
    }

    @Override
    public ReportTypeEnum getReportType() {
        return ReportTypeEnum.INVOICE_REPORT;
    }
}
