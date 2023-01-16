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
    
//    static final String DB_URL = "jdbc:mysql://localhost:3306/prueba_jpa?useSSL=false&serverTimezone=UTC";
//    static final String USER = "admin";  
//    static final String PASS = "admin";
//    static  String Query = "";
    
    @Override
    public void uploadTextChange(User user){
//         try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//         Statement stmt = conn.createStatement();)
//         {
//             //String fetchsql = "SELECT * FROM user WHERE username ="+ user.getUsername() + "" ;
//             Query = "UPDATE `user` SET `id`='" + user.getId() +"',`password`='" + user.getPassword() +"',`username`= '"+ user.getUsername()+"',`text_mod`='"+ user.getTextMod() +"',`text_mod2`='"+ user.getTextMod2() +"' WHERE username = '"+user.getUsername()+"'";
//             stmt.executeUpdate(Query);
//                      
//         }   
//         catch (SQLException ex) {
//            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
    }   
}
