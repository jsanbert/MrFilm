package com.jeff.mrfilm.controller;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Genre;
import com.jeff.mrfilm.entity.Director;
import com.jeff.mrfilm.entity.Film;
import com.jeff.mrfilm.service.implementations.GenreService;
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
public class GenreController {
    @Autowired
    GenreService genreService;

    @Autowired
    PersonService personService;

    @Autowired
    FilmService filmService;

    @GetMapping("/genres")
    public CollectionModel<EntityModel<Genre>> getAllGenres() {
        List<Genre> allGenres = genreService.findAll();

        allGenres.stream().forEach(g -> g.addSelfLink());

        Link selfLink = linkTo(GenreController.class).withSelfRel();
        CollectionModel<EntityModel<Genre>> result = CollectionModel.wrap(allGenres).add(selfLink);
        return result;
    }

    @GetMapping("/genres/{id}")
    public Genre getGenreById(@PathVariable Long id) {
        Genre genre = genreService.findGenreById(id);

        genre.addAllLinks();

        return genre;
    }

    @GetMapping("/genres/{id}/films")
    public CollectionModel<EntityModel<Film>> getFilmsWithGenreByGenreId(@PathVariable Long id) {
        List<Film> genreFilms = filmService.findFilmsWithGenreByGenreId(id);
        genreFilms.stream().forEach(f-> f.addSelfLink());

        Link selfLink = linkTo(GenreController.class).withSelfRel();
        CollectionModel<EntityModel<Film>> result = CollectionModel.wrap(genreFilms).add(selfLink);
        return result;
    }
}
