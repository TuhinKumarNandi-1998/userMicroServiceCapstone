package com.example.usermicroservice_capstoneproject.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Names")
public class Name extends BaseModel{
    private String firstName;
    private String lastName;
}
