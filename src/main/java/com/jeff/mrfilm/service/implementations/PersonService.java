package com.jeff.mrfilm.service.implementations;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Director;
import com.jeff.mrfilm.entity.Person;
import com.jeff.mrfilm.repository.ActorRepository;
import com.jeff.mrfilm.repository.DirectorRepository;
import com.jeff.mrfilm.repository.PersonRepository;
import com.jeff.mrfilm.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    public PersonRepository personRepository;

    @Autowired
    public ActorRepository actorRepository;

    @Autowired
    public DirectorRepository directorRepository;

    public List<Person> findAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> findAllActors() {
        return (List<Actor>) actorRepository.findAll();
    }

    public List<Director> findAllDirectors() {
        return (List<Director>) directorRepository.findAll();
    }
}
