package gt.com.archteam.movies.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
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

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        List<Predicate<Movie>> filters = new ArrayList<>();

        if (template.getId() != null) {
            Movie movie = movieRepository.findById(template.getId());
            return movie != null ? Collections.singletonList(movie) : new ArrayList<>();
        }
        if (template.getMinutes() < 0) {
            throw new IllegalArgumentException("Movie duration must be greater or equals than zero");
        }
        if (template.getName() != null) {
            filters.add(movie -> movie.getName().toLowerCase().contains(template.getName().toLowerCase()));
        }
        if (template.getMinutes() != null) {
            filters.add(movie -> movie.getMinutes() <= template.getMinutes());
        }
        if (template.getGenre() != null) {
            filters.add(movie -> movie.getGenre().equals(template.getGenre()));
        }
        if (template.getDirector() != null) {
            filters.add(movie -> movie.getDirector().toLowerCase().contains(template.getDirector().toLowerCase()));
        }
        return movieRepository.findAll().stream()
                .filter(movie -> filters.stream().allMatch(filter -> filter.test(movie))).collect(Collectors.toList());
    }

}
