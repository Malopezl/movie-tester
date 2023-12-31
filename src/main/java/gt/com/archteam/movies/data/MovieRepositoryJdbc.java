package gt.com.archteam.movies.data;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import gt.com.archteam.movies.model.Genre;
import gt.com.archteam.movies.model.Movie;

public class MovieRepositoryJdbc implements MovieRepository {
    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", movieMapper, id);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies(name, minutes, genre, director) VALUES (?, ?, ?, ?)", movie.getName(),
                movie.getMinutes(), movie.getGenre().toString(), movie.getDirector());
    }

    private static RowMapper<Movie> movieMapper = (rs, rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre")),
            rs.getString("director"));

    public Collection<Movie> findByName(String movieName) {
        return this.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(movieName.toLowerCase()))
                .collect(Collectors.toList());
    }

}
