package io.codewithgx.functional.programming.playing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 18/09/2022
 */

public class ListFunctionalOperation {
    public static void main(String[] args) {
        List<Movie> movieList = new ArrayList<>() {{
            add(Movie.of("Spotlight", 2015, "HollyWood"));
            add(Movie.of("Avengers: Infinity Wars", 2018, "HollyWood"));
            add(Movie.of("Inception", 2010, "HollyWood"));
            add(Movie.of("Forest Gump", 1994, "HollyWood"));
            add(Movie.of("3 Idiots", 2009, "BollyWood"));
            add(Movie.of("Beauty and The beast", 2017, "HollyWood"));
            add(Movie.of("Slumdog Millionaire", 2008, "BollyWood"));
        }};

        //Transversal
        System.out.println("-----------------------------Transversal------");
        movieList.forEach(System.out::println);

        //Sort
        System.out.println("-----------------------------Sort------");
        List<Movie> mutatedList = new ArrayList<>() {{
            addAll(movieList);
        }};
        mutatedList.sort(Comparator.comparingInt(Movie::getReleaseYear).reversed());
        mutatedList.forEach(System.out::println);

        //Mapping
        movieList.stream()
                .map(Movie::getName)
                .forEach(System.out::println);

        movieList.stream()
                .sorted(Comparator.comparingInt(Movie :: getReleaseYear).reversed())
                .map(Movie ::getName)
                .reduce((m1, m2) -> m1 + " | " + m2)
                .ifPresent(System.out::println);
    }
}
