package com.ferens.workshopmongo.resources;

import com.ferens.workshopmongo.domain.Post;
import com.ferens.workshopmongo.domain.User;
import com.ferens.workshopmongo.dto.UserDTO;
import com.ferens.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));

    }

    @RequestMapping(method = RequestMethod.POST)
    //void pq retor objeto vazio ADD USUARIO
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    //PARA DELETAR USUARIO LIGADA COM USER SERVICE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        //para mudar  a resposta no postman lá codigo 204 usa noCotent
        return ResponseEntity.noContent().build();

    }
    // LIGADO COM UPDATE  LA EM USER SERVICE

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    //void pq retor objeto vazio ADD USUARIO É UMA MISTURA DE  DELETAR COM ADD
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());

    }
}

