package com.jeff.mrfilm.repository;

import com.jeff.mrfilm.entity.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {
    @Query("SELECT d FROM Director d JOIN d.country c WHERE c.id=:id")
    Iterable<Director> findDirectorsByCountryId(Long id);
}
