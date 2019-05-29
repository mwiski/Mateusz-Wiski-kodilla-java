package com.kodilla.good.patterns.challenges;

import java.util.Collection;
import java.util.stream.Collectors;

public class MoviePrinter {

    private final MovieStore movieStore;

    public MoviePrinter(final MovieStore movieStore) {
        this.movieStore = movieStore;
    }

    public String print() {
        return movieStore.getMovies().values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining(" ! "));
    }
}
