package patterns._2_structural._2_bridge.formatters;

import patterns._2_structural._2_bridge.Detail;

import java.util.List;

/**
 * @author LinnykOleh
 */
public interface Formatter {

    String format(String header, List<Detail> details);
}
