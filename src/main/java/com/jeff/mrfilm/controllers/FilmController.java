package com.jeff.mrfilm.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class FilmController {
    static PersonService personService;
    static FilmService filmService;
    static CountryService countryService;
    static GenreService genreService;

    @Autowired
    public FilmController(PersonService ps, FilmService fs, CountryService cs, GenreService gs) {
        personService = ps;
        filmService = fs;
        countryService = cs;
        genreService = gs;
    }

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
    public FilmDTO addFilm(@RequestBody @Valid FilmDTO filmDTO) {
        Film film = this.fromFilmDTOToFilm(filmDTO);
        return filmService.insertFilm(film).toFilmDTO();
    }

    @PutMapping(value = "/films/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public FilmDTO updateFilm(@PathVariable Long id, @RequestBody @Valid FilmDTO filmDTO) {
        Film film = this.fromFilmDTOToFilm(filmDTO);
        film.setId(id);

        return filmService.updateFilm(film).toFilmDTO();
    }

    @DeleteMapping(value = "/films/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteFilm(@PathVariable Long id) {
        filmService.deleteFilmById(id);
    }

    public static Film fromFilmDTOToFilm(FilmDTO filmDTO) {
        List<Actor> actorList = new ArrayList<>();
        if(filmDTO.getActorIds() != null)
            filmDTO.getActorIds().stream().forEach(i -> actorList.add(personService.findActorById(i)));

        Director director = personService.findDirectorById(filmDTO.getDirectorId());

        Country country = countryService.findCountryById(filmDTO.getCountryId());

        List<Genre> genreList = new ArrayList<>();

        if(filmDTO.getGenreIds() != null)
            filmDTO.getGenreIds().stream().forEach(i -> genreList.add(genreService.findGenreById(i)));


        return new Film(filmDTO.getTitle(), filmDTO.getSynopsis(), director, actorList, genreList, country, filmDTO.getPremiereYear(), filmDTO.getPrizesWon(), filmDTO.getRate());
    }
}
