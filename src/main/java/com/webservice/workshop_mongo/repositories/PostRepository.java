package com.webservice.workshop_mongo.repositories;


import com.webservice.workshop_mongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
