package com.jeff.mrfilm.entity;

import javax.persistence.*;
import java.io.Serializable;
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

    @Column
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "films_genres",
            joinColumns = { @JoinColumn(name = "genre_id") },
            inverseJoinColumns = { @JoinColumn(name = "film_id") }
    )
    private List<Genre> genres;

    @Column
    private Integer premiereYear;

    @ManyToOne(fetch = FetchType.LAZY)
    private Director director;

    @Column
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "films_actors",
        joinColumns = { @JoinColumn(name = "actor_id") },
        inverseJoinColumns = { @JoinColumn(name = "film_id") }
    )
    private List<Actor> actors;

    @Column
    private Integer prizesWon;

    @Column
    private Float rate;

    public Film() { }

    public Film(Long id, String title, String synopsis, List<Genre> genres, Integer premiereYear, Director director, List<Actor> actors, Integer prizesWon, Float rate) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.genres = genres;
        this.premiereYear = premiereYear;
        this.director = director;
        this.actors = actors;
        this.prizesWon = prizesWon;
        this.rate = rate;
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
}
