package com.sapient.repository;

import com.sapient.model.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieTicketRepository extends JpaRepository<MovieTicket, Long> {

    // You can define custom queries if needed

    // Example of a custom query method (finding tickets by customer name)
    List<MovieTicket> findByCustomerName(String customerName);
}