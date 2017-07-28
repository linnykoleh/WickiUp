package com.linnik.wickiup.patterns._2_structural._2_bridge.formatters;

import java.util.List;

import com.linnik.wickiup.patterns._2_structural._2_bridge.Detail;

/**
 * @author LinnykOleh
 */
public interface Formatter {

    String format(String header, List<Detail> details);
}
