package com.jeff.mrfilm.entities;

import com.jeff.mrfilm.dto.FilmDTO;

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

    @PreRemove
    public void preRemove() {
        if(country != null)
            country.getFilms().remove(this);

        for(Actor a : actors) {
            a.getFilms().remove(this);
        }

        if(director != null)
            director.getFilms().remove(this);

        for(Genre g : genres) {
            g.getFilms().remove(this);
        }

        this.actors.clear();
        this.genres.clear();
    }


    public Film() { }

    public Film(String title, String synopsis, Director director, List<Actor> actors, List<Genre> genres, Country country, Integer premiereYear, Integer prizesWon, Float rate) {
        this.title = title;
        this.synopsis = synopsis;
        country.getFilms().add(this);
        this.country = country;
        this.premiereYear = premiereYear;
        this.prizesWon = prizesWon;
        this.rate = rate;
        genres.stream().forEach(g -> g.getFilms().add(this));
        this.genres = genres;
        director.getFilms().add(this);
        this.director = director;
        actors.stream().forEach(a -> a.getFilms().add(this));
        this.actors = actors;
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

    public FilmDTO toFilmDTO() {
        List<String> actorFullNames = new ArrayList<>();
        List<String> genres = new ArrayList<>();
        this.getActors().stream().forEach(a ->
                actorFullNames.add(a.getName() + " " + a.getSurname())
        );
        Director d = this.getDirector();
        String directorFullName = (d == null) ? null :  d.getName() + " " + d.getSurname();

        this.getGenres().stream().forEach(g ->
                genres.add(g.getName())
        );

        Country country = this.getCountry();
        String countryName = (country == null) ? null : country.getName();

        return new FilmDTO(this.getId(), this.getTitle(), this.getSynopsis(), this.getPremiereYear(), this.getPrizesWon(),
                null, countryName, null, actorFullNames, null,
                directorFullName, null, genres, this.getRate());
    }
}
