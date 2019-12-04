package com.jeff.mrfilm.controllers;

import com.jeff.mrfilm.entities.Film;
import com.jeff.mrfilm.services.implementations.CountryService;
import com.jeff.mrfilm.services.implementations.FilmService;
import com.jeff.mrfilm.services.implementations.GenreService;
import com.jeff.mrfilm.services.implementations.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${mrfilm.api.baseurl}")
public class FilmController {
    @Autowired
    PersonService personService;

    @Autowired
    FilmService filmService;

    @Autowired
    CountryService countryService;

    @Autowired
    GenreService genreService;

    @GetMapping(value = "/films")
    public List<Film> getAllFilms() {
        return filmService.findAll();
    }

    @GetMapping(value = "/films/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.findFilmById(id);
    }

    @PostMapping(value = "/films/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Film addFilm(@RequestBody Film film) {
        return filmService.saveFilm(film);
    }

    @PutMapping(value = "/films/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Film updateFilm(@PathVariable Long id, @RequestBody Film film) {
        film.setId(id);
        return filmService.saveFilm(film);
    }

    @DeleteMapping(value = "/films/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteFilm(@PathVariable Long id) {
        filmService.deleteFilmById(id);
    }
}
