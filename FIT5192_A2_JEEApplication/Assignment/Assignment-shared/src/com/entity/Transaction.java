/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wenchao
 */
@Entity
@Table(name ="TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Transaction.SEARCH_TRANSACTION_BY_USERID, query = "SELECT t FROM Transaction t where t.user.userId = :userID "),
})
public class Transaction implements Serializable {
    
    public static final String SEARCH_TRANSACTION_BY_USERID="searchTransactionByUserId";
    
    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private Integer transactionId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "transaction")
    private Collection<TransactionProduct> transactionProducts;
    
    @Transient
    private Long totalFee;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    public Integer getID() {
        return getTransactionId();
    }

    public void setID(Integer transactionId) {
        this.setTransactionId(transactionId);
    }

    

    /**
     * @return the transactionProducts
     */
    @XmlTransient
    public Collection<TransactionProduct> getTransactionProducts() {
        return transactionProducts;
    }

    /**
     * @param transactionProducts the transactionProducts to set
     */
    public void setTransactionProducts(Collection<TransactionProduct> transactionProducts) {
        this.transactionProducts = transactionProducts;
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
     * @return the transactionId
     */
    public Integer getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the totalFee
     */
    public Long getTotalFee() {
        return totalFee;
    }

    /**
     * @param totalFee the totalFee to set
     */
    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
}
