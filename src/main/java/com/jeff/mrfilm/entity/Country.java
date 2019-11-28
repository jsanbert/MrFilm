package com.jeff.mrfilm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    @OneToMany(mappedBy = "country")
    private List<Person> persons;

    public Country() { }

    public Country(String name) {
        this.name = name;
    }


}
