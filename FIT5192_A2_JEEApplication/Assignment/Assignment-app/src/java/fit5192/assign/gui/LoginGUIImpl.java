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
public class LoginGUIImpl extends JFrame implements LoginGUI{
    
    // 2 Buttons
    private JButton loginButton;
    private JButton registerButton;
    
    // 2 Panel
    private JPanel buttonPanel;
    private JPanel inputPanel;
    
    // 2 labels before area you type in
    private JLabel emailLabel;
    private JLabel passwdLabel;
    
    // 2 in information field
    private JTextField emailTextField;
    private JPasswordField passwdTextField;
    
    public LoginGUIImpl(){
    
    }
    
    public LoginGUIImpl( ActionListener actionListener, ListSelectionListener listSelectionListener ){
        initComponents(actionListener,listSelectionListener);
    }
    
    
    
    @SuppressWarnings("unchecked")
    private void initComponents(ActionListener actionListener, ListSelectionListener listSelectionListener){
        this.loginButton = new JButton("Login");
        this.registerButton = new JButton("Register");
        this.buttonPanel = new JPanel();
        this.inputPanel = new JPanel();
        this.emailLabel = new JLabel("Email:");
        this.passwdLabel = new JLabel("Password:");
        this.emailTextField = new JTextField();
        this.passwdTextField = new JPasswordField();
        
        // create container
        Container container = this.getContentPane();
        
        // set layout manager
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(2,2));
        this.buttonPanel.setLayout(new GridLayout(1, 2));
    
        // add action listeners
        this.loginButton.addActionListener(actionListener);
        this.registerButton.addActionListener(actionListener);
        
        // add components
        this.inputPanel.add(emailLabel);
        this.inputPanel.add(emailTextField);
        this.inputPanel.add(passwdLabel);
        this.inputPanel.add(passwdTextField);
        
        // add buttons to panel
        this.buttonPanel.add(loginButton);
        this.buttonPanel.add(registerButton);
        
        // add panels to content pane
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.SOUTH);
        
        // change the default behaviour of the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(650, 570);
        //this.setVisible(true);
    }
    
    @Override
    public void displayLoginGUI(){
        this.clearTextFields();
        this.setVisible(true);
    }
    
    @Override
    public void hiddenLoginGUI(){
        this.setVisible(false);
    }
    
    public void clearTextFields() {
        this.emailTextField.setText("");
        this.passwdTextField.setText("");  
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
    public JButton getLoginButton() {
        return loginButton;
    }

    @Override
    public JButton getRegisterButton() {
        return registerButton;
    }

    @Override
    public void exitLoginPage() {
        this.dispose();
    }
}
