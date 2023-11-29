package gt.com.archteam.movies.data;

import java.util.Collection;

import gt.com.archteam.movies.model.Movie;

public interface MovieRepository {

    Movie findById(long id);

    Collection<Movie> findAll();

    void saveOrUpdate(Movie movie);

}
