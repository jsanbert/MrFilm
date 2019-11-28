package com.jeff.mrfilm.repository;

import com.jeff.mrfilm.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

}
