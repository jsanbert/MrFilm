package com.jeff.mrfilm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FilmDTO {
    private Long id;

    @NotEmpty(message = "{validation.notemptyornull}")
    private String title;

    @NotEmpty(message = "{validation.notemptyornull}")
    private String synopsis;

    @NotNull(message = "{validation.notemptyornull}")
    private Integer premiereYear;

    @NotNull(message = "{validation.notemptyornull}")
    private Integer prizesWon;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "{validation.notemptyornull}")
    private Long countryId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String country;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "{validation.notemptyornull}")
    private List<Long> actorIds;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<String> actors;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private Long directorId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String director;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @NotEmpty(message = "{validation.notemptyornull}")
    private List<Long> genreIds;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<String> genres;

    @NotNull(message = "{validation.notemptyornull}")
    private Float rate;

    public FilmDTO() {

    }

    public FilmDTO(Long id, @NotEmpty(message = "{validation.notemptyornull}") String title, @NotEmpty(message = "{validation.notemptyornull}") String synopsis, @NotEmpty(message = "{validation.notemptyornull}") Integer premiereYear, @NotEmpty(message = "{validation.notemptyornull}") Integer prizesWon, @NotNull(message = "{validation.notemptyornull}") Long countryId, String country, @NotNull(message = "{validation.notemptyornull}") List<Long> actorIds, List<String> actors, @NotNull Long directorId, String director, @NotEmpty(message = "{validation.notemptyornull}") List<Long> genreIds, List<String> genres, @NotEmpty(message = "{validation.notemptyornull}") Float rate) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.premiereYear = premiereYear;
        this.prizesWon = prizesWon;
        this.countryId = countryId;
        this.country = country;
        this.actorIds = actorIds;
        this.actors = actors;
        this.directorId = directorId;
        this.director = director;
        this.genreIds = genreIds;
        this.genres = genres;
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

    public Integer getPremiereYear() {
        return premiereYear;
    }

    public void setPremiereYear(Integer premiereYear) {
        this.premiereYear = premiereYear;
    }

    public Integer getPrizesWon() {
        return prizesWon;
    }

    public void setPrizesWon(Integer prizesWon) {
        this.prizesWon = prizesWon;
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

    public List<Long> getActorIds() {
        return actorIds;
    }

    public void setActorIds(List<Long> actorIds) {
        this.actorIds = actorIds;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Long> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Long> genreIds) {
        this.genreIds = genreIds;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}

