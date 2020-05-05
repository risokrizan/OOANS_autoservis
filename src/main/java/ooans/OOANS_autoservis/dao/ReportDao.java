package ooans.OOANS_autoservis.dao;

import ooans.OOANS_autoservis.domain.Report;

public class ReportDao {
    public void process(Report r) {
        r.setState("PROCES");
    }

    public void success(Report r) {
        r.setState("SUCCES");
    }

    public void fail(Report r) {
        r.setState("FAIL");
    }
}
