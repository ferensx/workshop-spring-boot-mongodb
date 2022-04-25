package com.ferens.workshopmongo.resources;

import com.ferens.workshopmongo.domain.User;
import com.ferens.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

// AKI E O CONTROLADOR REST QUE ACESSA O SERVIÇO
//RECURSO REST CAMINHO DO ANDPOINT
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    //COLOQUEI RESPONSE . ENTITY DEPOIS Q CRIEI A LISTA E IMPLEMENTEI PARA ARRUMAR ERROS HTTP

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
}
