package com.jeff.mrfilm.service.interfaces;

import com.jeff.mrfilm.entity.Film;
import com.jeff.mrfilm.entity.Genre;

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
