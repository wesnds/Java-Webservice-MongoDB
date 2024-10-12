package com.webservice.workshop_mongo.controllers;

import com.webservice.workshop_mongo.DTOs.UserDTO;
import com.webservice.workshop_mongo.domain.User;
import com.webservice.workshop_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        List<User> userList = userService.findAllUsers();
//        List<UserDTO> userDTOList = userList.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        List<UserDTO> userDTOList = userList.stream().map(UserDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(userDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable String id){
        User user = userService.findUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        user = userService.registerUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserDTO uptUserDTO){
        User userDTO = userService.fromDTO(uptUserDTO);
        userDTO.setId(id);
        userDTO = userService.updateUser(userDTO);
        return ResponseEntity.noContent().build();
    }
}