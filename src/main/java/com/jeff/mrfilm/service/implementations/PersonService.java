package com.jeff.mrfilm.service.implementations;

import com.jeff.mrfilm.entity.Person;
import com.jeff.mrfilm.repository.PersonRepository;
import com.jeff.mrfilm.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    public PersonRepository repository;

    public List<Person> findAll() {
        return (List<Person>) repository.findAll();
    }

    public Person insertPerson(Person person) {
        return repository.save(person);
    }
}
