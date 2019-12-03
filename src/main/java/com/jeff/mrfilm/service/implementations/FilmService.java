package com.jeff.mrfilm.service.implementations;

import com.jeff.mrfilm.entity.Film;
import com.jeff.mrfilm.entity.Genre;
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

    public Film findFilmById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Film> findFilmsByActorId(Long id) {
        return (List<Film>) repository.findFilmsByActorId(id);
    }

    public List<Film> findFilmsByDirectorId(Long id) {
        return (List<Film>) repository.findFilmsByDirectorId(id);
    }

    public List<Film> findFilmsByCountryId(Long id) { return (List<Film>) repository.findFilmsByCountryId(id); }

    public List<Film> findFilmsWithGenreByGenreId(Long id) { return (List<Film>) repository.findFilmsWithGenreByGenreId(id); };

    public Film saveFilm(Film film) {
        return repository.save(film);
    }

    public void deleteFilmById(Long id) { repository.deleteById(id); }
}
