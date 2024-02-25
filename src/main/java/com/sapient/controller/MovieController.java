package com.sapient.controller;

import com.sapient.model.Movie;
import com.sapient.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie addedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
    }

    // Add more controller methods as needed

}
