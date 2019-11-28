package com.jeff.mrfilm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "directors")
public class Director extends Person {
    @Column
    private Integer prizesWon;

    public Director() { }

    public Director(Integer prizesWon) {
        this.prizesWon = prizesWon;
    }

    public Director(Long id, String name, String surname, Integer age, Country country, Integer prizesWon) {
        super(id, name, surname, age, country);
        this.prizesWon = prizesWon;
    }

    public Integer getPrizesWon() {
        return prizesWon;
    }

    public void setPrizesWon(Integer prizesWon) {
        this.prizesWon = prizesWon;
    }
}
