package com.jeff.mrfilm.controller;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Director;
import com.jeff.mrfilm.entity.Film;
import com.jeff.mrfilm.entity.Person;
import com.jeff.mrfilm.service.implementations.CountryService;
import com.jeff.mrfilm.service.implementations.FilmService;
import com.jeff.mrfilm.service.implementations.GenreService;
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
@RequestMapping("/")
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    FilmService filmService;

    @Autowired
    CountryService countryService;

    @Autowired
    GenreService genreService;
}
