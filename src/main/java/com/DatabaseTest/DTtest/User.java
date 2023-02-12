/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DatabaseTest.DTtest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author deimo
 */
@Getter @Setter
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE)
    private long id;
    private String username;
    private String password;
    private String textMod1;
    private String textMod2;
    
    public User()
    {
        username = "";
        password = "";
    }
    
    public boolean IsEmpty(){
        return username.isEmpty()&& password.isEmpty();
    }
    
    public boolean IsEqual(User user){
        return username.equals(user.username) && password.equals(user.password);
    }
}
