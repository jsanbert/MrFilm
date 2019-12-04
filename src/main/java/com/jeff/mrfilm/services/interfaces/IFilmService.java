package com.jeff.mrfilm.services.interfaces;

import com.jeff.mrfilm.entities.Film;

import java.util.List;

public interface IFilmService {

    List<Film> findAll();
    Film saveFilm(Film film);

    List<Film> findFilmsByActorId(Long id);
    List<Film> findFilmsByDirectorId(Long id);
    List<Film> findFilmsByCountryId(Long id);
    List<Film> findFilmsWithGenreByGenreId(Long id);
    void deleteFilmById(Long id);

}
