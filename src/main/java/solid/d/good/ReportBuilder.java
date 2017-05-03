package solid.d.good;

import solid.d.bad.Report;

import java.util.Collections;
import java.util.List;

/**
 * @author LinnykOleh
 */
public class ReportBuilder implements IReportBuilder{

    @Override
    public List<Report> createReports(){
        return Collections.emptyList();
    }
}
