package com.jeff.mrfilm.controller;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Director;
import com.jeff.mrfilm.entity.Film;
import com.jeff.mrfilm.entity.Person;
import com.jeff.mrfilm.service.implementations.FilmService;
import com.jeff.mrfilm.service.implementations.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    FilmService filmService;

    @GetMapping("/actors")
    public CollectionModel<EntityModel<Actor>> getAllActors() {
        List<Actor> allActors = personService.findAllActors();

        allActors.stream().forEach(a -> a.addSelfLink());

        Link selfLink = linkTo(PersonController.class).withSelfRel();
        CollectionModel<EntityModel<Actor>> result = CollectionModel.wrap(allActors).add(selfLink);
        return result;
    }

    @GetMapping("/actors/{id}")
    public Actor getActorById(@PathVariable Long id) {
        Actor actor = personService.findActorById(id);

        actor.addAllLinks();

//        Link countryLink = linkTo(methodOn(PersonController.class)
//                .getCountryById(actor.getId())).withRel("country");
        return actor;
    }

    @GetMapping("/actors/{id}/films")
    public CollectionModel<EntityModel<Film>> getActorFilmsByActorId(@PathVariable Long id) {
        List<Film> allFilms = filmService.findFilmsByActorId(id);
        allFilms.stream().forEach(f -> f.addSelfLink());

        Link selfLink = linkTo(PersonController.class).withSelfRel();
        CollectionModel<EntityModel<Film>> result = CollectionModel.wrap(allFilms).add(selfLink);
        return result;
    }
    
    
    @GetMapping("/directors")
    public CollectionModel<EntityModel<Director>> getAllDirectors() {
        List<Director> allDirectors = personService.findAllDirectors();

        allDirectors.stream().forEach(a -> a.addSelfLink());

        Link selfLink = linkTo(PersonController.class).withSelfRel();
        CollectionModel<EntityModel<Director>> result = CollectionModel.wrap(allDirectors).add(selfLink);
        return result;
    }

    @GetMapping("/directors/{id}")
    public Director getDirectorById(@PathVariable Long id) {
        Director director = personService.findDirectorById(id);

        director.addAllLinks();

        return director;
    }

    @GetMapping("/directors/{id}/films")
    public CollectionModel<EntityModel<Film>> getDirectorFilmsByDirectorId(@PathVariable Long id) {
        List<Film> allFilms = filmService.findFilmsByDirectorId(id);
        allFilms.stream().forEach(f -> f.addSelfLink());

        Link selfLink = linkTo(PersonController.class).withSelfRel();
        CollectionModel<EntityModel<Film>> result = CollectionModel.wrap(allFilms).add(selfLink);
        return result;
    }
}
