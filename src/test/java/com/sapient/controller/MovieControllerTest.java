package com.sapient.controller;

import com.sapient.model.Movie;
import com.sapient.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void testAddMovie() throws Exception {
        Movie movie = new Movie();
        movie.setName("Test Movie");
        movie.setLanguage("English");
        movie.setGenre("Action");

        when(movieService.addMovie(any(Movie.class))).thenReturn(movie);

        mockMvc.perform(MockMvcRequestBuilders.post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test Movie\",\"language\":\"English\",\"genre\":\"Action\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // Add more test cases for other controller methods as needed

}