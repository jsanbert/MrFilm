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
    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    private List<Film> films;

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
        this.films = films;
    }

    public void addAllLinks() {
        Link filmsLink = linkTo(methodOn(GenreController.class)
                .getFilmsWithGenreByGenreId(this.getId())).withRel("films");

        this.addSelfLink();
        this.add(filmsLink);
    }

    public void addSelfLink() {
        Link selfLink = linkTo(methodOn(GenreController.class)
                .getGenreById(this.getId())).withSelfRel();

        this.add(selfLink);
    }
}
