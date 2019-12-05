package com.jeff.mrfilm.controllers;

import com.jeff.mrfilm.entities.*;
import com.jeff.mrfilm.services.CountryService;
import com.jeff.mrfilm.services.FilmService;
import com.jeff.mrfilm.services.GenreService;
import com.jeff.mrfilm.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${mrfilm.api.baseurl}")
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    FilmService filmService;

    @Autowired
    CountryService countryService;

    @Autowired
    GenreService genreService;

    @GetMapping(value = "/actors")
    public List<Actor> getAllActors() {
        return personService.findAllActors();
    }

    @GetMapping(value = "/actors/{id}")
    public Actor getActorById(@PathVariable Long id) {
        return personService.findActorById(id);
    }

    @GetMapping(value = "/actors/{id}/films")
    public List<Film> getActorFilmsByActorId(@PathVariable Long id) {
        return filmService.findFilmsByActorId(id);
    }

    @PostMapping(value = "/actors/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Actor addActor(@RequestBody Actor actor) {
        return personService.saveActor(actor);
    }

    @PutMapping(value = "/actors/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Actor updateActor(@PathVariable Long id, @RequestBody Actor actor) {
        actor.setId(id);
        return personService.saveActor(actor);
    }

    @DeleteMapping(value = "/actors/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteActor(@PathVariable Long id) {
        personService.deleteActorById(id);
    }

    @GetMapping(value = "/directors")
    public List<Director> getAllDirectors() {
        return personService.findAllDirectors();
    }

    @GetMapping(value = "/directors/{id}")
    public Director getDirectorById(@PathVariable Long id) {
        return personService.findDirectorById(id);
    }

    @GetMapping(value = "/directors/{id}/films")
    public List<Film> getDirectorFilmsByDirectorId(@PathVariable Long id) {
        return filmService.findFilmsByDirectorId(id);
    }

    @PostMapping(value = "/directors/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Director addDirector(@RequestBody Director director) {
        return personService.saveDirector(director);
    }

    @PutMapping(value = "/directors/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Director updateDirector(@PathVariable Long id, @RequestBody Director director) {
        director.setId(id);
        return personService.saveDirector(director);
    }

    @DeleteMapping(value = "/directors/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDirector(@PathVariable Long id) {
        personService.deleteDirectorById(id);
    }
}
