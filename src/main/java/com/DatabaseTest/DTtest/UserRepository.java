/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DatabaseTest.DTtest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author deimo
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{
    List<User> findByUsername(String username);
    
    @Transactional @Modifying @Query(value = "UPDATE user u set u.text_mod1 = :text_mod where u.username = :username", nativeQuery = true)
    int updateTextMod1(@Param("username") String username, @Param("text_mod") String text_mod);
    
    @Transactional @Modifying @Query(value = "UPDATE user u set u.text_mod2 = :text_mod where u.username = :username", nativeQuery = true)
    int updateTextMod2(@Param("username") String username, @Param("text_mod") String text_mod);
}