/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;


import com.api.TransactionProductBeanService;
import com.entity.Product;
import com.entity.Transaction;
import com.entity.TransactionProduct;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jason
 */
@Stateless
public class TransactionProductServiceImpl implements TransactionProductBeanService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Long add(TransactionProduct transactionProduct) {
        em.persist(transactionProduct);
        return transactionProduct.getTranscationProductID();
    }

    @Override
    public int delete(Long id) {
        TransactionProduct transactionProduct = em.find(TransactionProduct.class, id);
        if (transactionProduct != null){
            em.remove(transactionProduct);
        }
        return 0;
    }

    @Override
    public int update(TransactionProduct transactionProduct) {
        em.merge(transactionProduct);
        return 0;
    }

    @Override
    public TransactionProduct searchbyid(Long id) {
         TransactionProduct transactionProduct = em.find(TransactionProduct.class, id);
        return transactionProduct;
    }

    @Override
    public List<TransactionProduct> searchByTransactionId(Integer transactionId) {
        Query q=em.createNamedQuery(TransactionProduct.SEARCH_BY_TRANSACTIONID);
        q.setParameter("transactionId", transactionId);
        return  q.getResultList() == null? Collections.EMPTY_LIST: q.getResultList();
    }

    
    @Override
    public List<TransactionProduct> searchByMultiCategory(Map<String, Object> conditions) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


        StringBuilder builder = new StringBuilder("SELECT tp from TransactionProduct tp where ");
         for (Map.Entry<String,Object> entry: conditions.entrySet()){
            String s;
            if (entry.getKey().equals("price")){
                s = "tp.product.price <= :"+(String)(entry.getKey())+" and ";
            }else if(entry.getKey().equals("rating")){
                s = "tp.product.rating <= :"+(String)(entry.getKey())+" and ";
            } else{
                s = "tp.product."+entry.getKey()+" = :"+entry.getKey()+" and ";
            }
            builder.append(s);
        }
        String jpql = builder.toString();//erase " and " 5 length
        jpql=jpql.substring(0, jpql.length() - 5);
        System.out.print(jpql);
        Query q=em.createQuery(jpql, TransactionProduct.class);
        for (Map.Entry<String,Object> entry: conditions.entrySet()){
            q.setParameter(entry.getKey(), entry.getValue());
        }
        return q.getResultList() == null? Collections.EMPTY_LIST: q.getResultList();
    }

    @Override
    public List<TransactionProduct> searchByUserId(Integer userId) {
        Query q=em.createNamedQuery(TransactionProduct.SEARCH_BY_USERID);
        q.setParameter("userId", userId);
        return  q.getResultList() == null? Collections.EMPTY_LIST: q.getResultList();
    }
   
}
