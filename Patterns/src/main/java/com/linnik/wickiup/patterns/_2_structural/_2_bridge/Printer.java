package com.linnik.wickiup.patterns._2_structural._2_bridge;

import patterns._2_structural._2_bridge.formatters.Formatter;

import java.util.List;

/**
 * @author LinnykOleh
 */
public abstract class Printer {

    public String print(Formatter formatter){
        return formatter.format(getHeader(), getDetails());
    }

    public abstract List<Detail> getDetails();

    public abstract String getHeader();

}
