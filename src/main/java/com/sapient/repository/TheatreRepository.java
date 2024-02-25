package com.sapient.repository;

import com.sapient.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    List<Theatre> findByShowsMovieNameAndLocation(String movieName, String location);
}
