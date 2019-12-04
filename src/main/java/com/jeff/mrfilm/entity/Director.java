package com.jeff.mrfilm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jeff.mrfilm.controller.CountryController;
import com.jeff.mrfilm.controller.PersonController;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "directors")
public class Director extends Person implements Serializable {

    @Column
    @OneToMany(mappedBy = "director")
    @JsonBackReference
    private List<Film> films;

    @PreRemove
    public void preRemove() {
        for(Film f : this.films) {
            f.setDirector(null);
        }
        this.films.clear();
    }

    public Director() { }

    public Director(String name, String surname, Date birthDate, Country country) {
        super(name, surname, birthDate, country);
        this.films = new ArrayList<>();
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film) {
        this.getFilms().add(film);
    }

    public void removeFilm(Film film) {
        this.getFilms().remove(film);
    }
}
