package com.jeff.mrfilm.service.interfaces;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Director;
import com.jeff.mrfilm.entity.Person;

import java.util.List;

public interface IPersonService {

    List<Person> findAllPeople();

    List<Actor> findAllActors();
    Actor findActorById(Long id);
    List<Actor> findActorsByFilmId(Long id);
    List<Actor> findActorsByCountryId(Long id);

    List<Director> findAllDirectors();
    List<Director> findDirectorsByCountryId(Long id);
    Director findDirectorById(Long id);

    Actor saveActor(Actor actor);
    void deleteActorById(Long id);

    Director saveDirector(Director director);
    void deleteDirectorById(Long id);


}
