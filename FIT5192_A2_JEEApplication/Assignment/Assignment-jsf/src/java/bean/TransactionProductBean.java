/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.entity.Product;
import com.entity.Transaction;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jason
 */
@Named(value = "transactionProductBean")
@RequestScoped
public class TransactionProductBean {
    private Integer rating; //rating for product in transaction
    private Integer product_number; // number of products
    private String commmment;
    private Long discount;
    
    
    private Transaction transaction;
    private Product product;

    public TransactionProductBean() {
        this.transaction = new Transaction();
        this.product = new Product();
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
    public void setProduct_number(Integer product_number) {
        this.product_number = product_number;
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
    
    
    
}
