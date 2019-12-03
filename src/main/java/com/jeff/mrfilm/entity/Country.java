package com.jeff.mrfilm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jeff.mrfilm.controller.CountryController;
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
@Table(name = "countries")
public class Country extends EntityModel<Country> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    @OneToMany(mappedBy = "country")
    @JsonBackReference
    private List<Person> people;

    @Column
    @OneToMany(mappedBy = "country")
    @JsonBackReference
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
