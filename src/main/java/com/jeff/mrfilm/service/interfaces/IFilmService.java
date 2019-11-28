package com.jeff.mrfilm.service.interfaces;

import com.jeff.mrfilm.entity.Film;

import java.util.List;

public interface IFilmService {

    List<Film> findAll();
    Film insertFilm(Film film);

}
