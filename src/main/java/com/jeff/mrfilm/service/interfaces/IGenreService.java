package com.jeff.mrfilm.service.interfaces;

import com.jeff.mrfilm.entity.Genre;

import java.util.List;

public interface IGenreService {

    List<Genre> findAll();
    Genre findGenreById(Long id);
    Genre saveGenre(Genre genre);

}
