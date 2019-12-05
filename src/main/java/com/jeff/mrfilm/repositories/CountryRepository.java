package com.jeff.mrfilm.repositories;

import com.jeff.mrfilm.entities.Country;
import com.jeff.mrfilm.entities.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    @Query("SELECT COUNT(c) > 0 FROM Country c " +
            "WHERE c.id = :#{#country.getId()} " +
            "OR " +
            "LOWER(TRIM(c.code)) = LOWER(TRIM(:#{#country.getCode()})) " +
            "OR " +
            "LOWER(TRIM(c.name)) = LOWER(TRIM(:#{#country.getName()}))")
    Boolean exists(@Param("country") Country country);
}
