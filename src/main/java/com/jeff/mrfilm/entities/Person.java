package com.jeff.mrfilm.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jeff.mrfilm.dto.PersonDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="people")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotEmpty(message = "{validation.notemptyornull}")
    private String name;

    @Column
    @NotEmpty(message = "{validation.notemptyornull}")
    private String surname;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{validation.notemptyornull}")
    private Date birthDate;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "country_id")
    @JsonBackReference(value = "peopleReference")
    private Country country;

    public Person() {}

    public Person(String name, String surname, Date birthDate, Country country) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        if(country != null) {
            this.country.removePerson(this);
            country.addPerson(this);
        }
        this.country = country;
    }
    
    public PersonDTO toPersonDTO() {
        return new PersonDTO(this.getId(), this.getName(), this.getSurname(), this.getBirthDate(), this.getCountry().getId(), this.getCountry().getName());
    }
}