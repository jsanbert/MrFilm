package com.jeff.mrfilm.controller;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Film;
import com.jeff.mrfilm.entity.Film;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1")
public class FilmController {
    @Autowired
    PersonService personService;

    @Autowired
    FilmService filmService;

    @GetMapping("/films")
    public CollectionModel<EntityModel<Film>> getAllFilms() {
        List<Film> allFilms = filmService.findAll();
        allFilms.stream().forEach(f -> f.addLinks());

        Link selfLink = linkTo(FilmController.class).withSelfRel();
        CollectionModel<EntityModel<Film>> result = CollectionModel.wrap(allFilms).add(selfLink);
        return result;
    }

    @GetMapping("/films/{id}")
    public Film getFilmById(@PathVariable Long id) {
        Film film = filmService.findFilmById(id);
        film.addLinks();
        return film;
    }

    @GetMapping("/films/{id}/actors")
    public CollectionModel<EntityModel<Actor>> getActorsByFilmId(@PathVariable Long id) {
        List<Actor> filmActors = personService.findActorsByFilmId(id);
        filmActors.stream().forEach(a -> a.addSelfLink());

        Link selfLink = linkTo(PersonController.class).withSelfRel();
        CollectionModel<EntityModel<Actor>> result = CollectionModel.wrap(filmActors).add(selfLink);
        return result;
    }
}
