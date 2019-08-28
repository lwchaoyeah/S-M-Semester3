/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jason
 */
@Entity
@Table(name ="TRANSACTIONPRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = TransactionProduct.SEARCH_BY_TRANSACTIONID, query = "SELECT tp from TransactionProduct tp WHERE tp.transaction.transactionId = :transactionId")
    ,@NamedQuery(name = TransactionProduct.SEARCH_BY_USERID, query = "SELECT tp from TransactionProduct tp WHERE tp.transaction.user.userId = :userId")
})
public class TransactionProduct implements Serializable{
    
    public static final String SEARCH_BY_TRANSACTIONID="search_by_transactionId";
    public static final String SEARCH_BY_USERID="search_by_userId";
    
    
    @Id
    @GeneratedValue
    private Long TranscationProductID;
    
    private Integer rating; //rating for product in transaction
    private Integer product_number; // number of products
    private String commmment;
    private Long discount;
    
    
    
    @ManyToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id")
    private Transaction transaction;
    
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private Product product;
    
    
    public Long getTranscationProductID() {
        return TranscationProductID;
    }

    public void setTranscationProductID(Long TranscationProductID) {
        this.TranscationProductID = TranscationProductID;
    }

    /**
     * @return the rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * @return the product_number
     */
    public Integer getProduct_number() {
        return product_number;
    }

    /**
     * @param product_number the product_number to set
     */
    public void setProduct_number(int product_number) {
        this.product_number = product_number;
    }

    /**
     * @return the transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the commmment
     */
    public String getCommmment() {
        return commmment;
    }

    /**
     * @param commmment the commmment to set
     */
    public void setCommmment(String commmment) {
        this.commmment = commmment;
    }

    /**
     * @return the discount
     */
    public Long getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(Long discount) {
        this.discount = discount;
    }

  
  
}
