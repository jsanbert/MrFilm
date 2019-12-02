package com.jeff.mrfilm.repository;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Director;
import com.jeff.mrfilm.entity.Film;
import com.jeff.mrfilm.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("SELECT a FROM Actor a JOIN a.films f WHERE f.id=:id")
    Iterable<Actor> findActorsByFilmId(Long id);

    @Query("SELECT a FROM Actor a JOIN a.country c WHERE c.id=:id")
    Iterable<Actor> findActorsByCountryId(Long id);

    @Query("SELECT d FROM Director d JOIN d.country c WHERE c.id=:id")
    Iterable<Director> findDirectorsByCountryId(Long id);
}
