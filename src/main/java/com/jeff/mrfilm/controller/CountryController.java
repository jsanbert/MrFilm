package com.jeff.mrfilm.controller;

import com.jeff.mrfilm.entity.*;
import com.jeff.mrfilm.service.implementations.CountryService;
import com.jeff.mrfilm.service.implementations.FilmService;
import com.jeff.mrfilm.service.implementations.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1")
public class CountryController {
    @Autowired
    CountryService countryService;

    @Autowired
    PersonService personService;

    @Autowired
    FilmService filmService;

    @GetMapping("/countries")
    public CollectionModel<EntityModel<Country>> getAllCountries() {
        List<Country> allCountries = countryService.findAll();

        allCountries.stream().forEach(c -> c.addSelfLink());

        Link selfLink = linkTo(CountryController.class).withSelfRel();
        CollectionModel<EntityModel<Country>> result = CollectionModel.wrap(allCountries).add(selfLink);
        return result;
    }

    @GetMapping("/countries/{id}")
    public Country getCountryById(@PathVariable Long id) {
        Country country = countryService.findCountryById(id);

        country.addAllLinks();

        return country;
    }

    @GetMapping("/countries/{id}/actors")
    public CollectionModel<EntityModel<Actor>> getActorsFromCountryByCountryId(@PathVariable Long id) {
        List<Actor> countryActors = personService.findActorsByCountryId(id);
        countryActors.stream().forEach(a-> a.addSelfLink());

        Link selfLink = linkTo(CountryController.class).withSelfRel();
        CollectionModel<EntityModel<Actor>> result = CollectionModel.wrap(countryActors).add(selfLink);
        return result;
    }

    @GetMapping("/countries/{id}/directors")
    public CollectionModel<EntityModel<Director>> getDirectorsFromCountryByCountryId(@PathVariable Long id) {
        List<Director> countryDirectors = personService.findDirectorsByCountryId(id);
        countryDirectors.stream().forEach(d-> d.addSelfLink());

        Link selfLink = linkTo(CountryController.class).withSelfRel();
        CollectionModel<EntityModel<Director>> result = CollectionModel.wrap(countryDirectors).add(selfLink);
        return result;
    }

    @GetMapping("/countries/{id}/films")
    public CollectionModel<EntityModel<Film>> getFilmsFromCountryByCountryId(@PathVariable Long id) {
        List<Film> countryFilms = filmService.findFilmsByCountryId(id);
        countryFilms.stream().forEach(f-> f.addSelfLink());

        Link selfLink = linkTo(CountryController.class).withSelfRel();
        CollectionModel<EntityModel<Film>> result = CollectionModel.wrap(countryFilms).add(selfLink);
        return result;
    }
}
