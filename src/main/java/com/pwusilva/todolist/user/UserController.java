package com.pwusilva.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.sym.Name;

@RestController
@RequestMapping("/users")
public class UserController {
    

    @PostMapping("/")
    public void Create(@RequestBody UserModel userModel)
    {
        System.out.println(userModel.getName());
        System.out.println(userModel.getPassword());
        System.out.println(userModel.getUsername());
    }
}