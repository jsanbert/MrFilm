package com.jeff.mrfilm.repositories;

import com.jeff.mrfilm.entities.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    @Query("SELECT a FROM Actor a JOIN a.films f WHERE f.id=:id")
    Iterable<Actor> findActorsByFilmId(Long id);

    @Query("SELECT a FROM Actor a JOIN a.country c WHERE c.id=:id")
    Iterable<Actor> findActorsByCountryId(Long id);
}
