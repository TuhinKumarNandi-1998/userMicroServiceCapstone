package com.example.usermicroservice_capstoneproject.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Users")
public class User extends BaseModel {
    private String email;
    private String userName;
    private String password;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Name name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Address address;
    private String phoneNo;

}
