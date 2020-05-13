package ooans.OOANS_autoservis.service.factory;

import ooans.OOANS_autoservis.domain.ReportTypeEnum;
import ooans.OOANS_autoservis.service.report.*;

import java.util.ArrayList;
import java.util.List;

public class ReportFactory {

    List<ReportService> reportServices;

    public void initReportServices() {
        reportServices = new ArrayList<>();
        reportServices.add(new CreditNoteReportService());
        reportServices.add(new CustomerCarServiceStatisticsReportService());
        reportServices.add(new CustomerInvoiceServiceReportService());
        reportServices.add(new UsedPartStatisticReportService());
    }

    public ReportService getReportService(ReportTypeEnum repotTypeEnum) throws Exception {
        for (ReportService rs: reportServices) {
            if(rs.getReportType() == repotTypeEnum) {
                return rs;
            }
        }
        throw new Exception("Report service type not exist");
    }
}
