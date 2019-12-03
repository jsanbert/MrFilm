package com.jeff.mrfilm.controller;

import com.jeff.mrfilm.entity.*;
import com.jeff.mrfilm.service.implementations.CountryService;
import com.jeff.mrfilm.service.implementations.FilmService;
import com.jeff.mrfilm.service.implementations.GenreService;
import com.jeff.mrfilm.service.implementations.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1")
public class CountryController {
    @Autowired
    PersonService personService;

    @Autowired
    FilmService filmService;

    @Autowired
    CountryService countryService;

    @Autowired
    GenreService genreService;

    @PostMapping("/countries/add")
    public Country addCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    @PutMapping("/countries/update/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country) {
        Country old = countryService.findCountryById(id);
        if(old != null) {
            country.setId(old.getId());
            return countryService.saveCountry(country);
        }
        return null;
    }

    @DeleteMapping("/countries/delete/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountryById(id);
    }
}
