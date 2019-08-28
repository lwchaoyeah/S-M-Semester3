/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;


import com.entity.Transaction;
import com.entity.TransactionProduct;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Wenchao
 */
@Remote
public interface TransactionBeanService {
    Integer add(Transaction transaction);
    int delete(int id);
    int update(Transaction transaction);
    Transaction searchbyid(int id);
    int addTransaction(Transaction transaction , List<TransactionProduct> transactionProducts);
    List<Transaction> searchTransactionByUserId(int userId);
}
