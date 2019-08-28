/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.UserBean;
import com.api.ProductBeanService;
import com.api.TransactionBeanService;
import com.api.TransactionProductBeanService;
import com.entity.User;
import com.api.UserBeanService;
import com.entity.Previlege;
import com.entity.Product;
import com.entity.Transaction;
import com.entity.TransactionProduct;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import com.validation.PasswdFormatValidor;
import com.validation.NameValidator;
import com.validation.PhoneFormatValidator;
import com.validation.SHA;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.faces.context.FacesContext;


/**
 *
 * @author Wenchao
 */
@Named(value = "userController")
@RequestScoped
public class UserController implements Serializable {
    
    @EJB
    private UserBeanService userService;
    @EJB
    private TransactionBeanService transactionBeanService;
    
    private Integer userID;
    private String email;
    private String lastName;
    private String firstName;
    private String membershipLevel;
    private List<User> searchedUsers;
    private User userPage;
    
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
        this.userPage=new User();
    }

     public void getUserFromPara() {
        Integer userId = Integer.valueOf(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("userId"));
        
        userPage = userService.searchByID(userId);
    }

    public void setUserPage(User userPage) {
        this.userPage = userPage;
    }

    public User getUserPage() {
        return userPage;
    }
    
    public List<User> getSearchedUsers() {
        return searchedUsers;
    }

    public void setSearchedUsers(List<User> searchedUsers) {
        this.searchedUsers = searchedUsers;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }
    
    public String loginValidate(UserBean userBean){
        String email=userBean.getEmail();
        String passwd=userBean.getPasswd();
        // **************************** use one-way hash *****************************
        passwd = SHA.SHA256(passwd);

        int isLogin = userService.login(email, passwd);
        if(isLogin==1){
            Integer userID = userService.searchByEmail(email).get(0).getUserId();
            User user = this.userService.searchByID(userID);
            //System.out.println(user.toString());
            transmitUserToUserBean(userBean, user);
            return "/index";
        }else{
            return "/user/login";
        }
    }
    
    public String tryRegister(UserBean userBean){
        String passwd= userBean.getPasswd();
        //************** passwd format validation**********************************
        PasswdFormatValidor passwdFormatValidor = new PasswdFormatValidor();
        if(!passwdFormatValidor.isPasswdValid(passwd)){
            return "/user/register";
        }
        
        // check no exesitence of email and the uniformity of passwd
        if (userService.searchByEmail(userBean.getEmail()).isEmpty() && passwd.equals(userBean.getRePasswd())) {
            Integer maxID = userService.getMaxID();
            User user=new User(maxID+1, userBean.getEmail(),userBean.getPasswd()); 
            if (maxID==0) {
                user.setMembershipLevel("Administrator");
            }
            // ****************** Encryption the password by SHA256 ******************
            passwd = SHA.SHA256(passwd);
            user.setPassword(passwd);
            
            userService.add(user);
            return "/user/login";
        }else{
            return "/user/register";
        }
    }
    
    // in userStatus page
    public String saveChanges(UserBean userBean){
        //***************** validate the name *********************************************
        String lastName = userBean.getLastName();
        String firstName = userBean.getFirstName();
        if (NameValidator.isAnyNumber(lastName) || NameValidator.isAnyNumber(firstName)) {
            return "/user/userStatus";
        }
        
        //***************** validate the phone number *************************************
        String phoneNumber = userBean.getPhoneNumber();
        String contryCode = userBean.getContryCode();
        if (!phoneNumber.isEmpty() && !PhoneFormatValidator.isPhoneNumberValid(phoneNumber, contryCode)) {
            return "/user/userStatus";
        }
        
        //****************** save the changes to database *********************************
        User user=new User();
        transmitUserBeanToUser(user, userBean);
        this.userService.updateDetails(user);
        //check if changes can be added to UserBen directly in Login function
        //System.out.println(userBean.getUserID());
        return "/user/userStatus";
    }
    
    // UserBean -> User
    public void transmitUserBeanToUser(User user , UserBean userBean){
        user.setUserId(userBean.getUserID());
        user.setEmail(userBean.getEmail());
        user.setPassword(userBean.getPasswd());
        user.setAddress(userBean.getAddress());
        user.setAge(userBean.getAge());
        user.setFavorMovie(userBean.getFavorMovie());
        user.setLastName(userBean.getLastName());
        user.setFirstName(userBean.getFirstName());
        user.setGender(userBean.getGender());
        user.setMembershipLevel(userBean.getMembershipLevel());
        user.setPhoneNumer(userBean.getPhoneNumber());
        //user.setPrevilege();
        //user.setProducts();
    }
    
    // User -> UserBean
    public void transmitUserToUserBean(UserBean userBean, User user){
        userBean.setUserID(user.getUserId());
        userBean.setEmail(user.getEmail());
        userBean.setPasswd(user.getPassword());
        userBean.setAddress(user.getAddress());
        userBean.setAge(user.getAge());
        userBean.setFavorMovie(user.getFavorMovie());
        userBean.setLastName(user.getLastName());
        userBean.setFirstName(user.getFirstName());
        userBean.setGender(user.getGender());
        userBean.setMembershipLevel(user.getMembershipLevel());
        userBean.setPhoneNumber(user.getPhoneNumer());
        //userBean.setPrevilege(user.getPrevilege());
        //userBean.setProducts(user.getProducts());
    }
    
    public List<User> listAllUser(){
        return userService.searchAll();
    }
    
    // user management page
    public void searchUserByID(UserBean userBean){
        if(userBean.getSearchedID()== null){
            this.searchedUsers = this.keepSpecficLevelUser(userService.searchAll(), userBean);
            return;
        }
        this.searchedUsers=new ArrayList();
        User user = userService.searchByID(userBean.getSearchedID());
        if(user!=null){
            this.searchedUsers.add(user);
            this.searchedUsers = this.keepSpecficLevelUser(this.searchedUsers, userBean);
        }
        return;
    }
    
    // user management page
    public void searchUserByEmail(UserBean userBean){
        if(userBean.getSearchedEmail().isEmpty()){
            this.searchedUsers = this.keepSpecficLevelUser(userService.searchAll(), userBean);
            return;
        }
        List<User> userList = userService.searchByEmail(userBean.getSearchedEmail());
        this.searchedUsers = keepSpecficLevelUser(userList, userBean);
        return;
    }
    
    // user management page
    public void searchUserByMultiAttributes(UserBean userBean){
//        List<User> userList = new ArrayList<>();
        Map<String,Object> searchParameterMap = new HashMap<>();
        if (userBean.getSearchedLastName()!=null && userBean.getSearchedLastName().length() !=0){
            searchParameterMap.put("lastName", userBean.getSearchedLastName());
        }else if (userBean.getSearchedFirstName()!=null && userBean.getSearchedFirstName().length() !=0 ){
            searchParameterMap.put("firstName", userBean.getSearchedFirstName());
        }else if(userBean.getSearchedPhoneNumber()!= null && userBean.getSearchedPhoneNumber().length() != 0){
            searchParameterMap.put("phoneNumer", userBean.getSearchedPhoneNumber());
        }
        
        if (!searchParameterMap.isEmpty()){
            this.searchedUsers = keepSpecficLevelUser(userService.searchByMultiAttributes(searchParameterMap), userBean);
        }else{
            this.searchedUsers = keepSpecficLevelUser(userService.searchAll(), userBean); 
        }
//        return "/user/userManagement";
    }
    
    // in userInfo page
    public String saveSearchedUserInfo(UserBean userBean){
        User user = this.userService.searchByID(this.userPage.getUserId());
        user.setLastName(userPage.getLastName());
        user.setFirstName(userPage.getFirstName());
        user.setAddress(userPage.getAddress());
        user.setMembershipLevel(userPage.getMembershipLevel());
        this.userService.updateDetails(user);
        if(userBean.getMembershipLevel().equals("Administrator")){
            //return "/user/userInfoByAdministrator.xhtml?userId="+Integer.toString(this.userPage.getUserId());
            return "/user/userManagement";
        }else{
            //return "/user/userInfoByManagement.xhtml?userId="+Integer.toString(this.userPage.getUserId());
            return "/user/userManagement";
        }
    }
    
    // in userInfo page
    public String deleteSearchedUser(){
        this.userService.delete(userPage.getUserId());
        return "/user/userManagement";
    }
    
    // according to userBean.getMembershipLevel()
    public List<User> keepSpecficLevelUser(List<User> userList, UserBean userBean){
//        for (int i=0; i<userList.size();i++) {
//            // "Administrator" - 1; "Management" - 2; "Customer" - 3; "Visitor" - 4
////             this will cause missing processing
////            if (Previlege.getValue(userList.get(i).getMembershipLevel()) <= Previlege.getValue(userBean.getMembershipLevel())) {
////                userList.remove(i);
////            }
       
//        }
        // for Administrator
        if(userBean.getMembershipLevel().equals("Administrator")){
            // strip off higher and equivalent level
            // true -> keep
            userList=userList.stream().
                filter(user->Previlege.getValue(user.getMembershipLevel()) > Previlege.getValue(userBean.getMembershipLevel())).
                collect(Collectors.toList());
//            // strip off "Visitor" level
//            userList=userList.stream().
//                filter(user->!Previlege.getValue(user.getMembershipLevel()).equals(Previlege.getValue("Visitor"))).
//                collect(Collectors.toList());
        }
        // for Management
        else{
            // true -> keep
            userList=userList.stream().
                filter(user->Previlege.getValue(user.getMembershipLevel()) > Previlege.getValue(userBean.getMembershipLevel())).
                collect(Collectors.toList());
            // for test
            userList.stream().forEach(user-> System.out.println(user.getMembershipLevel()));
        }
        return userList;
        
//        for (User user : userList) {
//            if (user.getMembershipLevel().equals(userBean.getMembershipLevel())) {
//                userList.remove(user);
//            }
//            
//        }
    }
    
    public String moveToUserInfo(UserBean userBean){
        if (userBean.getMembershipLevel().equals(Previlege.getName(1))) {
            return "/user/userInfoByAdministrator";
        }else{
            return "/user/userInfoByManagement";
        }
    }
    
    public String deleteProductFromCart(Integer productId,UserBean userBean){
        List<Product> productList = userBean.getProducts();
        // true -> keep
        productList=productList.stream().
                filter(product-> product.getProductId()!=productId).
                collect(Collectors.toList());
        productList.stream().forEach(product-> System.out.println(product.getProductId()));
        userBean.setProducts(productList);
        return "/transaction/shoppingCart";
    }
    
    public String submitOrder(UserBean userBean){
        List<Product> productList = userBean.getProducts();
        if(productList!=null && !productList.isEmpty()){
            
            Integer userId= userBean.getUserID();
            User user = new User();
            user.setUserId(userId);
            Transaction transaction = new Transaction();
            transaction.setUser(user);
            List<TransactionProduct> transactionProducts = new ArrayList<>();
            for (Product product : productList) {
                TransactionProduct transactionProduct = new TransactionProduct();
                transactionProduct.setTransaction(transaction);
                transactionProduct.setProduct(product);
                transactionProduct.setProduct_number(userBean.getMapProductToNumber().get(String.valueOf(product.getProductId())));
                transactionProducts.add(transactionProduct);
            }
            transactionBeanService.addTransaction(transaction, transactionProducts);
            
// get transaction by user -> insert -> get transactionId in Transaction Table            
//            Integer userId= userBean.getUserID();
//            User user = new User();
//            user.setUserId(userId);
//            Transaction transaction = new Transaction();
//            transaction.setUser(user);
//            Integer transactionId = this.transactionBeanService.add(transaction);
//            transaction.setID(transactionId);
//            // 
//            for (Product product : productList) {
//                // get productForTransaction by productId in shopping cart 
//                Product productForTransaction = new Product();
//                productForTransaction.setProductId(product.getProductId());
//                // assemble transactionProduct with transactionId and productForTransaction
//                TransactionProduct transactionProduct = new TransactionProduct();
//                transactionProduct.setTransaction(transaction);
//                transactionProduct.setProduct(productForTransaction);
//                this.transactionProductBeanService.add(transactionProduct);
//            }
            // empty the cart
            userBean.getProducts().clear();
            // empty the hashMap
            userBean.getMapProductToNumber().clear();
        }
        return "/transaction/shoppingCart";
    }
    
}
