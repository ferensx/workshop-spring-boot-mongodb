package com.ferens.workshopmongo.resources;

import com.ferens.workshopmongo.domain.Post;
import com.ferens.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
        private PostService service;





    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Post>> findById(@PathVariable String id) {
        Optional<Post> obj = Optional.ofNullable(service.findById(id));
        return ResponseEntity.ok().body(obj);

    }


}

