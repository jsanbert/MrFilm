package com.jeff.mrfilm.service.interfaces;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Director;
import com.jeff.mrfilm.entity.Person;

import java.util.List;

public interface IPersonService {

    List<Person> findAllPersons();
    List<Actor> findAllActors();
    List<Director> findAllDirectors();

    Director saveDirector(Director director);
    Actor saveActor(Actor actor);
}
