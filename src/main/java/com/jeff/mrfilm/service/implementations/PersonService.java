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

    // ACTORS
    public List<Actor> findAllActors() {
        return (List<Actor>) actorRepository.findAll();
    }
    public List<Person> findAllPeople() {
        return (List<Person>) personRepository.findAll();
    }
    public Actor findActorById(Long id) { return (Actor) actorRepository.findById(id).orElse(null); }
    public List<Actor> findActorsByFilmId(Long id) { return (List<Actor>) actorRepository.findActorsByFilmId(id); }
    public List<Actor> findActorsByCountryId(Long id) { return (List<Actor>) actorRepository.findActorsByCountryId(id); }
    public void deleteActorById(Long id) { actorRepository.deleteById(id); }
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    // DIRECTORS
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
