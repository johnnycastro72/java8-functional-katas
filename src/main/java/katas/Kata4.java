package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        //First we define the condition to use on filter
        Predicate<BoxArt> is150200 = (boxArt) -> boxArt.getWidth().equals(150)
                && boxArt.getHeight().equals(200);

        return ImmutableList.copyOf((movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(movie -> {return ImmutableMap.of(
                        "id", movie.getId(),
                        "title", movie.getTitle(),
                        "boxart", new BoxArt(150, 200, movie.getBoxarts()
                                .stream().filter(ba -> is150200.test(ba))
                                .map(boxArt -> boxArt.getUrl()).collect(Collectors.toUnmodifiableList()).get(0)));})
                .collect(Collectors.toUnmodifiableList())));
    }
}
