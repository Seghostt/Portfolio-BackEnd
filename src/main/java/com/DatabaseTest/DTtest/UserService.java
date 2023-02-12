/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DatabaseTest.DTtest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deimo
 */
@Service
public class UserService implements IuserService{
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<User> getUsers(){
        List<User> listaPersonas = userRepository.findAll();
        return listaPersonas;
    }
    
    @Override
    public void saveUser(User perso){
        userRepository.save(perso);
    }
    
    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    
    @Override
    public User findUser(Long id){
        User user = userRepository.findById(id).orElse(null);
                return user;
    }
    
    @Override
    public User findUserWithName(String name){
        var users = userRepository.findByUsername(name);
        if(users.size() == 1){
            return users.get(0);
        }
        return null;    
    }
    
    @Override
    public Boolean uploadTextChange(TextMod data)
    {
        int ret = 0;
        if(data.getIndex() == 0)
            ret = userRepository.updateTextMod1(data.getUsername(), data.getText());
        else
            ret = userRepository.updateTextMod2(data.getUsername(), data.getText());
        
        if(ret == 1)
        {
            System.out.println("Success Updated Text from backend");
            return true;
        }
        return false;
    }
}