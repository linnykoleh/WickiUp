package solid.d.good;

import solid.d.bad.Report;

import java.util.List;

/**
 * @author LinnykOleh
 */
public class Reporter {

    private IReportSender reportSender;
    private IReportBuilder reportBuilder;

    public Reporter(IReportSender reportSender, IReportBuilder reportBuilder) {
        this.reportSender = reportSender;
        this.reportBuilder = reportBuilder;
    }

    public void sendReports() {
        final List<Report> reports = reportBuilder.createReports();

        for(Report report : reports) {
            reportSender.send(report);
        }
    }
}
