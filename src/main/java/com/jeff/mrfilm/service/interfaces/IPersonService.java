package com.jeff.mrfilm.service.interfaces;

import com.jeff.mrfilm.entity.Person;

import java.util.List;

public interface IPersonService {

    List<Person> findAll();
    Person insertPerson(Person person);
}
