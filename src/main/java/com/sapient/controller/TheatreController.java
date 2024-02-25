package com.sapient.controller;

import com.sapient.model.Theatre;
import com.sapient.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        List<Theatre> theatres = theatreService.getAllTheatres();
        return new ResponseEntity<>(theatres, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre) {
        Theatre addedTheatre = theatreService.addTheatre(theatre);
        return new ResponseEntity<>(addedTheatre, HttpStatus.CREATED);
    }

    // Add more controller methods as needed

}