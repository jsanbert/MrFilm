package com.jeff.mrfilm.controller;

import com.jeff.mrfilm.entity.Actor;
import com.jeff.mrfilm.entity.Person;
import com.jeff.mrfilm.service.implementations.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("{mrfilm.api.prefix}")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/actors")
    public CollectionModel<Actor> getAllActors() {
        List<Actor> allActors = personService.findAllActors();
        for(Actor actor : allActors) {
            Link selfLink = linkTo(methodOn(PersonController.class)
                    .getActorById(actor.getId())).withSelfRel();
            actor.add(selfLink);
        }
        Link link = linkTo(PersonController.class).withSelfRel();
        CollectionModel<Actor> result = new CollectionModel<>(allActors, link);
        return result;
    }

    @GetMapping("/actors/{id}")
    public CollectionModel<Actor> getActorById(@PathVariable Long id) {

        return null;
    }

    /*

    @GetMapping(produces = { "application/hal+json" })
public Resources<Customer> getAllCustomers() {
    List<Customer> allCustomers = customerService.allCustomers();

    for (Customer customer : allCustomers) {
        String customerId = customer.getCustomerId();
        Link selfLink = linkTo(CustomerController.class).slash(customerId).withSelfRel();
        customer.add(selfLink);
        if (orderService.getAllOrdersForCustomer(customerId).size() > 0) {
            Link ordersLink = linkTo(methodOn(CustomerController.class)
              .getOrdersForCustomer(customerId)).withRel("allOrders");
            customer.add(ordersLink);
        }
    }

    Link link = linkTo(CustomerController.class).withSelfRel();
    Resources<Customer> result = new Resources<Customer>(allCustomers, link);
    return result;
}
     */
}
