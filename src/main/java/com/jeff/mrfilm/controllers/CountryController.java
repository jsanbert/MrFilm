package com.jeff.mrfilm.controllers;

import com.jeff.mrfilm.entities.*;
import com.jeff.mrfilm.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${mrfilm.api.baseurl}")

public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(value = "/countries")
    public List<Country> getAllCountries() {
        return countryService.findAll();
    }

    @GetMapping(value = "/countries/{id}")
    public Country getCountryById(@PathVariable Long id) {
        return countryService.findCountryById(id);
    }

    @PostMapping(value = "/countries/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Country addCountry(@RequestBody @Valid Country country) {
        return countryService.insertCountry(country);
    }

    @PutMapping(value = "/countries/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country) {
        country.setId(id);
        return countryService.insertCountry(country);
    }

    @DeleteMapping(value = "/countries/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountryById(id);
    }
}
