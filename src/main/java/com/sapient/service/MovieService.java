package com.sapient.service;

import com.sapient.model.Movie;
import com.sapient.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        // Perform any necessary validation or business logic before adding
        return movieRepository.save(movie);
    }

    // Add more service methods as needed

}
