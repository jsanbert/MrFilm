package com.jeff.mrfilm.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PersonDTO {

    private Long id;

    @NotEmpty(message = "{validation.notemptyornull}")
    private String name;

    @NotEmpty(message = "{validation.notemptyornull}")
    private String surname;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{validation.notemptyornull}")
    private Date birthDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "{validation.notemptyornull}")
    private Long countryId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String country;

    public PersonDTO(Long id, @NotEmpty(message = "{validation.notemptyornull}") String name, @NotEmpty(message = "{validation.notemptyornull}") String surname, @NotNull(message = "{validation.notemptyornull}") Date birthDate, @NotNull(message = "{validation.notemptyornull}") Long countryId, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.countryId = countryId;
        this.country = country;
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

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
