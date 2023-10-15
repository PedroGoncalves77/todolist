package com.pwusilva.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity Create(@RequestBody UserModel userModel)
    {
        var user = this.userRepository.findByUsername(userModel.getUsername());
        if (user != null)
        {
            System.out.println("Usuario existent");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario existente");
        }
        var hash = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
        userModel.setPassword(hash);
        

        var userCrearte = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Sucesso");

    }
}
