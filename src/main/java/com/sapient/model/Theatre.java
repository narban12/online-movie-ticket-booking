package com.sapient.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Theatre {
    @Id
    private Long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Show> shows;

    public List<Show> getShows() {
        return shows;
    }
}
