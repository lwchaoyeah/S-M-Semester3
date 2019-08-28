/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assign.gui;

import com.entity.Product;
import com.entity.User;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wenchao
 */
public class OnlineBookStoreGUIImpl extends JFrame implements OnlineBookStoreGUI{
    
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    
    // for Jason's use
    private javax.swing.JPanel leftDownJPanel;
    private javax.swing.JPanel rightDownJPanel;
    //jScrollPanel in rightDownJPanel
    private javax.swing.JScrollPane jScrollPane1;
    
    
    private javax.swing.JButton exitButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel welcomLabel;
    private javax.swing.JLabel favorMVLabel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel phoneNumLabel;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel leftUpJPanel;
    private javax.swing.JPanel rightUpJPanel;
    private javax.swing.JRadioButton femaleJRadioButton;
    private javax.swing.JRadioButton maleJRadioButton;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTextField phoneNumTextField;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JTextField favorMVTextField;
    private javax.swing.JComboBox<String> genderJComboBox;
    private javax.swing.JComboBox<String> contryCodeJComboBox;
    
    // search part
    private javax.swing.JComboBox<String> selectProductComboBox;
    private javax.swing.JTextField searchProductBoxTextField;
    private javax.swing.JButton searchProductJButton;
    
    // display part
    private javax.swing.JTable resultDisplayTable;
    
