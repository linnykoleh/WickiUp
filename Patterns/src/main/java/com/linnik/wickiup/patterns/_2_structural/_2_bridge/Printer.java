package com.linnik.wickiup.patterns._2_structural._2_bridge;

import java.util.List;

import com.linnik.wickiup.patterns._2_structural._2_bridge.formatters.Formatter;

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
