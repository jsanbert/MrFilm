package com.jeff.mrfilm.services;

import com.jeff.mrfilm.entities.Country;
import com.jeff.mrfilm.entities.Genre;
import com.jeff.mrfilm.errors.exceptions.ResourceException;
import com.jeff.mrfilm.repositories.CountryRepository;
import com.jeff.mrfilm.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    public GenreRepository genreRepository;

    public List<Genre> findAll() {
        return (List<Genre>) genreRepository.findAll();
    }

    public Genre findGenreById(Long id) throws ResourceException {
        Genre genre = genreRepository.findById(id).orElse(null);
        if(genre != null)
            return genre;
        else
            throw new ResourceException(id, Genre.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public Genre insertGenre(Genre genre) {
        if(genre.getId() != null || genreRepository.exists(genre))
            throw new ResourceException(genre.getId(), Genre.class.getSimpleName(), ResourceException.ALREADY_EXISTS);
        else
            return genreRepository.save(genre);
    }

    public Genre updateGenre(Genre genre) {
        if(genreRepository.exists(genre))
            return genreRepository.save(genre);
        else
            throw new ResourceException(genre.getId(), Genre.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public void deleteGenreById(Long id) {
        if(genreRepository.existsById(id))
            genreRepository.deleteById(id);
        else
            throw new ResourceException(id, Genre.class.getSimpleName(), ResourceException.NOT_FOUND);
    }
}
