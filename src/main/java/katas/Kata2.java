package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();
        //First we define the condition to use on filter
        Predicate<Movie> isRating5 = (movie) -> movie.getRating().equals(5.0);

        return ImmutableList.copyOf(movies.stream().filter(m -> isRating5.test(m))
                .map(movie -> movie.getId()).collect(Collectors.toUnmodifiableList()));
    }

}
