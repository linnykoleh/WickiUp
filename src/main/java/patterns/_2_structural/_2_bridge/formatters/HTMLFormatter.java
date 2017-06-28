package patterns._2_structural._2_bridge.formatters;

import patterns._2_structural._2_bridge.Detail;

import java.util.List;

/**
 * @author LinnykOleh
 */
public class HTMLFormatter implements Formatter {

    @Override
    public String format(String header, List<Detail> details) {
        final StringBuilder builder = new StringBuilder();

        builder.append("<table>");
        builder.append("<th>");
        builder.append("Classification");
        builder.append("</th>");
        builder.append("<th>");
        builder.append(header);
        builder.append("</th>");

        for(Detail detail : details){
            builder.append("<tr><td>");
            builder.append("</th>");
            builder.append(detail.getLabel());
            builder.append("</tr><td>");
            builder.append(detail.getValue());
            builder.append("</td><tr>");
        }
        builder.append("</table>");

        return builder.toString();
    }
}
