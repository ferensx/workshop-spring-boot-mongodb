package com.ferens.workshopmongo.services;

import com.ferens.workshopmongo.domain.Post;

import com.ferens.workshopmongo.repository.PostRepository;

import com.ferens.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);

            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        }

        public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);

    }}

