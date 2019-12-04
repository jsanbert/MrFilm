package com.jeff.mrfilm.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor extends Person implements Serializable {

    @Column
    @ManyToMany(mappedBy = "actors", cascade = { CascadeType.MERGE })
    @JsonBackReference(value = "actorsReference")
    private List<Film> films;

    @PreRemove
    public void preRemove() {
        for(Film f : films) {
            f.getActors().remove(this);
        }
        this.films.clear();
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
            f.getActors().remove(this);
        }
        this.films.clear();
        for(Film f : films) {
            f.addActor(this);
        }
    }

    public void addFilm(Film film) {
        this.getFilms().add(film);
        film.getActors().add(this);
    }

    public void removeFilm(Film film) {
        this.getFilms().remove(film);
        film.getActors().remove(this);
    }
}
