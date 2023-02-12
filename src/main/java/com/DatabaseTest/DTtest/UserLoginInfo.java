/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DatabaseTest.DTtest;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jojo
 */
@Getter @Setter
public class UserLoginInfo 
{
    private boolean success;
    private String textMod1;
    private String textMod2;
    
    public UserLoginInfo()
    {
        this.success = false;
        this.textMod1 = "";
        this.textMod2 = "";
    }
}