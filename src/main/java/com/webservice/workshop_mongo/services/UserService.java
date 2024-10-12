package com.webservice.workshop_mongo.services;

import com.webservice.workshop_mongo.DTOs.UserDTO;
import com.webservice.workshop_mongo.domain.User;
import com.webservice.workshop_mongo.exceptions.ObjectNotFoundException;
import com.webservice.workshop_mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User registerUser(User newUser){
        return userRepository.insert(newUser);
    }

    public void deleteUser(String id){
        findUserById(id);
        userRepository.deleteById(id);
    }

    public User updateUser(User uptUser){
        User user = findUserById(uptUser.getId());
        updatedData(user, uptUser);
        return userRepository.save(uptUser);
    }

    private void updatedData(User user, User uptUser){
        user.setName(uptUser.getName());
        user.setEmail(uptUser.getEmail());
    }
/*
    Maybe to instantiate a user, db access is necessary and the service already has.
    So, thinking about a future maintenance where database access is required this will be done here
*/
    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

}
