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

}
