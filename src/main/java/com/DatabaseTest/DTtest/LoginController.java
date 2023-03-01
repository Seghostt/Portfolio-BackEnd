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
    public Boolean registerUser(@RequestBody User req)
    {
        User user = interUser.findUserWithName(req.getUsername());
        if(user != null)
            return false;
        
        String default_text = "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Fugit, neque! Non, adipisci amet dolore cumque inventore, repudiandae ex ad fugit nemo ea laudantium dolorum pariatur recusandae. Atque quas animi modi!";  
        req.setTextMod1(default_text);
        req.setTextMod2(default_text);
        interUser.saveUser(req);
        return true;
    }
    
    @PostMapping("/Login")
    public UserLoginInfo loginUser(@RequestBody User req)
    {
        UserLoginInfo ret = new UserLoginInfo();
        if(req.IsEmpty())
            return ret;
        
        User user = interUser.findUserWithName(req.getUsername());
        if(user == null || user.IsEmpty() || !user.IsEqual(req))
            return ret;
        
        ret.setSuccess(true);
        ret.setTextMod1(user.getTextMod1());
        ret.setTextMod2(user.getTextMod2());
        return ret;
    }
    
    @PostMapping("/SaveChanges")
    public Boolean saveChanges(@RequestBody TextMod req)
    {
        interUser.uploadTextChange(req);
        return true;
    }
}
