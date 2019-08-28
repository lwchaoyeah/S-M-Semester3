/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assign;

import com.api.ProductBeanService;
import com.api.UserBeanService;
import com.entity.Product;
import com.entity.User;
import com.validation.NameValidator;
import com.validation.PhoneFormatValidator;
import com.validation.PasswdFormatValidor;
import fit5192.assign.gui.LoginGUI;
import fit5192.assign.gui.LoginGUIImpl;
import fit5192.assign.gui.OnlineBookStoreGUI;
import fit5192.assign.gui.OnlineBookStoreGUIImpl;
import fit5192.assign.gui.RegisterGUI;
import fit5192.assign.gui.RegisterGUIImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.ejb.EJB;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import fit5192.assign.validation.EmailValidator;

/**
 *
 * @author Wenchao
 */
public class OnlineBookCity implements ActionListener, ListSelectionListener{

    @EJB
    private static UserBeanService userService;
    @EJB
    private static ProductBeanService productBeanService;
    
    
    String storeName;
    private LoginGUI guiLogin;
    private RegisterGUI guiRegister;
    private OnlineBookStoreGUI guiOnlineBookStore;
    
    // save the current logged in user
    private User currentUser;
    
    public OnlineBookCity(String name){
        this.storeName = name;
        this.currentUser=new User();
    }
    
