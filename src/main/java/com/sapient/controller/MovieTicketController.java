package com.sapient.controller;

import com.sapient.model.MovieTicket;
import com.sapient.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class MovieTicketController {

    @Autowired
    private MovieTicketService movieTicketService;

    @PostMapping
    public ResponseEntity<MovieTicket> bookTicket(@RequestBody MovieTicket movieTicket) {
        MovieTicket bookedTicket = movieTicketService.bookTicket(movieTicket);
        return new ResponseEntity<>(bookedTicket, HttpStatus.CREATED);
    }

    // Add more controller methods as needed

}