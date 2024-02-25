package com.sapient.service;

import com.sapient.model.MovieTicket;
import com.sapient.model.Show;
import com.sapient.repository.MovieTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private MovieTicketRepository movieTicketRepository;

    public MovieTicket bookTicket(Long showId, String customerName, int numberOfTickets) {
        // Assuming there's a Show entity with a 'id' attribute
        Show show = getShowById(showId);

        // Assuming there's a MovieTicket entity with a 'show' attribute and a 'customerName' attribute
        MovieTicket movieTicket = new MovieTicket();
        movieTicket.setShow(show);
        movieTicket.setCustomerName(customerName);

        // Apply discount for every third ticket
        if (numberOfTickets % 3 == 0) {
            movieTicket.setTicketPrice(movieTicket.getTicketPrice() * 0.5); // 50% discount
        }

        // Apply discount for tickets booked for afternoon shows
        if (show != null && isAfternoonShow(show.getStartTime())) {
            movieTicket.setTicketPrice(movieTicket.getTicketPrice() * 0.8); // 20% discount
        }

        return movieTicketRepository.save(movieTicket);
    }

    private Show getShowById(Long showId) {
        // Implement logic to retrieve a Show by its ID
        // You may need a ShowRepository for this
        return null;
    }

    private boolean isAfternoonShow(LocalTime startTime) {
        // Implement logic to check if the show is in the afternoon
        // You may define a threshold for afternoon shows
        return startTime.isAfter(LocalTime.NOON);
    }

    // Add more service methods as needed

}