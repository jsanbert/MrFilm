package com.jeff.mrfilm.services.implementations;

import com.jeff.mrfilm.entities.Country;
import com.jeff.mrfilm.repositories.CountryRepository;
import com.jeff.mrfilm.repositories.FilmRepository;
import com.jeff.mrfilm.services.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    @Autowired
    public CountryRepository countryRepository;

    @Autowired
    public FilmRepository filmRepository;

    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    public Country findCountryById(Long id) { return countryRepository.findById(id).orElse(null); }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountryById(Long id) {
        countryRepository.deleteById(id);
    }
}
