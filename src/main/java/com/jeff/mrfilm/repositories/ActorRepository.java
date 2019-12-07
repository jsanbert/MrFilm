package com.jeff.mrfilm.repositories;

import com.jeff.mrfilm.entities.Actor;
import com.jeff.mrfilm.entities.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    @Query("SELECT COUNT(a) > 0 FROM Actor a " +
            "WHERE a.id = :#{#actor.getId()} " +
            "OR " +
            "LOWER(TRIM(a.name)) = LOWER(TRIM(:#{#actor.getName()}))")
    Boolean exists(@Param("actor") Actor actor);
    
    @Query("SELECT a FROM Actor a JOIN a.films f WHERE f.id=:id")
    Iterable<Actor> findActorsByFilmId(Long id);

    @Query("SELECT a FROM Actor a JOIN a.country c WHERE c.id=:id")
    Iterable<Actor> findActorsByCountryId(Long id);
}
