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
    @JsonIgnore
    private List<Person> people;

    public Country() { }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
        this.people = new ArrayList<>();
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
        this.people = people;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addAllLinks() {
        Link filmsLink = linkTo(methodOn(CountryController.class)
                .getFilmsFromCountryByCountryId(this.getId())).withRel("films");

        Link actorsLink = linkTo(methodOn(CountryController.class)
                .getActorsFromCountryByCountryId(this.getId())).withRel("actors");

        Link directorsLink = linkTo(methodOn(CountryController.class)
                .getDirectorsFromCountryByCountryId(this.getId())).withRel("directors");


        this.addSelfLink();
        this.add(filmsLink);
        this.add(actorsLink);
        this.add(directorsLink);
    }

    public void addSelfLink() {
        Link selfLink = linkTo(methodOn(CountryController.class)
                .getCountryById(this.getId())).withSelfRel();

        this.add(selfLink);
    }
}
