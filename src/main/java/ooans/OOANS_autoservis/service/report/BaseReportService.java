package ooans.OOANS_autoservis.service.report;

import ooans.OOANS_autoservis.dao.ReportDao;
import ooans.OOANS_autoservis.domain.Report;

import java.io.File;

public abstract class BaseReportService implements  ReportService{

    private ReportDao reportDao;
    public BaseReportService(){
        this.reportDao = new ReportDao();
    }

    public void generateReport(Report r, String fileName, String reportDataInput){
        try {
            this.reportDao.process(r);
            System.out.println(r.toString());

            String reportData = selectDataByInput(reportDataInput);
            r.setPrintableData(reportData);

            doGenerateReport(fileName, reportData);

            this.reportDao.success(r);
            System.out.println(r.toString());
        }
        catch (Exception e){
            this.reportDao.fail(r);
            System.out.println(r.toString());
        }
    }

    public abstract String selectDataByInput(String reportDataInput);
    public abstract void doGenerateReport(String fileName, String reportData);
}