    public void initView() {
        this.guiLogin = new LoginGUIImpl(this, this);
        this.guiRegister = new RegisterGUIImpl(this, this);
        this.guiOnlineBookStore=new OnlineBookStoreGUIImpl(this, this);
        this.guiLogin.displayLoginGUI();
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
         if (event.getSource() == guiLogin.getLoginButton()) {
            this.executeLogin();
        } else if (event.getSource() == guiLogin.getRegisterButton()) {
            this.executeGoRegister();
        } else if (event.getSource() == guiRegister.getRegisterButton()) {
            this.executeRegister();
        } else if (event.getSource() == guiRegister.getBackButton()) {
            this.executeBack();
        }else if(event.getSource() == guiOnlineBookStore.getExitButton()){
            this.executeExitClient();
        }
        else if(event.getSource() == guiOnlineBookStore.getSaveButton()){
            this.executeSaveUserInfo();
        }
        else if(event.getSource() == guiOnlineBookStore.getSearchButton()){
            // deifine search function
            executeProductSearch();
        }
        else if(event.getSource() == guiOnlineBookStore.getSearchComBoxValue()){
            // seems not necessary
        }
        else {
            System.exit(0);
        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void displayWarningMessage(int type){
        if(type==1){
            JOptionPane.showMessageDialog(null, "The email format is wrong, please follow the format \"name@<EmailProvider>.<domain>\"!", "Fail to login", JOptionPane.PLAIN_MESSAGE);
        }
        else if(type==2){
            JOptionPane.showMessageDialog(null, "The email format is wrong, please follow the format \"name@<EmailProvider>.<domain>\"!", "Fail to register", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    // in Login page
    public void executeLogin(){
        //System.out.println("Login:"+this.userService==null);
        String email=guiLogin.getEmail();
        String passwd=guiLogin.getPasswd();
        
        // validate the email format first
        EmailValidator emailValidator = new EmailValidator();
        if(!emailValidator.validate(email)){
            displayWarningMessage(1);
            return;
        }
        
        int isLogined = userService.login(email, passwd);
        if (isLogined==1) {
            // save current user info
            this.currentUser = userService.searchByEmail(email).get(0);
            // go to main page
            this.guiLogin.hiddenLoginGUI();
            this.guiOnlineBookStore.displayBookStoreGUI(this.currentUser);
        }
        else{
            JOptionPane.showMessageDialog(null, "The email or password is wrong, please try again!", "Fail to Login", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    // in Login page
    public void executeGoRegister(){
        //this.dispose();
        this.guiLogin.hiddenLoginGUI();
        this.guiRegister.displayRegisterGUI();
    }
    
    // in Register page
    public void executeBack(){
        //this.dispose();
        this.guiRegister.hiddenRegisterGUI();
        this.guiLogin.displayLoginGUI();
    }
    
    // in Register page
    public void executeRegister(){
        //System.out.println("Register:"+this.userService==null);
        Integer maxID=userService.getMaxID();
        String email=guiRegister.getEmail();
        String passwd=guiRegister.getPasswd();
        String rePasswd=guiRegister.getRePasswd();
        
        // validation function for each field later and corresponding message warning
        if(!email.isEmpty() && !passwd.isEmpty() && passwd.equals(rePasswd)){
            //System.out.println("email:"+ email.equals(null)+", passwd:"+passwd.equals(null)+", repasswd:"+rePasswd.equals(""));
            
            // validate the email format first
            EmailValidator emailValidator = new EmailValidator();
            if(!emailValidator.validate(email)){
                displayWarningMessage(2);
                return;
            }
            
            // Validate that the email hasn't been registered
            if (userService.searchByEmail(email).size()!=0) {
                JOptionPane.showMessageDialog(null, "This email has been registered!\n Please change another!", "Registration failed", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            //*********************validate the passwd format****************************************
            PasswdFormatValidor passwdValidator = new PasswdFormatValidor();
            if(!passwdValidator.isPasswdValid(passwd)){
                JOptionPane.showMessageDialog(null, "The number of passwd must between 8 and 20.\n And they are combination of upper letters, lower letters, digit and special characters", "Registration failed", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            User user= new User(maxID+1,guiRegister.getEmail(),guiRegister.getPasswd());
            // make ID=1 as Administrator, otherwise, it will be set as Visitor
            if (maxID==0) {
                user.setMembershipLevel("Administrator");
            }
            else{
                user.setMembershipLevel("Visitor");
            }
            userService.add(user);
            // save current user info
            this.currentUser=user;
            // go to first page
            this.guiRegister.hiddenRegisterGUI();
            this.guiOnlineBookStore.displayBookStoreGUI(this.currentUser);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Re-enter information!", "Registration failed", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    //    product search function
    public void executeProductSearch(){
        String field = this.guiOnlineBookStore.getProducttSelectComboBox().getSelectedItem().toString();
        String keyword = this.guiOnlineBookStore.getProductJTextField().getText();
        if (keyword == null || keyword.length() == 0){
            return;
        }
        List<Product> products;
        if (field.equals("Title")){
            products = productBeanService.searchByTitle(keyword);
        }else if (field.equals("Type")) {
            products = productBeanService.searchByCategory(keyword);
        }else {
            products = productBeanService.searchByPrice(Long.parseLong(keyword));
        }
        
        guiOnlineBookStore.clearResultDisplayTable();
        guiOnlineBookStore.setResultDisplayTable(products);
    }
    
    // in first page
    public void executeExitClient(){
        this.guiLogin.exitLoginPage();
        this.guiRegister.exitRegisterPage();
        this.guiOnlineBookStore.exitFirstPage();
    }
    
    // in first page
    public void executeSaveUserInfo(){
        //*********************validate the phone number****************************************
        String phoneNumber=this.guiOnlineBookStore.getPhoneNumber();
        //String contryCode=this.guiOnlineBookStore.getContryCode().substring(1, 3);
        String contryCode=this.guiOnlineBookStore.getContryCode();
        switch(contryCode){
            case "+86":
                // China
                contryCode="CN";
                break;
            case "+61":
                // Australia
                contryCode="AU";
                break;
            case "+81":
                //Japan
                contryCode="JP";
                break;
        }
        if(!phoneNumber.isEmpty()&&!this.isValidPhoneNumber(phoneNumber, contryCode)){
            JOptionPane.showMessageDialog(null, "The format of phone number is wrong, please re-enter!", "Save failed", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        //*********************validate the first and last name*********************************
        String firstName=this.guiOnlineBookStore.getFirstName();
        String lastName=this.guiOnlineBookStore.getLastName();
        if(NameValidator.isAnyNumber(lastName)||NameValidator.isAnyNumber(firstName)){
            JOptionPane.showMessageDialog(null, "There can't be any numner in name, please re-enter!", "Save failed", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        // ****************** validate the age form *******************************************
        String age= this.guiOnlineBookStore.getAge();
        if(age.length()!=0){
            for(int i=0;i<age.length();i++){
                if (!(age.charAt(i) >= '0' && age.charAt(i) <= '9')){
                    JOptionPane.showMessageDialog(null, "The format of age is wrong, please re-enter!", "Save failed", JOptionPane.PLAIN_MESSAGE);
                    return;
                } 
            }
        }
        
        User userTmp = this.guiOnlineBookStore.updateUserInfo();
        updateGUIEnteredInfo(userTmp);
        // because of MySQLIntegrityConstraintViolation, userID must be contained
        userService.updateDetails(currentUser);
    }
    
    public void updateGUIEnteredInfo(User userTmp){
        this.currentUser.setAddress(userTmp.getAddress());
        this.currentUser.setAge(userTmp.getAge());
        this.currentUser.setFavorMovie(userTmp.getFavorMovie());
        this.currentUser.setFirstName(userTmp.getFirstName());
        this.currentUser.setLastName(userTmp.getLastName());
        this.currentUser.setGender(userTmp.getGender());
        this.currentUser.setPhoneNumer(userTmp.getPhoneNumer());
    }
    
    public void setUserID(String email, User user){
        List<User> userList = userService.searchByEmail(email);
        user.setUserId(userList.get(0).getUserId());
    }   
    
    // validate the phoneNumber
    public boolean isValidPhoneNumber(String phoneNumber, String contryCode){
        
        boolean isValid=PhoneFormatValidator.isPhoneNumberValid(phoneNumber, contryCode);
        return isValid;
    }
    
    public static void main(String[] args) {
        try {
            final OnlineBookCity store = new OnlineBookCity("Chao Xin Online Book City");
            //JDK 1.8
            SwingUtilities.invokeLater(()-> {
                store.initView();
            });
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }
}
