package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.InterestingMoment;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        //First we define the condition to use on filter
        Predicate<InterestingMoment> isMiddle = (interestingMoment) -> interestingMoment.getType().equals("Middle");

        return ImmutableList.copyOf(movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(movie -> {return ImmutableMap.of(
                        "id",
                        movie.getId().toString(),
                        "title",
                        movie.getTitle().toString(),
                        "time",
                        movie.getInterestingMoments().stream()
                                .filter(im -> isMiddle.test(im))
                                .collect(Collectors.toUnmodifiableList()).get(0).getTime(),
                        "url",
                        movie.getBoxarts().stream()
                                .reduce(((boxArt1, boxArt2) ->
                                        (boxArt1.getHeight()*boxArt1.getWidth()) < (boxArt2.getHeight()*boxArt2.getWidth()) ?
                                                boxArt1 :
                                                boxArt2)).get()
                                .getUrl());}).collect(Collectors.toUnmodifiableList()));
    }
}
