package com.jeff.mrfilm.repositories;

import com.jeff.mrfilm.entities.Country;
import com.jeff.mrfilm.entities.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    @Query("SELECT COUNT(g) > 0 FROM Genre g " +
            "WHERE g.id = :#{#genre.getId()} " +
            "OR " +
            "LOWER(TRIM(g.name)) = LOWER(TRIM(:#{#genre.getName()}))")
    Boolean exists(@Param("genre") Genre genre);
}
