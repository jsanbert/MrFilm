package com.jeff.mrfilm.services;

import com.jeff.mrfilm.entities.Actor;
import com.jeff.mrfilm.entities.Director;
import com.jeff.mrfilm.entities.Genre;
import com.jeff.mrfilm.entities.Person;
import com.jeff.mrfilm.errors.exceptions.ResourceException;
import com.jeff.mrfilm.repositories.ActorRepository;
import com.jeff.mrfilm.repositories.DirectorRepository;
import com.jeff.mrfilm.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    public PersonRepository personRepository;

    @Autowired
    public ActorRepository actorRepository;

    @Autowired
    public DirectorRepository directorRepository;

    //  ============== PEOPLE ================
    public List<Person> findAllPeople() {
        return (List<Person>) personRepository.findAll();
    }

    //  ============== ACTORS ================
    public List<Actor> findAllActors() {
        return (List<Actor>) actorRepository.findAll();
    }

    public List<Actor> findActorsByFilmId(Long id) { return (List<Actor>) actorRepository.findActorsByFilmId(id); }
    public List<Actor> findActorsByCountryId(Long id) { return (List<Actor>) actorRepository.findActorsByCountryId(id); }

    public Actor findActorById(Long id) throws ResourceException {
        Actor actor = actorRepository.findById(id).orElse(null);
        if(actor != null)
            return actor;
        else
            throw new ResourceException(id, Actor.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public Actor insertActor(Actor actor) {
        if(actor.getId() != null || actorRepository.exists(actor))
            throw new ResourceException(actor.getId(), Actor.class.getSimpleName(), ResourceException.ALREADY_EXISTS);
        else
            return actorRepository.save(actor);
    }

    public Actor updateActor(Actor actor) {
        if(actorRepository.exists(actor))
            return actorRepository.save(actor);
        else
            throw new ResourceException(actor.getId(), Actor.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public void deleteActorById(Long id) {
        if(actorRepository.existsById(id))
            actorRepository.deleteById(id);
        else
            throw new ResourceException(id, Actor.class.getSimpleName(), ResourceException.NOT_FOUND);
    }
    

    //  ============== DIRECTORS ================
    public List<Director> findAllDirectors() {
        return (List<Director>) directorRepository.findAll();
    }
    public Director findDirectorById(Long id) { return (Director) directorRepository.findById(id).orElse(null); }
    public List<Director> findDirectorsByCountryId(Long id) { return (List<Director>) directorRepository.findDirectorsByCountryId(id); }
    public void deleteDirectorById(Long id) { directorRepository.deleteById(id); }
    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }
}
