package com.jeff.mrfilm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jeff.mrfilm.controller.CountryController;
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
@Table(name = "films")
public class Film extends EntityModel<Film> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String synopsis;

    @ManyToOne
    private Country country;

    @Column
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
        name = "films_genres",
        joinColumns = { @JoinColumn(name = "film_id") },
        inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )
    @JsonManagedReference
    private List<Genre> genres;

    @Column
    private Integer premiereYear;

    @ManyToOne(cascade = { CascadeType.MERGE })
    private Director director;

    @Column
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
        name = "films_actors",
        joinColumns = { @JoinColumn(name = "film_id") },
        inverseJoinColumns = { @JoinColumn(name = "actor_id") }
    )
    @JsonManagedReference
    private List<Actor> actors;

    @Column
    private Integer prizesWon;

    @Column
    private Float rate;

    public Film() { }

    public Film(String title, String synopsis, Country country, Integer premiereYear, Integer prizesWon, Float rate) {
        this.title = title;
        this.synopsis = synopsis;
        this.country = country;
        this.premiereYear = premiereYear;
        this.prizesWon = prizesWon;
        this.rate = rate;
        this.genres = new ArrayList<>();
        this.director = new Director();
        this.actors = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Integer getPremiereYear() {
        return premiereYear;
    }

    public void setPremiereYear(Integer premiereYear) {
        this.premiereYear = premiereYear;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
        director.addFilm(this);
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Integer getPrizesWon() {
        return prizesWon;
    }

    public void setPrizesWon(Integer prizesWon) {
        this.prizesWon = prizesWon;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public void addActor(Actor actor) {
        this.getActors().add(actor);
        actor.getFilms().add(this);
    }

    public void removeActor(Actor actor) {
        this.getActors().remove(actor);
        actor.getFilms().remove(this);
    }

    public void addGenre(Genre genre) {
        this.getGenres().add(genre);
        genre.getFilms().add(this);
    }

    public void removeGenre(Genre genre) {
        this.getGenres().remove(genre);
        genre.getFilms().remove(this);
    }

    public void addLinks() {

        Link actorsLink = linkTo(methodOn(FilmController.class)
                .getActorsByFilmId(this.getId())).withRel("actors");

        Link countryLink = linkTo(methodOn(CountryController.class)
                .getCountryById(this.getCountry().getId())).withRel("country");

        Link directorLink = linkTo(methodOn(PersonController.class)
                .getDirectorById(this.getDirector().getId())).withRel("director");

        Link genresLink = linkTo(methodOn(FilmController.class)
                .get(this.getDirector().getId())).withRel("director");

        this.addSelfLink();
        this.add(actorsLink);
        this.add(countryLink);
        this.add(directorLink);
        this.add(genresLink);
    }

    public void addSelfLink() {
        Link selfLink = linkTo(methodOn(FilmController.class)
                .getFilmById(this.getId())).withSelfRel();

        this.add(selfLink);
    }
}
