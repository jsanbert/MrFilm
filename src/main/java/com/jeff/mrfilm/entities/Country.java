package com.jeff.mrfilm.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotEmpty(message = "{validation.notemptyornull}")
    private String name;

    @Column
    @NotEmpty(message = "{validation.notemptyornull}")
    private String code;

    @Column
    @OneToMany(mappedBy = "country")
    @JsonBackReference(value = "peopleReference")
    private List<Person> people;

    @Column
    @OneToMany(mappedBy = "country")
    @JsonBackReference(value = "filmsReference")
    private List<Film> films;

    @PreRemove
    public void preRemove() {
        for(Person p : people) {
            p.setCountry(null);
        }
        for(Film f : films) {
            f.setCountry(null);
        }
    }

    @PrePersist
    public void prePersist() {
        this.setCode(this.getCode().toUpperCase());
    }

    public Country() { }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
        this.people = new ArrayList<>();
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

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        List<Person> oldPeople = this.people;
        for(Person p : oldPeople) {
            p.setCountry(null);
        }
        for(Person p : people) {
            p.setCountry(this);
        }
        this.people = people;
    }

    public void addPerson(Person person) {
        this.getPeople().add(person);
        person.setCountry(this);
    }

    public void removePerson(Person person) {
        this.getPeople().remove(person);
        person.setCountry(null);
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        List<Film> oldFilms = this.films;
        for(Film f : oldFilms) {
            f.setCountry(null);
        }
        for(Film f : films) {
            f.setCountry(this);
        }
        this.films = films;
    }

    public void addFilm(Film film) {
        this.getFilms().add(film);
    }

    public void removeFilm(Film film) {
        this.getFilms().remove(film);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
