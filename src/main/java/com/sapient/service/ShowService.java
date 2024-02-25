package com.sapient.service;

import com.sapient.model.Show;
import com.sapient.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public Show addShow(Show show) {
        // Perform any necessary validation or business logic before adding
        return showRepository.save(show);
    }

    // Add more service methods as needed

}
