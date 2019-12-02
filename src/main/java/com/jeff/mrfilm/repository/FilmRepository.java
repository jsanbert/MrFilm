package com.jeff.mrfilm.repository;

import com.jeff.mrfilm.entity.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    @Query("SELECT f FROM Film f JOIN f.actors a WHERE a.id=:id")
    Iterable<Film> findFilmsByActorId(Long id);

    @Query("SELECT f FROM Film f JOIN f.director d WHERE d.id=:id")
    Iterable<Film> findFilmsByDirectorId(Long id);

    @Query("SELECT f FROM Film f JOIN f.country c WHERE c.id=:id")
    Iterable<Film> findFilmsByCountryId(Long id);

    @Query("SELECT f FROM Film f JOIN f.genres g WHERE g.id=:id")
    Iterable<Film> findFilmsWithGenreByGenreId(Long id);
}
