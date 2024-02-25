package com.sapient.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDate date;
    private LocalTime startTime;

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

}