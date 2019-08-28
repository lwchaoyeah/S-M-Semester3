/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assign.gui;

import javax.swing.JButton;

/**
 *
 * @author Wenchao
 */
public interface LoginGUI {
    
    public String getPasswd();
    
    public String getEmail();
    
    public JButton getLoginButton();

    public JButton getRegisterButton();
    
    public void displayLoginGUI();
    
    public void hiddenLoginGUI();
    
    public void exitLoginPage();
}
