package com.webservice.workshop_mongo.services;

import com.webservice.workshop_mongo.domain.Post;
import com.webservice.workshop_mongo.exceptions.ObjectNotFoundException;
import com.webservice.workshop_mongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findPost(String id){
        return postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }
}
