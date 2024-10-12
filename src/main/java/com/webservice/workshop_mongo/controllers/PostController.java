package com.webservice.workshop_mongo.controllers;

import com.webservice.workshop_mongo.domain.Post;
import com.webservice.workshop_mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findPost(@PathVariable String id){
        Post post = postService.findPost(id);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }
}
