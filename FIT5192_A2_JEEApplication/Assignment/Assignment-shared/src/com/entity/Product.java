/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import com.oracle.jrockit.jfr.Producer;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jason
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Product.Search_By_Author, query ="SELECT p FROM Product p WHERE p.author = :author")
    ,@NamedQuery(name = Product.Search_By_Title, query ="SELECT p FROM Product p WHERE p.shortTitle = :shortTitle")
    ,@NamedQuery(name = Product.Search_By_Category, query ="SELECT p from Product p where p.category = :category")
    ,@NamedQuery(name = Product.Search_all, query ="SELECT p from Product p")
    ,@NamedQuery(name = Product.Search_BY_ISBN, query = "SELECT p from Product p where p.ISBN IN :ISBN ")
})
public class Product implements Serializable {
    public static final String Search_By_Author = "Search_By_Author";
//    public static final String Search_By_Price="Search_By_Price";
    public static final String Search_By_Title="Search_By_Title";
    public static final String Search_By_Category="Search_By_Category";
    public static final String Search_all = "Search_all";
    public static final String Search_BY_ISBN = "search_By_ISBN";

  
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Integer productId;
    @NotNull
    private String shortTitle; //name
    private Long price;         //price
    private String author;
    private Long rating;
    private String category;
    private String publish_house;
    private String ISBN;
    
    @OneToMany(mappedBy = "product")
    private Collection<TransactionProduct> transactionproduct;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    
    /**
     * @return the price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return the rating
     */
    public Long getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Long rating) {
        this.rating = rating;
    }
    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the publish_house
     */
    public String getPublish_house() {
        return publish_house;
    }

    /**
     * @param publish_house the publish_house to set
     */
    public void setPublish_house(String publish_house) {
        this.publish_house = publish_house;
    }
  
    
    
    
    
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return the shortTitle
     */
    public String getShortTitle() {
        return shortTitle;
    }

    /**
     * @param shortTitle the shortTitle to set
     */
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the transactionproduct
     */
    @XmlTransient
    public Collection<TransactionProduct> getTransactionproduct() {
        return transactionproduct;
    }

    /**
     * @param transactionproduct the transactionproduct to set
     */
    public void setTransactionproduct(Collection<TransactionProduct> transactionproduct) {
        this.transactionproduct = transactionproduct;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

 
    
    
  
}
