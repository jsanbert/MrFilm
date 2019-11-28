package com.jeff.mrfilm.dataloader;

import com.jeff.mrfilm.entity.*;
import com.jeff.mrfilm.service.interfaces.ICountryService;
import com.jeff.mrfilm.service.interfaces.IFilmService;
import com.jeff.mrfilm.service.interfaces.IGenreService;
import com.jeff.mrfilm.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private IFilmService filmService;
    private ICountryService countryService;
    private IGenreService genreService;
    private IPersonService personService;

    @Autowired
    public DataLoader(IFilmService filmService, ICountryService countryService, IGenreService genreService, IPersonService personService) {
        this.filmService = filmService;
        this.countryService = countryService;
        this.genreService = genreService;
        this.personService = personService;
    }

    public void run(ApplicationArguments args) {
        Country country1 = new Country("USA");

        countryService.insertCountry(country1);

        Actor actor1 = new Actor(1L, "Arnold", "Schwarzenegger", 78, country1, new ArrayList<>());
        personService.insertPerson(actor1);
        Director director1 = new Director(2L, "Michael", "Bay", 58, country1, new ArrayList<>());
        personService.insertPerson(director1);

        Genre genre1 = new Genre("Action");
        genreService.insertGenre(genre1);
        Film film1 = new Film(1L, "Eraser", "Blablablablablablab", new ArrayList<>(), 1997, director1, new ArrayList<>(), 4, 8.8F);
        film1.getActors().add(actor1);
        film1.setDirector(director1);
        film1.getGenres().add(genre1);

        filmService.insertFilm(film1);

    }
}