package com.jeff.mrfilm.controllers;

import com.jeff.mrfilm.entities.*;
import com.jeff.mrfilm.services.implementations.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("${mrfilm.api.baseurl}")
public class GenreController {
    
    @Autowired
    GenreService genreService;

    @GetMapping(value = "/genres")
    public List<Genre> getAllGenres() {
        return genreService.findAll();
    }

    @GetMapping(value = "/genres/{id}")
    public Genre getGenreById(@PathVariable Long id) {
        return genreService.findGenreById(id);
    }

    @PostMapping(value = "/genres/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Genre addGenre(@RequestBody Genre genre) {
        return genreService.saveGenre(genre);
    }

    @PutMapping(value = "/genres/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Genre updateGenre(@PathVariable Long id, @RequestBody Genre genre) {
        genre.setId(id);
        return genreService.saveGenre(genre);
    }

    @DeleteMapping(value = "/genres/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteGenre(@PathVariable Long id) {
        genreService.deleteGenreById(id);
    }
}
