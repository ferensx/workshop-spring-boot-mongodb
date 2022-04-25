package com.ferens.workshopmongo.services;

import com.ferens.workshopmongo.domain.User;
import com.ferens.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
//DEPENDENCIA AUTOMATICA DO SPRING \/ AUTOWIRED
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();


    }

}
