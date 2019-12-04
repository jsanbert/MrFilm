package com.jeff.mrfilm.services.interfaces;

import com.jeff.mrfilm.entities.Country;

import java.util.List;

public interface ICountryService {

    List<Country> findAll();

    Country findCountryById(Long id);
    Country saveCountry(Country country);
    void deleteCountryById(Long id);
}
