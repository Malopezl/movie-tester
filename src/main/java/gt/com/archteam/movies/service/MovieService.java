package gt.com.archteam.movies.service;

import java.util.Collection;
import java.util.stream.Collectors;

import gt.com.archteam.movies.data.MovieRepository;
import gt.com.archteam.movies.model.Genre;
import gt.com.archteam.movies.model.Movie;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre)
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= length)
                .collect(Collectors.toList());
    }

}
