package com.sapient.controller;

import com.sapient.model.Show;
import com.sapient.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping
    public ResponseEntity<Show> addShow(@RequestBody Show show) {
        Show addedShow = showService.addShow(show);
        return new ResponseEntity<>(addedShow, HttpStatus.CREATED);
    }

    // Add more controller methods as needed

}
