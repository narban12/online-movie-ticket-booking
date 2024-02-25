package com.sapient.service;


import com.sapient.model.Show;
import com.sapient.model.Theatre;
import com.sapient.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public List<Theatre> getTheatresByMovieAndTown(String movieName, String town) {
        // Assuming there's a Movie entity with a 'name' attribute
        // and a Show entity with a 'movie' attribute
        return theatreRepository.findByShowsMovieNameAndLocation(movieName, town);
    }

    public List<Show> getShowTimingsByTheatreAndDate(Long theatreId, String chosenDate) {
        // Assuming there's a Show entity with a 'theatre' attribute and a 'date' attribute
        return theatreRepository.findById(theatreId)
                .map(theatre -> theatre.getShows()
                        .stream()
                        .filter(show -> show.getDate().equals(chosenDate))
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new RuntimeException("Theatre not found"));
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Optional<Theatre> getTheatreById(Long theatreId) {
        return theatreRepository.findById(theatreId);
    }

    public Theatre addTheatre(Theatre theatre) {
        // Perform any necessary validation or business logic before saving
        return theatreRepository.save(theatre);
    }

    public Theatre updateTheatre(Long theatreId, Theatre updatedTheatre) {
        Optional<Theatre> existingTheatre = theatreRepository.findById(theatreId);
        if (existingTheatre.isPresent()) {
            // Perform any necessary validation or business logic before updating
            Theatre savedTheatre = theatreRepository.save(updatedTheatre);
            return savedTheatre;
        } else {
            // Handle case where theatre with given ID is not found
            return null;
        }
    }

    public void deleteTheatre(Long theatreId) {
        theatreRepository.deleteById(theatreId);
    }


}
