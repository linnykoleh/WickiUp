package com.linnik.wickiup.patterns._2_structural._2_bridge;

import com.linnik.wickiup.patterns._2_structural._2_bridge.formatters.Formatter;
import com.linnik.wickiup.patterns._2_structural._2_bridge.formatters.HTMLFormatter;
import com.linnik.wickiup.patterns._2_structural._2_bridge.formatters.PrintFormatter;

/**
 * @author LinnykOleh
 */
public class Demo {

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setClassification("Action");
        movie.setTitle("John Wick");
        movie.setRuntime("2:15");
        movie.setYear("2014");

        final Formatter formatter = new PrintFormatter();
        final Printer moviePrinter = new MoviePrinter(movie);

        final String printedMaterial = moviePrinter.print(formatter);
        System.out.println(printedMaterial);

        final Formatter htmlFormatter = new HTMLFormatter();
        final String htmlMaterial = moviePrinter.print(htmlFormatter);
        System.out.println(htmlMaterial);
    }
}
