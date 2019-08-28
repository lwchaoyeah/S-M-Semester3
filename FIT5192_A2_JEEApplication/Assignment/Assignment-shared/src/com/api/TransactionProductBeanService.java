/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;


import com.entity.TransactionProduct;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Jason
 */
@Remote
public interface TransactionProductBeanService {
    Long add(TransactionProduct transactionProduct);
    int delete(Long id);
    int update(TransactionProduct transactionProduct);
    TransactionProduct searchbyid(Long id);
    List<TransactionProduct> searchByTransactionId(Integer transactionId);
    List<TransactionProduct> searchByMultiCategory(Map<String, Object> conditions);
    List<TransactionProduct> searchByUserId(Integer userId);
}
