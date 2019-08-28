/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wenchao
 */
@Entity
@Table(name = "USER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = User.GET_PASSWD_ACCORDING_EMAIL_QUERY_NAME, query ="SELECT u FROM User u WHERE u.email=:email"),
                @NamedQuery(name = User.GET_MAX_ID_QUERY_NAME, query ="SELECT u FROM User u"),
                @NamedQuery(name = User.SEARCH_ALL, query ="SELECT u from User u"),
                })
public class User implements Serializable {

   

    public static final String GET_PASSWD_ACCORDING_EMAIL_QUERY_NAME = "User.getPasswdByEmail";
    public static final String GET_MAX_ID_QUERY_NAME = "User.getMaxID";
    public static final String SEARCH_ALL = "User.searchAll";
//necessary fields
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer userId;
    
//    @Column(name = "email")
    @Pattern(regexp = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;
//    @Column(name = "password")
    private String password;
//    @Column(name = "membershiplevel")
    @NotNull
    private String membershipLevel;
    
    // except Visitor
//    @Column(name = "lastname")
    private String lastName;
//    @Column(name = "firstname")
    private String firstName;
//    @Column(name = "address")
    private String address;
//    @Column(name = "phonenumber")
    private String phoneNumer;
    
    //optional demographic fields
//    @Column(name = "age")
    private Integer age;
//    @Column(name = "gender")
    private String gender;
//    @Column(name = "favormovie")
    private String favorMovie;
    
    @OneToMany(mappedBy = "user")
    private Collection<Product> products;
    @OneToMany(mappedBy = "user")
    private Collection<Transaction> transactions;
    
    final static String MEMBERSHIP="Visitor";
    
    //new register, default level “Vistor”
    public User() {
        // ID should be assigned according to number of user in user table
    }
    public User(int userID, String email, String password) {
        // ID should be assigned according to number of user in user table
        this.userId = userID;
        this.email = email; 
        this.password = password;
        this.membershipLevel = MEMBERSHIP;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumer() {
        return phoneNumer;
    }

    public String getAddress() {
        return address;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFavorMovie() {
        return favorMovie;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }
    
    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
 
    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFavorMovie(String favorMovie) {
        this.favorMovie = favorMovie;
    }
    /**
     * @return the transactions
     */

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }
//    @Override
//    public String toString() {
//        return "User{" + "userID=" + userID + ", email=" + email + ", password=" + password + ", membershipLevel=" + membershipLevel + ", lastName=" + lastName + ", firstName=" + firstName + ", address=" + address + ", phoneNumer=" + phoneNumer + ", previlege=" + previlege + ", age=" + age + ", gender=" + gender + ", favorMovie=" + favorMovie + ", products=" + products + '}';
//    }
    
}
