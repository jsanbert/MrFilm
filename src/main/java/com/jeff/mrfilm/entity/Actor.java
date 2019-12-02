package com.jeff.mrfilm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jeff.mrfilm.controller.CountryController;
import com.jeff.mrfilm.controller.PersonController;
import org.springframework.hateoas.Link;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Entity
@Table(name = "actors")
public class Actor extends Person implements Serializable {

    @Column
    @ManyToMany(mappedBy = "actors")
    @JsonBackReference
    @JsonIgnore
    private List<Film> films;

    public Actor() { }

    public Actor(String name, String surname, Date birthDate, Country country) {
        super(name, surname, birthDate, country);
        this.films = new ArrayList<>();
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addAllLinks() {
        Link filmsLink = linkTo(methodOn(PersonController.class)
                .getActorFilmsByActorId(this.getId())).withRel("films");

        Link countryLink = linkTo(methodOn(CountryController.class)
                .getCountryById(this.getCountry().getId())).withRel("country");

        this.addSelfLink();
        this.add(filmsLink);
        this.add(countryLink);
    }

    public void addSelfLink() {
        Link selfLink = linkTo(methodOn(PersonController.class)
                .getActorById(this.getId())).withSelfRel();

        this.add(selfLink);
    }
}
