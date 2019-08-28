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
public interface RegisterGUI {

    public String getPasswd();
    
    public String getRePasswd();
    
    public String getEmail();
    
    public JButton getRegisterButton();
    
    public JButton getBackButton();
    
    public void displayRegisterGUI();
    
    public void hiddenRegisterGUI();
    
    public void exitRegisterPage();
}
