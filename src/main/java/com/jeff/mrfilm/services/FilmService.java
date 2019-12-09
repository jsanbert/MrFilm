package com.jeff.mrfilm.services;

import com.jeff.mrfilm.entities.Actor;
import com.jeff.mrfilm.entities.Country;
import com.jeff.mrfilm.entities.Director;
import com.jeff.mrfilm.entities.Film;
import com.jeff.mrfilm.errors.exceptions.ResourceException;
import com.jeff.mrfilm.repositories.ActorRepository;
import com.jeff.mrfilm.repositories.DirectorRepository;
import com.jeff.mrfilm.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    public FilmRepository filmRepository;

    @Autowired
    public ActorRepository actorRepository;

    @Autowired
    public DirectorRepository directorRepository;

    public List<Film> findAll() {
        return (List<Film>) filmRepository.findAll();
    }

    public Film findFilmById(Long id) throws ResourceException {
        Film film = filmRepository.findById(id).orElse(null);
        if(film != null)
            return film;
        else
            throw new ResourceException(id, Film.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public Film insertFilm(Film film) {
        if(film.getId() != null || filmRepository.exists(film))
            throw new ResourceException(film.getId(), Film.class.getSimpleName(), ResourceException.ALREADY_EXISTS);
        else
            return filmRepository.save(film);
    }

    public Film updateFilm(Film film) {
        if(film.getId() != null && filmRepository.existsById(film.getId()))
            return filmRepository.save(film);
        else
            throw new ResourceException(film.getId(), Film.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public void deleteFilmById(Long id) {
        if(filmRepository.existsById(id))
            filmRepository.deleteById(id);
        else
            throw new ResourceException(id, Film.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public List<Film> findFilmsByActorId(Long id) {
        if(actorRepository.existsById(id))
            return (List<Film>) filmRepository.findFilmsByActorId(id);
        else
            throw new ResourceException(id, Actor.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public List<Film> findFilmsByDirectorId(Long id) {
        if(directorRepository.existsById(id))
            return (List<Film>) filmRepository.findFilmsByDirectorId(id);
        else
            throw new ResourceException(id, Director.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public List<Film> findFilmsByCountryId(Long id) { return (List<Film>) filmRepository.findFilmsByCountryId(id); }

    public List<Film> findFilmsWithGenreByGenreId(Long id) { return (List<Film>) filmRepository.findFilmsWithGenreByGenreId(id); };
}
