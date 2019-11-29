package com.jeff.mrfilm.repository;

import com.jeff.mrfilm.entity.Director;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {

}
