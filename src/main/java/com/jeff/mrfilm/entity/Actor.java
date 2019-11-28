package com.jeff.mrfilm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor extends Person implements Serializable {

    @Column
    private String mainRole;

    @Column
    @ManyToMany(mappedBy = "actors")
    private List<Film> films;

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
