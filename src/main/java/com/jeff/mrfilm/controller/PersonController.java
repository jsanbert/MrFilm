package com.jeff.mrfilm.controller;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.service.implementations.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("{mrfilm.api.prefix}")
public class PersonController {
    @Autowired
    PersonService personService;


    @GetMapping("/actors")
    public List<Actor> getAllActors() {
        return personService.findAllActors();
    }
}
