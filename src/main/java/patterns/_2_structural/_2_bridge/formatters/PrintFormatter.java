package patterns._2_structural._2_bridge.formatters;

import patterns._2_structural._2_bridge.Detail;

import java.util.List;

/**
 * @author LinnykOleh
 */
public class PrintFormatter implements Formatter{

    @Override
    public String format(String header, List<Detail> details) {
        final StringBuilder builder = new StringBuilder();

        builder.append(header);
        builder.append("\n");
        for(Detail detail : details){
            builder.append(detail.getLabel());
            builder.append(":");
            builder.append(detail.getValue());
            builder.append("\n");
        }

        return builder.toString();
    }
}
