/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.entity.Product;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Wenchao
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    
    private Integer userID;
    private String email;
    private String passwd;
    private String rePasswd;
    private String membershipLevel;
    private String lastName;
    private String firstName;
    private String address;
    private String phoneNumber;
    private String contryCode;
    private String previlege;
    private Integer age;
    private String gender;
    private String favorMovie;
    
    private List<Product> products;
    private Integer productNumber;
    private HashMap<String,Integer> mapProductToNumber;
    
    // user management page
    private Integer searchedID;
    private String searchedEmail;
    private String searchedLastName;
    private String searchedFirstName;
    private String searchedPhoneNumber;
    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
        this.products=new ArrayList();
        this.mapProductToNumber = new HashMap<>();
    }

    public void setMapProductToNumber(HashMap<String, Integer> mapProductToNumber) {
        this.mapProductToNumber = mapProductToNumber;
    }

    public HashMap<String, Integer> getMapProductToNumber() {
        return mapProductToNumber;
    }
    
    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Integer getProductNumber() {
        return productNumber;
    }
    
    public Integer getSearchedID() {
        return searchedID;
    }

    public String getSearchedEmail() {
        return searchedEmail;
    }

    public String getSearchedLastName() {
        return searchedLastName;
    }

    public String getSearchedFirstName() {
        return searchedFirstName;
    }

    public String getSearchedPhoneNumber() {
        return searchedPhoneNumber;
    }

    public void setSearchedID(Integer searchedID) {
        this.searchedID = searchedID;
    }

    public void setSearchedEmail(String searchedEmail) {
        this.searchedEmail = searchedEmail;
    }

    public void setSearchedLastName(String searchedLastName) {
        this.searchedLastName = searchedLastName;
    }

    public void setSearchedFirstName(String searchedFirstName) {
        this.searchedFirstName = searchedFirstName;
    }

    public void setSearchedPhoneNumber(String searchedPhoneNumber) {
        this.searchedPhoneNumber = searchedPhoneNumber;
    }

    public void setContryCode(String contryCode) {
        this.contryCode = contryCode;
    }

    public String getContryCode() {
        return contryCode;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setRePasswd(String rePasswd) {
        this.rePasswd = rePasswd;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPrevilege(String previlege) {
        this.previlege = previlege;
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

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getRePasswd() {
        return rePasswd;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPrevilege() {
        return previlege;
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

    public List<Product> getProducts() {
        return products;
    }
}
