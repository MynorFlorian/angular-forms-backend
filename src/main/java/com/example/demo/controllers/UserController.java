package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService; 

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ArrayList<UserModel> getUsers(){
        return this.userService.findAll();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String requestBodyJson = objectMapper.writeValueAsString(user);
            System.out.println("Request body received: " + requestBodyJson);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return this.userService.save(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.findById(id);
    }
    

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String requestBodyJson = objectMapper.writeValueAsString(request);
            System.out.println("Request body received: " + requestBodyJson);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        return this.userService.updateUserById(request, id);
    }
    
    // @DeleteMapping(path = "/{id}")
    // public String deleteUser(@PathVariable("id")  Long id ){
    //     boolean user_deleted = this.userService.deleteUser(id); 

    //     if (user_deleted) {
    //         return "Usuario " + id + " ha sido eliinado con exito.";
    //     } else {
    //         return "Ha ocurrido un error al intentar eliminar el usuario: " + id;
    //     }
    // }
    
}
