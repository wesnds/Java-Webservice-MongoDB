package com.webservice.workshop_mongo.repositories;


import com.webservice.workshop_mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
