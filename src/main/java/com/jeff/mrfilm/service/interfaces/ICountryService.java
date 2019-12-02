package com.jeff.mrfilm.service.interfaces;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Country;
import com.jeff.mrfilm.entity.Director;
import com.jeff.mrfilm.entity.Film;

import java.util.List;

public interface ICountryService {

    List<Country> findAll();

    Country findCountryById(Long id);

    Country saveCountry(Country country);
}
