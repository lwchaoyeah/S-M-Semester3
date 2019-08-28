/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assign.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Wenchao
 */

public class RegisterGUIImpl extends JFrame implements RegisterGUI{
    
    // 2 Buttons
    private JButton backButton;
    private JButton registerButton;
    
    // 2 Panel
    private JPanel buttonPanel;
    private JPanel inputPanel;
    
    // 2 labels before area you type in
    private JLabel emailLabel;
    private JLabel passwdLabel;
    private JLabel rePasswdLabel;
    
    // 2 in information field
    private JTextField emailTextField;
    private JPasswordField passwdTextField;
    private JPasswordField rePasswdTextField;
   
    public RegisterGUIImpl(ActionListener actionListener, ListSelectionListener listSelectionListener){
        initComponents(actionListener, listSelectionListener);
    }
    
    public RegisterGUIImpl(){
        
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents(ActionListener actionListener, ListSelectionListener listSelectionListener){
        this.backButton = new JButton("Go Back");
        this.registerButton = new JButton("Register");
        this.buttonPanel = new JPanel();
        this.inputPanel = new JPanel();
        this.emailLabel = new JLabel("Email:");
        this.passwdLabel = new JLabel("Password:");
        this.rePasswdLabel = new JLabel("Re-Enter Password:");
        this.emailTextField = new JTextField();
        this.passwdTextField = new JPasswordField();
        this.rePasswdTextField = new JPasswordField();
        
        // create container
        Container container = this.getContentPane();
        
        // set layout manager
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(3,2));
        this.buttonPanel.setLayout(new GridLayout(1, 2));
    
        // add action listeners
        this.backButton.addActionListener(actionListener);
        this.registerButton.addActionListener(actionListener);
        
        // add components
        this.inputPanel.add(emailLabel);
        this.inputPanel.add(emailTextField);
        this.inputPanel.add(passwdLabel);
        this.inputPanel.add(passwdTextField);
        this.inputPanel.add(rePasswdLabel);
        this.inputPanel.add(rePasswdTextField);
        
        // add buttons to panel
        this.buttonPanel.add(registerButton);
        this.buttonPanel.add(backButton);
        
        // add panels to content pane
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.SOUTH);
        
        // change the default behaviour of the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(650, 570);
        //this.setVisible(true);
    }
    
    public void clearTextFields() {
        this.emailTextField.setText("");
        this.passwdTextField.setText("");
        this.rePasswdTextField.setText("");
    }
    
    @Override
    public void displayRegisterGUI(){
        this.clearTextFields();
        this.setVisible(true);
    }
    @Override
    public void hiddenRegisterGUI(){
        this.setVisible(false);
    }
    
    @Override
    public String getEmail(){
        String email = this.emailTextField.getText();
        return email;
    }
    
    @Override
    public String getPasswd(){
        char[] passwd=this.passwdTextField.getPassword();
        return new String(passwd);
    }
    
    @Override
    public String getRePasswd(){
        char[] passwd=this.rePasswdTextField.getPassword();
        return new String(passwd);
    }
    
    @Override
    public JButton getBackButton() {
        return backButton;
    }

    @Override
    public JButton getRegisterButton() {
        return registerButton;
    }

    @Override
    public void exitRegisterPage() {
        this.dispose();
    }
    
}