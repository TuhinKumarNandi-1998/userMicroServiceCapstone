package com.example.usermicroservice_capstoneproject.Services;

import com.example.usermicroservice_capstoneproject.Exceptions.NoSuchUserException;
import com.example.usermicroservice_capstoneproject.Models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getSingleUser(long id) throws NoSuchUserException;

    public User addUser(User user);

    public User updateUser(long id, User user) throws NoSuchUserException;

    public void deleteUser(long id);
}
