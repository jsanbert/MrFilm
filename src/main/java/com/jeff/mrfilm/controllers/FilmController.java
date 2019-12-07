package com.jeff.mrfilm.controllers;

import com.jeff.mrfilm.dto.FilmDTO;
import com.jeff.mrfilm.dto.PersonDTO;
import com.jeff.mrfilm.entities.Director;
import com.jeff.mrfilm.entities.Film;
import com.jeff.mrfilm.services.CountryService;
import com.jeff.mrfilm.services.FilmService;
import com.jeff.mrfilm.services.GenreService;
import com.jeff.mrfilm.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<FilmDTO> getAllFilms() {
        List<FilmDTO> filmDTOS = new ArrayList<>();
        List<Film> films = filmService.findAll();

        films.stream().forEach(f -> filmDTOS.add(f.toFilmDTO()));

        return filmDTOS;
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
