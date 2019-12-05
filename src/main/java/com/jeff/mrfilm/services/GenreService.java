package com.jeff.mrfilm.services;

import com.jeff.mrfilm.entities.Genre;
import com.jeff.mrfilm.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    public GenreRepository repository;

    public List<Genre> findAll() {
        return (List<Genre>) repository.findAll();
    }

    public Genre findGenreById(Long id) { return repository.findById(id).orElse(null); }

    public Genre saveGenre(Genre genre) {
        return repository.save(genre);
    }

    public void deleteGenreById(Long id) { repository.deleteById(id); }
}
