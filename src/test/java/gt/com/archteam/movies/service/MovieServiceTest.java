package gt.com.archteam.movies.service;

import static org.hamcrest.MatcherAssert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import gt.com.archteam.movies.data.MovieRepository;
import gt.com.archteam.movies.model.Genre;
import gt.com.archteam.movies.model.Movie;

public class MovieServiceTest {
    private MovieService movieService;

    @Before
    public void setUp() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Director 1"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Director 2"),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY, "Director 3"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "Director 4"),
                        new Movie(5, "Scream", 111, Genre.HORROR, "Director 5"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, "Director 6"),
                        new Movie(7, "Matrix", 136, Genre.ACTION, "Director 7")));

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3, 6)));
    }

    @Test
    public void return_movies_by_duration() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}
