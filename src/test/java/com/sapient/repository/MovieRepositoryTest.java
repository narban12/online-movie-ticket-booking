package com.sapient.repository;

import com.sapient.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testSaveMovie() {
        Movie movie = new Movie();
        movie.setName("Test Movie");
        movie.setLanguage("English");
        movie.setGenre("Action");

        Movie savedMovie = movieRepository.save(movie);

        assertEquals(movie.getName(), savedMovie.getName());
        assertEquals(movie.getLanguage(), savedMovie.getLanguage());
        assertEquals(movie.getGenre(), savedMovie.getGenre());
    }

    // Add more test cases for other repository methods as needed

}
