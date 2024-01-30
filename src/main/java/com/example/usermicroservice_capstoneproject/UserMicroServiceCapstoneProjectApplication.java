package com.example.usermicroservice_capstoneproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UserMicroServiceCapstoneProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMicroServiceCapstoneProjectApplication.class, args);
    }

}
