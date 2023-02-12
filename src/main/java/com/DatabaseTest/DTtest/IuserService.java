/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DatabaseTest.DTtest;

import java.util.List;

/**
 *
 * @author deimo
 */
public interface IuserService {
    public List<User> getUsers();
    
    public void saveUser(User perso);
    
    public void deleteUser (Long id);
    
    public User findUser (Long id);
    
    public User findUserWithName(String name);
    
    public Boolean uploadTextChange(TextMod data);
}
