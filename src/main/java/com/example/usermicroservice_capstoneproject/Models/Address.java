package com.example.usermicroservice_capstoneproject.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address extends BaseModel {
    private String city;
    private String street;
    private Integer number;
    private String zipCode;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private GeoLocation geoLocation;
}