    @SuppressWarnings("unchecked")
    private void initComponents(ActionListener actionListener, ListSelectionListener listSelectionListener) {
        
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        
        //right up
        rightUpJPanel = new javax.swing.JPanel();
        //right down
        rightDownJPanel = new javax.swing.JPanel();
        //right down Scroll
        jScrollPane1 = new javax.swing.JScrollPane();
        
        // left up
        leftUpJPanel = new javax.swing.JPanel();
        //left down
        leftDownJPanel = new javax.swing.JPanel();
        
        lastNameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        //phone Number label
        phoneNumLabel = new javax.swing.JLabel();
        phoneNumTextField = new javax.swing.JTextField();
        ageLabel = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        femaleJRadioButton = new javax.swing.JRadioButton();
        maleJRadioButton = new javax.swing.JRadioButton();
        favorMVLabel = new javax.swing.JLabel();
        favorMVTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        welcomLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        genderJComboBox = new javax.swing.JComboBox<>();
        contryCodeJComboBox = new javax.swing.JComboBox<>();
        
        // search part ********************************************************************************
        selectProductComboBox = new javax.swing.JComboBox<>();
        searchProductBoxTextField = new javax.swing.JTextField();
        searchProductJButton = new javax.swing.JButton();
        searchProductJButton.addActionListener(actionListener);
        // display part*********************************************************************************
        resultDisplayTable = new javax.swing.JTable();
        
        // not use but not modify
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        // not use but not modify
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lastNameLabel.setText("Last Name");
        lastNameTextField.setText("jTextField1");
        //lastNameTextField.addActionListener(actionListener);

        firstNameLabel.setText("First Name");
        firstNameTextField.setText("jTextField2");

        addressLabel.setText("Address");
        addressTextField.setText("jTextField3");

        //phoneNumLabel
        phoneNumLabel.setText("Phone Num");
        phoneNumTextField.setText("jTextField4");

        ageLabel.setText("Age");
        ageTextField.setText("jTextField5");

        genderLabel.setText("Gender");
        femaleJRadioButton.setText("Female");
        femaleJRadioButton.addActionListener(actionListener);
        maleJRadioButton.setText("Male");
        maleJRadioButton.addActionListener(actionListener);

        favorMVLabel.setText("FavoriteMV");
        favorMVTextField.setText("jTextField7");

        saveButton.setText("Save");
        saveButton.addActionListener(actionListener);

        genderJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "male", "female"}));
        
        contryCodeJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+86", "+61", "+81"}));
        
        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(leftDownJPanel);
        leftDownJPanel.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(genderLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phoneNumLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(firstNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lastNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameTextField)
                            .addComponent(firstNameTextField)
                            .addComponent(addressTextField)
                            .addComponent(ageTextField)
                            .addComponent(genderJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(contryCodeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(favorMVLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(favorMVTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(saveButton)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contryCodeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(favorMVLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(favorMVTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(saveButton)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        exitButton.setText("Exit");
        exitButton.addActionListener(actionListener);

        welcomLabel.setText("Welcome to OurBookCity");
        userNameLabel.setText("UserName");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(leftUpJPanel);
        leftUpJPanel.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(exitButton))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(welcomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(userNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addGap(19, 19, 19))
        );

        selectProductComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "Type", "Price"}));
        selectProductComboBox.addActionListener(actionListener);
        
        searchProductBoxTextField.setText("");

        searchProductJButton.setText("Search");
        
        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(rightUpJPanel);
        rightUpJPanel.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(selectProductComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchProductBoxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(searchProductJButton)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchProductJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(selectProductComboBox)
                    .addComponent(searchProductBoxTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        //**************************************************************************************************
        resultDisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null}
            },                                                                          
            new String [] {
               "title", "Author", "category",  "price", "rating"
            }
        ));
        jScrollPane1.setViewportView(resultDisplayTable);
        
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(rightDownJPanel);
        rightDownJPanel.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(leftUpJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftDownJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rightUpJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addGap(0, 260, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightUpJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftUpJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(leftDownJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addGap(0, 213, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(rightDownJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rightDownJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    
    
    public OnlineBookStoreGUIImpl(ActionListener actionListener, ListSelectionListener listSelectionListener){
        initComponents(actionListener, listSelectionListener);
    }
    
    @Override
    public void displayBookStoreGUI(User currentUser) {
        this.displayUserInfo(currentUser);
        this.setVisible(true);
    }

    @Override
    public void hiddenBookStoreGUI() {
        this.setVisible(false);
    }

    @Override
    public JButton getSaveButton() {
        return saveButton;
    }

    @Override
    public JButton getExitButton() {
        return exitButton;
    }

    @Override
    public JButton getSearchButton() {
       return searchProductJButton;
    }

    @Override
    public JComboBox<String> getSearchComBoxValue() {
        return selectProductComboBox;
    }

    @Override
    public JComboBox<String> getProducttSelectComboBox() {
        return selectProductComboBox;
    }

    @Override
    public JTextField getProductJTextField() {
        return searchProductBoxTextField;
    }

    @Override
    public JTable getResultDisplayTable() {
        return resultDisplayTable;
    }
    
    
    @Override
    public void clearResultDisplayTable() {     
        int numberOfRow = this.resultDisplayTable.getModel().getRowCount();
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.resultDisplayTable.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index --) {
                tableModel.removeRow(index);
            }            
        }
    }

    @Override
    public void setResultDisplayTable(List<Product> products) {
        this.clearResultDisplayTable();
        for (Product product : products) {
            ((DefaultTableModel)this.resultDisplayTable.getModel()).addRow(new Object[]{product.getShortTitle(), 
                                                                                        product.getAuthor(),
                                                                                        product.getCategory(),
                                                                                        product.getPrice(),
                                                                                        product.getRating()
                                                                                   });
        }
    }
    
    // Australia 61, China 86, Japan 81
    @Override
    public String getContryCode(){
        return contryCodeJComboBox.getSelectedItem().toString().trim();
    }
    
    @Override
    public String getPhoneNumber(){
        return phoneNumTextField.getText();
    }
    
    public void exitFirstPage() {
        this.dispose();
    }

    private void displayUserInfo(User user) {
        this.userNameLabel.setText(user.getEmail());
        this.lastNameTextField.setText(user.getLastName());
        this.firstNameTextField.setText(user.getFirstName());
        this.addressTextField.setText(user.getAddress());
        this.phoneNumTextField.setText(user.getPhoneNumer());
        this.ageTextField.setText( user.getAge()==null?"":String.valueOf(user.getAge()) );
        // set gender
        if(user.getGender()!=null && user.getGender().equals("male")){
            this.genderJComboBox.setSelectedIndex(1);
        }
        else if(user.getGender()!=null && user.getGender().equals("female")){
            this.genderJComboBox.setSelectedIndex(1);
        }
        this.favorMVTextField.setText(user.getFavorMovie());
    }

    @Override
    public User updateUserInfo() {
        User user=new User();
        String lastName = this.lastNameTextField.getText();
        String firstName = this.firstNameTextField.getText();
        String address = this.addressTextField.getText();
        String phoneNum = this.phoneNumTextField.getText();
        
        Integer age = this.isAgeValid(this.ageTextField.getText())?Integer.parseInt(this.ageTextField.getText()):null;
        // set gender
        String gender = this.genderJComboBox.getSelectedItem().toString().trim();
        String favorMV=this.favorMVTextField.getText();
        
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setAddress(address);
        user.setPhoneNumer(phoneNum);
        user.setAge(age);
        user.setFavorMovie(favorMV);
        user.setGender(gender);
        
        return user;
    }
    
    public boolean isAgeValid(String str){
        if(str.length()==0){
            return false;
        }
        for(int i=0;i<str.length();i++){
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                return false;
            } 
        }
        return true;
    }

    @Override
    public String getFirstName() {
        return firstNameTextField.getText();
    }

    @Override
    public String getLastName() {
        return lastNameTextField.getText();
    }

    @Override
    public String getAge() {
        return ageTextField.getText();
    }

}
