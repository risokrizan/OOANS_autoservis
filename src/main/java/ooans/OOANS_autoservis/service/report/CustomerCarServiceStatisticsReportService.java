package ooans.OOANS_autoservis.service.report;

import ooans.OOANS_autoservis.domain.ReportTypeEnum;

public class CustomerCarServiceStatisticsReportService extends  BaseReportService {
    @Override
    public String selectDataByInput(String reportDataInput) {
        return "user:"  + reportDataInput + "; servisy: [{1.5.209, audi, vymena oleja, filtrov}, {17.9.2017, audi, vymena brzdnych kotucov a platniciek} ] " ;
    }

    @Override
    public void doGenerateReport(String fileName, String reportData) {
        System.out.println("Generate report type" + getReportType() + "to file : " + fileName );
        System.out.println("Used CUSTOMER SERVICES STATISTICS TEMPLATE");
        System.out.println("Data print to report " + reportData);
    }


    @Override
    public ReportTypeEnum getReportType() {
        return ReportTypeEnum.CUSTOMER_CAR_SERVIS_STATISTIC_REPORT;
    }
}
