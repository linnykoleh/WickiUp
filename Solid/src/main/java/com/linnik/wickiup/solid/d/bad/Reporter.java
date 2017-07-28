package com.linnik.wickiup.solid.d.bad;

import java.util.List;

/**
 * @author LinnykOleh
 */
public class Reporter {

    public void sendReports() {
        final ReportBuilder reportBuilder = new ReportBuilder();
        final List<Report> reports = reportBuilder.createReports();

        final EmailReportSender reportSender = new EmailReportSender();

        for(Report report : reports) {
            reportSender.send(report);
        }
    }
}
