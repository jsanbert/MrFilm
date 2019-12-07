package com.jeff.mrfilm.dataloader;


import com.jeff.mrfilm.entities.*;
import com.jeff.mrfilm.services.CountryService;
import com.jeff.mrfilm.services.FilmService;
import com.jeff.mrfilm.services.GenreService;
import com.jeff.mrfilm.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DataLoader implements ApplicationRunner {

    private FilmService filmService;
    private CountryService countryService;
    private GenreService genreService;
    private PersonService personService;

    @Autowired
    public DataLoader(FilmService filmService, CountryService countryService, GenreService genreService, PersonService personService) {
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
        Country country5 = new Country("Austria", "AT");
        Country country6 = new Country("United Kingdom", "UK");
        countryService.insertCountry(country1);
        countryService.insertCountry(country2);
        countryService.insertCountry(country3);
        countryService.insertCountry(country4);
        countryService.insertCountry(country5);
        countryService.insertCountry(country6);

        // ACTORS
        Actor actor1 = new Actor("Arnold", "Schwarzenegger", sdf.parse("1947-07-30"), country5);
        Actor actor2 = new Actor("Sylvester", "Stallone", sdf.parse("1946-07-06"), country3);
        Actor actor3 = new Actor("Richard", "Crenna", sdf.parse("1960-05-24"), country1);
        Actor actor4 = new Actor("Bryan", "Dennehy", sdf.parse("1938-07-09"), country1);
        Actor actor5 = new Actor("Michael", "Bienne", sdf.parse("1956-07-31"), country2);
        Actor actor6 = new Actor("Linda", "Hamilton", sdf.parse("1956-09-26"), country2);
        personService.insertActor(actor1);
        personService.insertActor(actor2);
        personService.insertActor(actor3);
        personService.insertActor(actor4);
        personService.insertActor(actor5);
        personService.insertActor(actor6);

        // DIRECTORS
        Director director1 = new Director("James", "Cameron", sdf.parse("1954-08-16"), country1);
        Director director2 = new Director("Ted", "Kotcheff", sdf.parse("1931-07-07"), country4);
        personService.saveDirector(director1);
        personService.saveDirector(director2);

        // GENRES
        Genre genre1 = new Genre("Action");
        Genre genre2 = new Genre("Drama");
        Genre genre3 = new Genre("Thriller");
        Genre genre4 = new Genre("War");
        Genre genre5 = new Genre("Romantic");
        Genre genre6 = new Genre("Sci-Fi");
        genreService.insertGenre(genre1);
        genreService.insertGenre(genre2);
        genreService.insertGenre(genre3);
        genreService.insertGenre(genre5);
        genreService.insertGenre(genre4);
        genreService.insertGenre(genre6);

        // FILMS
        Film film1 = new Film("Rambo", "A veteran Green Beret is forced by a cruel Sheriff and his deputies to flee into the mountains and wage an escalating one-man war against his pursuers.", director2, country1, 1982, 1, 8.8F);
        film1.addActor(actor2);
        film1.addActor(actor3);
        film1.addActor(actor4);
        film1.addGenre(genre1);
        film1.addGenre(genre3);
        film1.addGenre(genre4);

        Film film2 = new Film("Terminator", "In 1984, a human soldier is tasked to stop an indestructible cyborg killing machine, both sent from 2029, from executing a young woman, whose unborn son is the key to humanity's future salvation.", director1, country1, 1997, 6, 7.5F);
        film2.addActor(actor1);
        film2.addActor(actor5);
        film2.addGenre(genre1);
        film2.addGenre(genre2);
        film2.addGenre(genre3);
        film2.addGenre(genre6);

        filmService.saveFilm(film1);
        filmService.saveFilm(film2);
//
//        genreService.deleteGenreById(11L);
//        countryService.deleteCountryById(1L);
    }
}