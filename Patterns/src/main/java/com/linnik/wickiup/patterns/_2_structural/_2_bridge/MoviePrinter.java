package com.linnik.wickiup.patterns._2_structural._2_bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinnykOleh
 */
public class MoviePrinter extends Printer {

    private Movie movie;

    public MoviePrinter(Movie movie) {
        this.movie = movie;
    }

    @Override
    public List<Detail> getDetails() {
        final List<Detail> details = new ArrayList<>();

        details.add(new Detail("Title", movie.getTitle()));
        details.add(new Detail("Year", movie.getYear()));
        details.add(new Detail("Runtime", movie.getRuntime()));

        return details;
    }

    @Override
    public String getHeader() {
        return movie.getClassification();
    }
}
