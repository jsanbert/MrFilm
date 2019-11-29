package com.jeff.mrfilm.service.implementations;

import com.jeff.mrfilm.entity.Film;
import com.jeff.mrfilm.repository.FilmRepository;
import com.jeff.mrfilm.service.interfaces.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements IFilmService {

    @Autowired
    public FilmRepository repository;

    public List<Film> findAll() {
        return (List<Film>) repository.findAll();
    }

    public Film saveFilm(Film film) {
        return repository.save(film);
    }
}
