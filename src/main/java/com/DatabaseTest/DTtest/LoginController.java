/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DatabaseTest.DTtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author deimo
 */
@RestController
@CrossOrigin(origins = "https://front-endargprograma2.web.app")
public class LoginController {
    
    @Autowired IuserService interUser;
    
    @PostMapping("/Register")
    public void registerUser(@RequestBody User req){
        System.out.println(req.getUsername() + req.getPassword());
        interUser.saveUser(req);
    }
    
    @PostMapping("/Login")
    public boolean loginUser(@RequestBody User req){
        if(req.IsEmpty())
         return false;
        User user = interUser.findUserWithName(req.getUsername());
        
        return !user.IsEmpty() && user.IsEqual(req);
    }
    
    @PostMapping("/SaveChanges")
    public void saveChanges(@RequestBody User req){
        interUser.uploadTextChange(req);
    }
}
