/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.api.TransactionBeanService;
import com.entity.Product;
import com.entity.Transaction;
import com.entity.TransactionProduct;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
public class TransactionServiceImpl implements TransactionBeanService{
    @PersistenceContext
    private EntityManager em;
    /**
    *
    * @author Jason
    */
    @Override
    public Integer add(Transaction transaction) {
        transaction.setStartDate( new Date());
        em.persist(transaction);
        return transaction.getID();
    }
    /**
    *
    * @author Jason
    */
    @Override
    public int delete(int id) {
        Transaction transaction = em.find(Transaction.class, id);
        if (transaction != null){
            em.remove(transaction);
        }
        return 0;
    }
    /**
    *
    * @author Jason
    */
    @Override
    public int update(Transaction transaction) {
        em.merge(transaction);
        return 0;
    }
    /**
    *
    * @author Jason
    */
    @Override
    public Transaction searchbyid(int id) {
        Transaction transaction = em.find(Transaction.class, id);
        return transaction;
    }

    
    /**
    * it's used for bussiness logic which insert transaction and transaction product. Both of them is required
    * @author Jason
    */    
    @Override
    public int addTransaction(Transaction transaction, List<TransactionProduct> transactionProducts) {
            transaction.setStartDate( new Date());
            em.persist(transaction);
            for(TransactionProduct transactionProduct: transactionProducts){
                transactionProduct.setTransaction(transaction);
                em.persist(transactionProduct);
            }
            return transaction.getTransactionId();
    }

    @Override
    public List<Transaction> searchTransactionByUserId(int userID) {
        Query q = em.createNamedQuery(Transaction.SEARCH_TRANSACTION_BY_USERID);
        q.setParameter("userID", userID);
        if (q.getResultList()== null) {
            return Collections.EMPTY_LIST;
        }else{
            List<Transaction>  result =q.getResultList();
            for(Transaction r : result){
                r.getTransactionProducts().size();
            }
            return result;
        } 
    }
    
}
