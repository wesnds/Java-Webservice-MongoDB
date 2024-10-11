package com.webservice.workshop_mongo.controllers;

import com.webservice.workshop_mongo.domain.User;
import com.webservice.workshop_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> userList = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }
}
