package com.sapient.service;

import com.sapient.model.Movie;
import com.sapient.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void testAddMovie() {
        Movie movie = new Movie();
        movie.setName("Test Movie");
        movie.setLanguage("English");
        movie.setGenre("Action");

        when(movieRepository.save(movie)).thenReturn(movie);

        Movie savedMovie = movieService.addMovie(movie);

        assertEquals(movie.getName(), savedMovie.getName());
        assertEquals(movie.getLanguage(), savedMovie.getLanguage());
        assertEquals(movie.getGenre(), savedMovie.getGenre());
    }

    // Add more test cases for other service methods as needed

}
