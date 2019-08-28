/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.api.ProductBeanService;
import com.api.TransactionBeanService;
import com.api.TransactionProductBeanService;

import com.entity.Product;
import com.entity.Transaction;
import com.entity.TransactionProduct;
import com.entity.User;
import javax.ejb.EJB;

/**
 *
 * @author Jason
 */
public class Test {

    @EJB
    private static ProductBeanService productBeanService;
    
    @EJB
    private static TransactionBeanService transactionBeanService;
    
    @EJB
    private static TransactionProductBeanService transactionProductBeanService;
    
                   
    public static void main(String[] args) {
//        Product p = new Product();
//        p.setAuthor("Test");
//        productBeanService.add(p);
//        System.out.println("done");
//        Product p2=productBeanService.searchbyid(1);
//        System.out.println(p2.getAuthor());
//        p2.setAuthor("Test2");
//        productBeanService.update(p2);
//        p2=productBeanService.searchbyid(1);
//        System.out.println(p2.getAuthor());
//        productBeanService.delete(1);
//        p2=productBeanService.searchbyid(1);
//        System.out.println(p2.getAuthor());
        
        
        Transaction transaction = new Transaction();
        User user = new User(); // user
        user.setUserId(1);      // only id is required
        transaction.setUser(user);              
        
        
        
        int transaction_id=transactionBeanService.add(transaction);
        transaction.setTransactionId(transaction_id);
        
        Product product1 = new Product();       //product
        product1.setProductId(1);               // only id is required
        Product product2 = new Product();
        product2.setProductId(2);               // only id is required
        
        
        TransactionProduct transactionProduct1 = new TransactionProduct();
        transactionProduct1.setTransaction(transaction);
        transactionProduct1.setProduct(product1);
        
        TransactionProduct transactionProduct2 = new TransactionProduct();
        transactionProduct2.setTransaction(transaction);
        transactionProduct2.setProduct(product2);
        Long transactionProduct_id_1 = transactionProductBeanService.add(transactionProduct1);
        Long transactionProduct_id_2 = transactionProductBeanService.add(transactionProduct2);
        
        Transaction transaction2 = transactionBeanService.searchbyid(transaction_id);
        TransactionProduct transactionProduct1_find =transactionProductBeanService.searchbyid(transactionProduct_id_1);
        transactionProduct1_find.setRating(5);
        transactionProductBeanService.update(transactionProduct1_find);
        
        TransactionProduct transactionProduct2_find =transactionProductBeanService.searchbyid(transactionProduct_id_2);
        transactionProductBeanService.delete(transactionProduct_id_1);
        transactionProductBeanService.delete(transactionProduct_id_2);
        transactionBeanService.delete(transaction_id);
        
    }
    
}
