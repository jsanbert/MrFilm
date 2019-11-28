package com.jeff.mrfilm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country implements Serializable {
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    @OneToMany(mappedBy = "country")
    private List<Person> persons;
}
