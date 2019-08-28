/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.UserBean;
import com.entity.Previlege;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Jason
 */
@Named(value = "accessController")
@RequestScoped
public class AccessController {
    public String productManageControl(UserBean userBean){
        String previlege = userBean.getMembershipLevel();
        if (Previlege.Administrator.getName().equals(previlege)) {
            return "/product/productInfoList";
        }else{
            return "/index";
        }
    }
    
    
    public String userManageControl(UserBean userBean){
        String previlege = userBean.getMembershipLevel();
        if (Previlege.Management.getName().equals(previlege) || Previlege.Administrator.getName().equals(previlege)) {
            return "/user/userManagement";
        }else{
            return "/index";
        }
    }
    
    
    public String transactionManageControl(UserBean userBean){
        String previlege = userBean.getMembershipLevel();
        if (Previlege.Management.getName().equals(previlege)|| Previlege.Customer.getName().equals(previlege)
                || Previlege.Administrator.getName().equals(previlege)) {
            return "/transaction/transactionList";
        }else{
            return "/index";
        }
        
    }
}
