package com.linnik.wickiup.solid.d.good;

import solid.d.bad.Report;

/**
 * @author LinnykOleh
 */
public class EmailReportSender implements IReportSender{

    @Override
    public void send(Report report){
        System.out.println(report);
    }
}
