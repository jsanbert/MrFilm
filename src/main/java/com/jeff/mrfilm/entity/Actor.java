package com.jeff.mrfilm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor extends Person implements Serializable {

    @Column
    @ManyToMany(mappedBy = "actors")
    private List<Film> films;

    public Actor() { }

    public Actor(List<Film> films) {
        this.films = films;
    }

    public Actor(Long id, String name, String surname, Integer age, Country country, List<Film> films) {
        super(id, name, surname, age, country);
        this.films = films;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
