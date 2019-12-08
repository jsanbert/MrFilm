package com.jeff.mrfilm.repositories;

import com.jeff.mrfilm.entities.Actor;
import com.jeff.mrfilm.entities.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {
    @Query("SELECT COUNT(d) > 0 FROM Director d " +
            "WHERE d.id = :#{#director.getId()} " +
            "OR (" +
            "LOWER(TRIM(d.name)) = LOWER(TRIM(:#{#director.getName()})) " +
            "AND " +
            "LOWER(TRIM(d.surname)) = :#{#director.getSurname()})")
    Boolean exists(@Param("director") Director director);
    
    @Query("SELECT d FROM Director d JOIN d.country c WHERE c.id=:id")
    Iterable<Director> findDirectorsByCountryId(Long id);

    @Query("SELECT d FROM Director d JOIN d.films f WHERE f.id=:id")
    Director findDirectorByFilmId(Long id);
}
