package com.linnik.wickiup.patterns._2_structural._2_bridge.formatters;

import java.util.List;

import com.linnik.wickiup.patterns._2_structural._2_bridge.Detail;

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
