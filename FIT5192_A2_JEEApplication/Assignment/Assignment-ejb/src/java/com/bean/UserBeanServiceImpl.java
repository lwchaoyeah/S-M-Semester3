/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.api.UserBeanService;
import com.entity.User;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Wenchao
 */
@Stateless
public class UserBeanServiceImpl implements UserBeanService{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void delete(Integer userID) {
        User user = this.searchByID(userID);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public User searchByID(Integer id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public List<User> searchByEmail(String email) {
        List<User> user;
        user = em.createNamedQuery(User.GET_PASSWD_ACCORDING_EMAIL_QUERY_NAME).setParameter("email", email).getResultList();
        return user;
    }

    @Override
    public void updateDetails(User user) {
       em.merge(user);
    }

    @Override
    public int login(String email, String passwd) {
        List<User> user=this.searchByEmail(email);
        int i = user.size();
        if (i==0){
            return 0;
        }
        if (passwd.equals(user.get(0).getPassword())) {
            return 1;
        }
        else return 0;
    }
    
    @Override
    public Integer getMaxID(){
        Integer maxID;
        List<User> user;
        user = em.createNamedQuery(User.GET_MAX_ID_QUERY_NAME).getResultList();
        int num=user.size();
        if (num!=0) {
            maxID=user.get(num-1).getUserId();
        }
        // There hasn't been any user in system
        else{
            maxID=0;
        }
        return maxID;
    }
    
    @Override
    public List<User> searchByMultiAttributes(Map<String, Object> conditions) {
        StringBuilder builder = new StringBuilder("SELECT u from User u where ");
        for (Map.Entry<String,Object> entry: conditions.entrySet()){
            String s;
            if(entry.getKey().equals("lastName")){
                s = "u.lastName = :"+(String)(entry.getKey())+" and ";
            }
            else if(entry.getKey().equals("firstName")){
                s = "u.firstName = :"+(String)(entry.getKey())+" and ";
            }
            else{
                s = "u.phoneNumer = :"+(String)(entry.getKey())+" and ";
            }
            builder.append(s);
        }
        String jpql = builder.toString();      //erase " and " 5 length
        jpql=jpql.substring(0, jpql.length() - 5);
        Query q=em.createQuery(jpql, User.class);
        for (Map.Entry<String,Object> entry: conditions.entrySet()){
            q.setParameter(entry.getKey(), entry.getValue());
        }
        List<User> userList= q.getResultList();
        for(User user:userList){
            user.getTransactions().size();
            user.getProducts().size();
        }
        return userList;
    }

    @Override
    public List<User> searchAll() {
        List<User> userList =em.createNamedQuery(User.SEARCH_ALL).getResultList();
        for(User user:userList){
            user.getTransactions().size();
            user.getProducts().size();
        }
        return userList;
    }
}
