package com.example.usermicroservice_capstoneproject.Services;

import com.example.usermicroservice_capstoneproject.Exceptions.NoSuchUserException;
import com.example.usermicroservice_capstoneproject.Models.User;
import com.example.usermicroservice_capstoneproject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfUserService implements UserService {

    private UserRepository userRepository;

    @Autowired
    public SelfUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getSingleUser(long id) throws NoSuchUserException {
        Optional<User> optionalUser = userRepository.findUserById(id);

        if(optionalUser.isEmpty()) {
            throw new NoSuchUserException("User with id "+id+" not found in DB.");
        }
        return optionalUser.get();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(long id, User user) throws NoSuchUserException {
        Optional<User> optionalUser = userRepository.findUserById(id);
        if(optionalUser.isEmpty()) {
            throw new NoSuchUserException("User with id "+id+" not found in DB.");
        }
        User userInDB = optionalUser.get();
        if(user.getUserName() != null) {
            userInDB.setUserName(user.getUserName());
        }
        if(user.getEmail() != null) {
            userInDB.setEmail(user.getEmail());
        }
        if(user.getPassword() != null) {
            userInDB.setPassword(user.getPassword());
        }
        if(user.getName() != null) {
            if(user.getName().getFirstName() != null){
                userInDB.getName().setFirstName(user.getName().getFirstName());
            }
            if(user.getName().getLastName() != null){
                userInDB.getName().setLastName(user.getName().getLastName());
            }
        }
        if(user.getAddress() != null) {
            if(user.getAddress().getCity() != null){
                userInDB.getAddress().setCity(user.getAddress().getCity());
            }
            if(user.getAddress().getStreet() != null){
                userInDB.getAddress().setStreet(user.getAddress().getStreet());
            }
            if(user.getAddress().getNumber() != null) {
                userInDB.getAddress().setNumber(user.getAddress().getNumber());
            }
            if(user.getAddress().getGeoLocation() != null){
                if(user.getAddress().getGeoLocation().getLatitude() != null) {
                    userInDB.getAddress().getGeoLocation().setLatitude(user.getAddress().getGeoLocation().getLatitude());
                }
                if(user.getAddress().getGeoLocation().getLongitude() != null) {
                    userInDB.getAddress().getGeoLocation().setLongitude(user.getAddress().getGeoLocation().getLongitude());
                }
            }
            if(user.getAddress().getZipCode() != null) {
                userInDB.getAddress().setZipCode(user.getAddress().getZipCode());
            }
        }
        if(user.getPhoneNo() != null) {
            userInDB.setPhoneNo(userInDB.getPhoneNo());
        }
        return userRepository.save(userInDB);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
