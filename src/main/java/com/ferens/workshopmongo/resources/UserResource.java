package com.ferens.workshopmongo.resources;

import com.ferens.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//RECURSO REST CAMINHO DO ANDPOINT
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    //COLOQUEI RESPONSE . ENTITY DEPOIS Q CRIEI A LISTA E IMPLEMENTEI PARA ARRUMAR ERROS HTTP
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User juvenal = new User("2", "Juvenal Silva", "juvenal@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, juvenal));
        return ResponseEntity.ok().body(list);

    }
}
