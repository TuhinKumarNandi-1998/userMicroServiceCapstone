package com.example.usermicroservice_capstoneproject.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GeoLocation extends BaseModel {
    private String latitude;
    private String longitude;
}
