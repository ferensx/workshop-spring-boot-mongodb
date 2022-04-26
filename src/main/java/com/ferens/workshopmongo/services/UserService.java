package com.ferens.workshopmongo.services;

import com.ferens.workshopmongo.domain.User;
import com.ferens.workshopmongo.dto.UserDTO;
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
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

    }
//inserir usario
    public User insert(User obj) {
        return repo.insert(obj);
    }
    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }
    public User update(User obj){
        User newObj = findById(obj.getId());
        //update data responsavel para att o obj para o newobj
        updateData(newObj ,obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
