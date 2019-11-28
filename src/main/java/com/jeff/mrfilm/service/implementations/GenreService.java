package com.jeff.mrfilm.service.implementations;

import com.jeff.mrfilm.entity.Genre;
import com.jeff.mrfilm.repository.GenreRepository;
import com.jeff.mrfilm.service.interfaces.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {

    @Autowired
    public GenreRepository repository;

    public List<Genre> findAll() {
        return (List<Genre>) repository.findAll();
    }

    public Genre insertGenre(Genre genre) {
        return repository.save(genre);
    }
}
