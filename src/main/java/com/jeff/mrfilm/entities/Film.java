package com.jeff.mrfilm.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    @JoinTable(
        name = "films_genres",
        joinColumns = { @JoinColumn(name = "film_id") },
        inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )
    private List<Genre> genres;

    @Column
    private Integer premiereYear;

    @ManyToOne(cascade = { CascadeType.MERGE })
    private Director director;

    @Column
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    @JoinTable(
        name = "films_actors",
        joinColumns = { @JoinColumn(name = "film_id") },
        inverseJoinColumns = { @JoinColumn(name = "actor_id") }
    )

    private List<Actor> actors;

    @Column
    private Integer prizesWon;

    @Column
    private Float rate;

    public Film() { }

    public Film(String title, String synopsis, Director director, Country country, Integer premiereYear, Integer prizesWon, Float rate) {
        this.title = title;
        this.synopsis = synopsis;
        country.addFilm(this);
        this.country = country;
        this.premiereYear = premiereYear;
        this.prizesWon = prizesWon;
        this.rate = rate;
        this.genres = new ArrayList<>();
        director.addFilm(this);
        this.director = director;
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
        if(country != null) {
            this.country.removeFilm(this);
            country.addFilm(this);
        }
        this.country = country;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> newGenres) {
        List<Genre> oldGenres = this.genres;
        for(Genre g : oldGenres) {
            g.getFilms().remove(this);
        }
        this.genres.clear();
        for(Genre g : newGenres) {
            g.addFilm(this);
        }
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

    public void setDirector(Director newDirector) {
        if(newDirector != null)
            newDirector.addFilm(this);

        this.director = newDirector;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> newActors) {
        List<Actor> oldActors = this.actors;
        for(Actor g : oldActors) {
            g.removeFilm(this);
        }
        for(Actor g : newActors) {
            g.addFilm(this);
        }
        this.actors = newActors;
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
}