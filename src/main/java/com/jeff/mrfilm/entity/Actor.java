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
    private List<Film> films;

    @PreRemove
    public void preRemove() {
        for(Film f : films) {
            f.removeActor(this);
        }
    }

    public Actor() { }

    public Actor(String name, String surname, Date birthDate, Country country) {
        super(name, surname, birthDate, country);
        this.films = new ArrayList<>();
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        List<Film> oldFilms = this.films;
        for(Film f : oldFilms) {
            f.removeActor(this);
        }
        for(Film f : films) {
            f.addActor(this);
        }
        this.films = films;
    }

    public void addFilm(Film film) {
        this.getFilms().add(film);
    }

    public void removeFilm(Film film) {
        this.getFilms().remove(film);
    }
}
