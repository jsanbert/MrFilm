package com.jeff.mrfilm.repositories;

import com.jeff.mrfilm.entities.Country;
import com.jeff.mrfilm.entities.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

    @Query("SELECT COUNT(f) > 0 FROM Film f " +
            "WHERE f.id = :#{#film.getId()} " +
            "OR (" +
            "LOWER(TRIM(f.title)) = LOWER(TRIM(:#{#film.getTitle()})) " +
            "AND " +
            "f.country.id = :#{#film.getCountry().getId()})")
    Boolean exists(@Param("film") Film film);
    
    @Query("SELECT f FROM Film f JOIN f.actors a WHERE a.id=:id")
    Iterable<Film> findFilmsByActorId(Long id);

    @Query("SELECT f FROM Film f JOIN f.director d WHERE d.id=:id")
    Iterable<Film> findFilmsByDirectorId(Long id);

    @Query("SELECT f FROM Film f JOIN f.country c WHERE c.id=:id")
    Iterable<Film> findFilmsByCountryId(Long id);

    @Query("SELECT f FROM Film f JOIN f.genres g WHERE g.id=:id")
    Iterable<Film> findFilmsWithGenreByGenreId(Long id);
}
