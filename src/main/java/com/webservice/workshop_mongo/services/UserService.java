package com.webservice.workshop_mongo.services;

import com.webservice.workshop_mongo.domain.User;
import com.webservice.workshop_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
