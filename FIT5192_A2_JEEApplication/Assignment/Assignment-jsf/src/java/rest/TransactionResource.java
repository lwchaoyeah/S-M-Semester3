/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.api.TransactionBeanService;
import com.entity.Transaction;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jason
 */
@Path("transaction")
@RequestScoped
public class TransactionResource {
    @EJB
    private TransactionBeanService transactionBeanService;
    
    
    @GET
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transaction> searchTransactionByUserId(@PathParam("userId") int userId ){
        List<Transaction> transactions=transactionBeanService.searchTransactionByUserId(userId);
        return transactions;
    }
}
