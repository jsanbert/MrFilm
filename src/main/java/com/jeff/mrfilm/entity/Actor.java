package com.jeff.mrfilm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "actors")
public class Actor extends Person {
    @Column
    private String mainRole;

    public Actor() { }

    public Actor(String mainRole) {
        this.mainRole = mainRole;
    }

    public Actor(Long id, String name, String surname, Integer age, Country country, String mainRole) {
        super(id, name, surname, age, country);
        this.mainRole = mainRole;
    }

    public String getMainRole() {
        return mainRole;
    }

    public void setMainRole(String mainRole) {
        this.mainRole = mainRole;
    }
}
