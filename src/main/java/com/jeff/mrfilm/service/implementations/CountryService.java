package com.jeff.mrfilm.service.implementations;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Country;
import com.jeff.mrfilm.entity.Director;
import com.jeff.mrfilm.entity.Film;
import com.jeff.mrfilm.repository.CountryRepository;
import com.jeff.mrfilm.service.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    @Autowired
    public CountryRepository repository;

    public List<Country> findAll() {
        return (List<Country>) repository.findAll();
    }

    public Country findCountryById(Long id) { return repository.findById(id).orElse(null); }

    public Country saveCountry(Country country) {
        return repository.save(country);
    }
}
