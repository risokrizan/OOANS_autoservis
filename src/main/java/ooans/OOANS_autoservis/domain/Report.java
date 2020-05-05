package ooans.OOANS_autoservis.domain;

public class Report {
    String state;
    ReportTypeEnum reportType;
    String printableData;

    public void setState(String state) {
        this.state = state;
    }

    public void setType(ReportTypeEnum reportType) {
        this.reportType = reportType;
    }

    public void setPrintableData(String reportData) {
        this.printableData = reportData;
    }
}
