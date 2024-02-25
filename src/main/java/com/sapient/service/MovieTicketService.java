package com.sapient.service;

import com.sapient.model.MovieTicket;
import com.sapient.repository.MovieTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieTicketService {

    @Autowired
    private MovieTicketRepository movieTicketRepository;

    public MovieTicket bookTicket(MovieTicket movieTicket) {
        // Perform any necessary validation or business logic before booking
        return movieTicketRepository.save(movieTicket);
    }

    // Add more service methods as needed

}
