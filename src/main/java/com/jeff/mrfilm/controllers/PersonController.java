package com.jeff.mrfilm.controllers;

import com.jeff.mrfilm.dto.FilmDTO;
import com.jeff.mrfilm.dto.PersonDTO;
import com.jeff.mrfilm.entities.*;
import com.jeff.mrfilm.services.CountryService;
import com.jeff.mrfilm.services.FilmService;
import com.jeff.mrfilm.services.GenreService;
import com.jeff.mrfilm.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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
    public List<PersonDTO> getAllActors() {
        List<PersonDTO> personDTOS = new ArrayList<>();
        personService.findAllActors().stream().forEach(a -> personDTOS.add(a.toPersonDTO()));
        return personDTOS;

    }

    @GetMapping(value = "/actors/{id}")
    public PersonDTO getActorById(@PathVariable Long id) {
        Actor actor = personService.findActorById(id);
        return actor.toPersonDTO();
    }

    @GetMapping(value = "/actors/{id}/films")
    public List<FilmDTO> getActorFilmsByActorId(@PathVariable Long id) {
        List<FilmDTO> filmDTOS = new ArrayList<>();
        filmService.findFilmsByActorId(id).stream().forEach(f -> filmDTOS.add(f.toFilmDTO()));
        return filmDTOS;
    }

    @PostMapping(value = "/actors/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO addActor(@RequestBody @Valid PersonDTO personDTO) {
        Country country = countryService.findCountryById(personDTO.getCountryId());
        Actor actor = new Actor(personDTO.getName(), personDTO.getSurname(), personDTO.getBirthDate(), country);
        personDTO.setId(actor.getId());
        personService.insertActor(actor);
        return personDTO;
    }

    @PutMapping(value = "/actors/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO updateActor(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) {
        Country country = countryService.findCountryById(personDTO.getCountryId());
        Actor actor = new Actor(personDTO.getName(), personDTO.getSurname(), personDTO.getBirthDate(), country);
        actor.setId(id);
        personService.updateActor(actor);

        personDTO.setId(id);
        personDTO.setCountry(country.getName());
        return personDTO;
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
