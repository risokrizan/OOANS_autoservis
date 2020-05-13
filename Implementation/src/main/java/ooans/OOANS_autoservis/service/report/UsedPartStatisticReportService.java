package ooans.OOANS_autoservis.service.report;

import ooans.OOANS_autoservis.domain.ReportTypeEnum;

public class UsedPartStatisticReportService extends BaseReportService {
    @Override
    public String selectDataByInput(String reportDataInput) {
        return "user:"  + reportDataInput + "; diely: [{1.5.209, olej - VWe12/f, vzduchovy filter - VW765, palivovy filter - VW321}, {17.9.2017, brzdove platnicky - EBC, brzdrove kotuce - EBC} ] " ;
    }

    @Override
    public void doGenerateReport(String fileName, String reportData) {
        System.out.println("Generate report type" + getReportType() + "to file : " + fileName );
        System.out.println("Used SPARE PART STATISTIC TEMPLATE");
        System.out.println("Data print to report " + reportData);
    }

    @Override
    public ReportTypeEnum getReportType() {
        return ReportTypeEnum.PARTS_STATISTICS_REPORT;
    }
}
