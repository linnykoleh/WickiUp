package edu.jpa.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
public class BlogUtils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    public static Date convertStringToDate(final String source) {
        try {
            return DATE_FORMAT.parse(source);
        } catch (final ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertDateString(final Date source) {
        return DATE_FORMAT.format(source);
    }
}
