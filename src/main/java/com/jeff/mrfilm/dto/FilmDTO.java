package com.jeff.mrfilm.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jeff.mrfilm.entities.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FilmDTO {

    private Long id;

    @NotEmpty(message = "{validation.notemptyornull}")
    private String title;

    @NotEmpty(message = "{validation.notemptyornull}")
    private String synopsis;

    @NotEmpty(message = "{validation.notemptyornull}")
    private Integer premiereYear;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "{validation.notemptyornull}")
    private Long countryId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String country;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "{validation.notemptyornull}")
    private List<Integer> actorIds;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<String> actors;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private Integer directorId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String director;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty(message = "{validation.notemptyornull}")
    private List<Genre> genreIds;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<String> genres;

    public FilmDTO(Long id, @NotEmpty(message = "{validation.notemptyornull}") String title, @NotEmpty(message = "{validation.notemptyornull}") String synopsis, @NotEmpty(message = "{validation.notemptyornull}") Integer premiereYear, @NotNull(message = "{validation.notemptyornull}") Long countryId, String country, @NotNull(message = "{validation.notemptyornull}") List<Integer> actorIds, List<String> actors, @NotNull Integer directorId, String director, @NotEmpty(message = "{validation.notemptyornull}") List<Genre> genreIds, List<String> genres) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.premiereYear = premiereYear;
        this.countryId = countryId;
        this.country = country;
        this.actorIds = actorIds;
        this.actors = actors;
        this.directorId = directorId;
        this.director = director;
        this.genreIds = genreIds;
        this.genres = genres;
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

    public Integer getPremiereYear() {
        return premiereYear;
    }

    public void setPremiereYear(Integer premiereYear) {
        this.premiereYear = premiereYear;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Integer> getActorIds() {
        return actorIds;
    }

    public void setActorIds(List<Integer> actorIds) {
        this.actorIds = actorIds;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public List<Genre> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Genre> genreIds) {
        this.genreIds = genreIds;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}

