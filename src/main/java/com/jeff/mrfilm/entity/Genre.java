package com.jeff.mrfilm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jeff.mrfilm.controller.FilmController;
import com.jeff.mrfilm.controller.GenreController;
import com.jeff.mrfilm.controller.PersonController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Entity
@Table(name = "genres")
public class Genre extends EntityModel<Genre> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    @ManyToMany(mappedBy = "genres", cascade = { CascadeType.MERGE })
    @JsonBackReference
    private List<Film> films;

    @PreRemove
    public void preRemove() {
        for(Film f : films) {
            f.getGenres().remove(this);
        }
        this.films.clear();
    }

    public Genre() { }

    public Genre(String name) {
        this.name = name;
        this.films = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        List<Film> oldFilms = this.films;
        for(Film f : oldFilms) {
            f.getGenres().remove(this);
        }
        this.films.clear();
        for(Film f : films) {
            f.addGenre(this);
        }
    }

    public void addFilm(Film film) {
        this.getFilms().add(film);
        film.getGenres().add(this);
    }

    public void removeFilm(Film film) {
        this.getFilms().remove(film);
        film.getGenres().remove(this);
    }
}
