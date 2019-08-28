/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import com.entity.Previlege;
import com.entity.User;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Wenchao
 */
@Remote
public interface UserBeanService {
    
    //Register as a new user, include 4 necessary details
    //int userID, String email, String passwd
    public void add(User user);
    
    //enter addtional personal details in Web form, except Visitor
    //String lastName, String firstName, String address, String phoneNumer, int age, String gender, String favorMovie
    
    //Remove a user, priviledge of Administor 
    public void delete(Integer userID);
    
    User searchByID(Integer id);    

    List<User> searchByEmail(String email);
    
    // except email address and passwd 
    //String lastName, String firstName, String address
    public void updateDetails(User user);
    
    public int login(String email, String passwd);
    
    public Integer getMaxID();
    
    public List<User> searchByMultiAttributes(Map<String, Object> conditions);
    
    public List<User> searchAll();
}
