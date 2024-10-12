package com.webservice.workshop_mongo.DTOs;

import com.webservice.workshop_mongo.domain.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;


public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(@NotNull User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
