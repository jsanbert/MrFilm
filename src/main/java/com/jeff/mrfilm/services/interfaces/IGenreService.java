package com.jeff.mrfilm.services.interfaces;

import com.jeff.mrfilm.entities.Genre;

import java.util.List;

public interface IGenreService {

    List<Genre> findAll();
    Genre findGenreById(Long id);
    Genre saveGenre(Genre genre);
    void deleteGenreById(Long id);

}
