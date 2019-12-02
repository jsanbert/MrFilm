package com.jeff.mrfilm.repository;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Country;
import com.jeff.mrfilm.entity.Director;
import com.jeff.mrfilm.entity.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
