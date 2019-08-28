/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assign.gui;

import com.entity.Product;
import com.entity.User;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wenchao
 */
public interface OnlineBookStoreGUI {
    
    public void displayBookStoreGUI(User currentUser);
    
    public void hiddenBookStoreGUI();
    
    public JButton getExitButton();
    
    public JButton getSaveButton();
//    product GUI component    
    public JButton getSearchButton();
//    product GUI component
    public JComboBox<String> getSearchComBoxValue();
 
    public void exitFirstPage();
    
    public User updateUserInfo();
    
    public String getContryCode();
    public String getPhoneNumber();
    public String getFirstName();
    public String getLastName();
    public String getAge();
    
//    product GUI component
    public JComboBox<String> getProducttSelectComboBox();
    public JTextField getProductJTextField();
    public JTable getResultDisplayTable();
    public void clearResultDisplayTable();
    public void setResultDisplayTable(List<Product> products);

}
