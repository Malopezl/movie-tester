package gt.com.archteam.movies.data;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import gt.com.archteam.movies.model.Genre;
import gt.com.archteam.movies.model.Movie;

public class MovieRepositoryIntegrationTest {
    private MovieRepositoryJdbc movieRepository;
    private DataSource dataSource;

    @Before
    public void setUp() throws ScriptException, SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL",
                "test", "test");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() {
        Collection<Movie> movies = movieRepository.findAll();
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Director 1"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Director 2"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "Director 3"),
                new Movie(4, "Super 8", 112, Genre.THRILLER, "Director 4"),
                new Movie(5, "Superman", 135, Genre.ACTION, "Director 5"))));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER, "Director 2")));
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie("Movie 25", 110, Genre.THRILLER, "Director 6");
        movieRepository.saveOrUpdate(movie);
        Movie movieInserted = movieRepository.findById(6);
        assertThat(movieInserted, is(new Movie(6, "Movie 25", 110, Genre.THRILLER, "Director 6")));
    }

    @Test
    public void load_movie_by_name() {
        Collection<Movie> movies = movieRepository.findByName("Super");
        assertThat(movies, is(Arrays.asList(
                new Movie(4, "Super 8", 112, Genre.THRILLER, "Director 4"),
                new Movie(5, "Superman", 135, Genre.ACTION, "Director 5"))));
    }

    @After
    public void tearDown() throws SQLException {
        /* Remove H2 files -- https://stackoverflow.com/a/51809831/1121497 */
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}
