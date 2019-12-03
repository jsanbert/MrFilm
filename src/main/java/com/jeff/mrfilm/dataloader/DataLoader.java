package com.jeff.mrfilm.dataloader;

/*
import com.jeff.mrfilm.entity.*;
import com.jeff.mrfilm.service.interfaces.ICountryService;
import com.jeff.mrfilm.service.interfaces.IFilmService;
import com.jeff.mrfilm.service.interfaces.IGenreService;
import com.jeff.mrfilm.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public void run(ApplicationArguments args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // COUNTRIES
        Country country1 = new Country("United States of America", "USA");
        Country country2 = new Country("Spain", "ES");
        Country country3 = new Country("France", "FR");
        Country country4 = new Country("Poland", "PL");
        Country country5 = new Country("United Kingdom", "UK");
        countryService.saveCountry(country1);
        countryService.saveCountry(country2);
        countryService.saveCountry(country3);
        countryService.saveCountry(country4);
        countryService.saveCountry(country5);

        // ACTORS
        Actor actor1 = new Actor("Arnold", "Schwarzenegger", sdf.parse("1954-10-27"), country1);
        Actor actor2 = new Actor("Sylvester", "Stallone", sdf.parse("1950-09-10"), country5);
        Actor actor3 = new Actor("Antonio", "Banderas", sdf.parse("1960-05-24"), country2);
        personService.saveActor(actor1);
        personService.saveActor(actor2);
        personService.saveActor(actor3);

        // DIRECTORS
        Director director1 = new Director("Michael", "Bay", sdf.parse("1967-03-10"), country1);
        Director director2 = new Director("Roman", "Polanski", sdf.parse("1945-05-13"), country4);
        personService.saveDirector(director1);
        personService.saveDirector(director2);

        // GENRES
        Genre genre1 = new Genre("Action");
        Genre genre2 = new Genre("Drama");
        Genre genre3 = new Genre("Thriller");
        Genre genre4 = new Genre("War");
        Genre genre5 = new Genre("Romantic");
        Genre genre6 = new Genre("Sci-Fi");
        genreService.saveGenre(genre1);
        genreService.saveGenre(genre2);
        genreService.saveGenre(genre3);
        genreService.saveGenre(genre4);
        genreService.saveGenre(genre5);
        genreService.saveGenre(genre6);

        // FILMS
        Film film1 = new Film("Eraser", "Synopsis Eraser", director1, country1, 2000, 3, 8.8F);
        film1.addActor(actor1);
        film1.addGenre(genre1);

        Film film2 = new Film("Rambo", "Synopsis Rambo", director2, country1, 1997, 6, 7.5F);
        film2.addActor(actor2);
        film2.addActor(actor3);
        film2.addGenre(genre1);
        film2.addGenre(genre4);

        filmService.saveFilm(film1);
        filmService.saveFilm(film2);

    }
}*/