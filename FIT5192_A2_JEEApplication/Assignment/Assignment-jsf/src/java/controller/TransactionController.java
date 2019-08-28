/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import bean.RedirectFunction;
import bean.TransactionProductBean;
import bean.UserBean;
import com.api.TransactionBeanService;
import com.api.TransactionProductBeanService;
import com.entity.Transaction;
import com.entity.TransactionProduct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
/**
 *
 * @author Jason
 */
@Named(value ="transactionController")
@RequestScoped
public class TransactionController {
    @EJB
    private TransactionBeanService transacionBeanService;
    
    @EJB
    private TransactionProductBeanService transactionProductBeanService;
    
    private Transaction transaction= new Transaction();
    
    private TransactionProduct transactionProduct = new TransactionProduct();
    
    private List<TransactionProduct> transactionProducts;
    
    private List<Transaction> transactions;
    
    public void getTransactionByUserId(Integer userId) {
        setTransactions(transacionBeanService.searchTransactionByUserId(userId));
        for(Transaction ts:this.transactions){
            long fee = 0;
            for ( TransactionProduct tsp : ts.getTransactionProducts()){
                fee = fee + (tsp.getProduct().getPrice()* tsp.getProduct_number() );
            }
            System.err.println(fee);
            ts.setTotalFee(Long.valueOf( fee ));
        }
        
    }
    
    public void getTransactionnProductBYTransactionProductId(){
         Long transactionProductID = Long.valueOf(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("transactionProductID"));
        setTransactionProduct(transactionProductBeanService.searchbyid(transactionProductID));
    }
    
    public void getTransactionProductsByTransactionId(){
         int transactionId = Integer.valueOf(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("transactionId"));
        setTransactionProducts(transactionProductBeanService.searchByTransactionId(transactionId));
    }
    
    public String saveRatingComment() throws IOException{
        Boolean flag = false;
        TransactionProduct tProductFromDB=transactionProductBeanService.searchbyid(this.transactionProduct.getTranscationProductID() ); //retrieve transactionProduct from DB
        if (this.transactionProduct.getRating() != null 
                && this.transactionProduct.getRating() > 0 
                && this.transactionProduct.getRating() <= 10) {
            tProductFromDB.setRating(this.transactionProduct.getRating());
            flag =true;
        }
        if (this.transactionProduct.getCommmment() != null && this.transactionProduct.getCommmment().length()>0) {
            flag = true;
            tProductFromDB.setCommmment(transactionProduct.getCommmment());
        }
        if (flag){
            transactionProductBeanService.update(tProductFromDB);
        }
        
        String result = "/transaction/transactionInfo.xhtml?transactionId="+String.valueOf( tProductFromDB.getTransaction().getTransactionId());
        return RedirectFunction.redirect(result);//redirect
    }
    
    public String searchByMultiCategory(TransactionProductBean transactionProductBean, UserBean userBean){
        Map<String,Object> searchParameterMap = new HashMap<>();
         if (transactionProductBean.getProduct().getRating()!= null && transactionProductBean.getProduct().getRating()> 0 ){
            searchParameterMap.put("rating", transactionProductBean.getProduct().getRating());
        }else if(transactionProductBean.getProduct().getAuthor() != null && transactionProductBean.getProduct().getAuthor().length() != 0){
            searchParameterMap.put("author", transactionProductBean.getProduct().getAuthor());
        }else if(transactionProductBean.getProduct().getShortTitle()!= null && transactionProductBean.getProduct().getShortTitle().length() != 0){
            searchParameterMap.put("shortTitle", transactionProductBean.getProduct().getShortTitle());
        }else if(transactionProductBean.getProduct().getPrice()!= null && transactionProductBean.getProduct().getPrice()> 0){
            searchParameterMap.put("price", transactionProductBean.getProduct().getPrice());
        }
        
        if (!searchParameterMap.isEmpty()){
            this.transactionProducts = transactionProductBeanService.searchByMultiCategory(searchParameterMap);
        }else{
            this.transactionProducts = transactionProductBeanService.searchByUserId(userBean.getUserID());
        }
        getTransactionByUserId(userBean.getUserID());
        return "/transaction/transactionList";
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
     * @return the transactionProductsList
     */
    public List<TransactionProduct> getTransactionProducts() {
        return transactionProducts;
    }

    /**
     * @param transactionProductsList the transactionProductsList to set
     */
    public void setTransactionProductsList(List<TransactionProduct> transactionProducts) {
        this.setTransactionProducts(transactionProducts);
    }

    /**
     * @return the transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * @return the transactionProduct
     */
    public TransactionProduct getTransactionProduct() {
        return transactionProduct;
    }

    /**
     * @param transactionProduct the transactionProduct to set
     */
    public void setTransactionProduct(TransactionProduct transactionProduct) {
        this.transactionProduct = transactionProduct;
    }

    /**
     * @param transactionProducts the transactionProducts to set
     */
    public void setTransactionProducts(List<TransactionProduct> transactionProducts) {
        this.transactionProducts = transactionProducts;
    }

    
}
