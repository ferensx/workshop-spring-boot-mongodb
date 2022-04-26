package com.ferens.workshopmongo.services;

import com.ferens.workshopmongo.domain.User;
import com.ferens.workshopmongo.repository.UserRepository;
import com.ferens.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();


    }
        // LIGADO COM OS EXCEPTIONS DE SERVICE E  RESOURCES .ESSA MSG APARECE NO ERORR 404
    public User findById(String id) {

        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));

    }

}
