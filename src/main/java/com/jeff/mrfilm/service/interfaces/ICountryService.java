package com.jeff.mrfilm.service.interfaces;

import com.jeff.mrfilm.entity.Country;

import java.util.List;

public interface ICountryService {

    List<Country> findAll();
    Country insertCountry(Country country);
}
