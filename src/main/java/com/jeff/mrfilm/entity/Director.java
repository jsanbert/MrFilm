package com.jeff.mrfilm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "directors")
public class Director extends Person implements Serializable {

    @Column
    @OneToMany(mappedBy = "director")
    private List<Film> films;

    public Director() { }

    public Director(List<Film> films) {
        this.films = films;
    }

    public Director(Long id, String name, String surname, Integer age, Country country, List<Film> films) {
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
