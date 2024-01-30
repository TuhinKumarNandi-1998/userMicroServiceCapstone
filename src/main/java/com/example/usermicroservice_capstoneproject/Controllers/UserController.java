package com.example.usermicroservice_capstoneproject.Controllers;

import com.example.usermicroservice_capstoneproject.Exceptions.NoSuchUserException;
import com.example.usermicroservice_capstoneproject.Models.User;
import com.example.usermicroservice_capstoneproject.Services.SelfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private SelfUserService selfUserService;

    @Autowired
    public UserController(SelfUserService userService) {
        this.selfUserService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return selfUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getSingleUser(@PathVariable("id") long id) throws NoSuchUserException {
        return selfUserService.getSingleUser(id);
    }

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return selfUserService.addUser(user);
    }

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable("id") long id, @RequestBody User user) throws NoSuchUserException {
        return selfUserService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        selfUserService.deleteUser(id);
    }
}
