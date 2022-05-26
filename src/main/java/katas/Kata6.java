package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        return movies.stream().map(movie -> movie.getBoxarts())
                .map(boxArt -> boxArt.stream().reduce(((boxArt1, boxArt2) ->
                        (boxArt1.getHeight()*boxArt1.getWidth()) > (boxArt2.getHeight()*boxArt2.getWidth()) ?
                                boxArt1 :
                                boxArt2)))
                .map(boxArt -> boxArt.get().getUrl())
                .collect(Collectors.toUnmodifiableList()).get(movies.size()-1);
    }
}
