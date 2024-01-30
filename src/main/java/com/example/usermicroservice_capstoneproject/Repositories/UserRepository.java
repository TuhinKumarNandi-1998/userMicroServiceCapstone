package com.example.usermicroservice_capstoneproject.Repositories;

import com.example.usermicroservice_capstoneproject.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    Optional<User> findUserById(Long id);

    User save(User user);

    void deleteById(long id);
}
