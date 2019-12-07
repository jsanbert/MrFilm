package com.jeff.mrfilm.services;

import com.jeff.mrfilm.entities.Country;
import com.jeff.mrfilm.errors.exceptions.ResourceException;
import com.jeff.mrfilm.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    public CountryRepository countryRepository;

    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    public Country findCountryById(Long id) throws ResourceException {
        Country country = countryRepository.findById(id).orElse(null);
        if(country != null)
            return country;
        else
            throw new ResourceException(id, Country.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public Country insertCountry(Country country) {
        if(country.getId() != null || countryRepository.exists(country))
            throw new ResourceException(country.getId(), Country.class.getSimpleName(), ResourceException.ALREADY_EXISTS);
        else
            return countryRepository.save(country);
    }

    public Country updateCountry(Country country) {
        if(countryRepository.exists(country))
            return countryRepository.save(country);
        else
            throw new ResourceException(country.getId(), Country.class.getSimpleName(), ResourceException.NOT_FOUND);
    }

    public void deleteCountryById(Long id) {
        if(countryRepository.existsById(id))
            countryRepository.deleteById(id);
        else
            throw new ResourceException(id, Country.class.getSimpleName(), ResourceException.NOT_FOUND);
    }
}
