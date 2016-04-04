/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author Whelan
 */
public class AddNewCustView extends JPanel {
    //CustomerView parentCustView;
    
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblNumOfOccupants;
    private JLabel lblOccupationDate;
    private JLabel lblAddress;
    private JLabel lblTab;
    private JLabel lblLastRoomNum;
    private JLabel lblPhoneNum;
    private JLabel lblEmail;
    private JLabel lblPaymentMethod;
    
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtNumOfOccupants;
    private JTextField txtOccupationDate;
    private JTextField txtAddress;
    private JTextField txtTab;
    private JTextField txtLastRoomNum;
    private JTextField txtPhoneNum;
    private JTextField txtEmail;
    private JTextField txtPaymentMethod;
    
    private JButton btnSubmit;
    
    
    public AddNewCustView(/*CustomerView parentCustView*/) {
        //this.parentCustView = parentCustView;
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 10;
        c.anchor = c.LINE_END;
        Insets topSpaceInset = new Insets(10, 0, 0 ,0);
        c.insets = topSpaceInset;
        
        
        
        
        
        
        
        lblFirstName = new JLabel("First Name");
        c.gridx = 0;
        c.gridy = 0;
        this.add(lblFirstName, c);
        
        lblLastName = new JLabel("Last Name");
        c.gridx = 0;
        c.gridy = 1;
        this.add(lblLastName, c);
        
        lblNumOfOccupants = new JLabel("Number of Occupants");
        c.gridx = 0;
        c.gridy = 2;
        this.add(lblNumOfOccupants, c);
        
        lblOccupationDate = new JLabel("Occupation Date");
        c.gridx = 0;
        c.gridy = 3;
        this.add(lblOccupationDate, c);
        
        lblAddress = new JLabel("Address");
        c.gridx = 0;
        c.gridy = 4;
        this.add(lblAddress, c);
        
        lblTab = new JLabel("Tab");
        c.gridx = 0;
        c.gridy = 5;
        this.add(lblTab, c);
        
        lblLastRoomNum = new JLabel("Last Room Number");
        c.gridx = 0;
        c.gridy = 6;
        this.add(lblLastRoomNum, c);
        
        lblPhoneNum = new JLabel("Phone Number");
        c.gridx = 0;
        c.gridy = 7;
        this.add(lblPhoneNum, c);
        
        lblEmail = new JLabel("Email Address");
        c.gridx = 0;
        c.gridy = 8;
        this.add(lblEmail, c);
        
        lblPaymentMethod = new JLabel("Payment Method");
        c.gridx = 0;
        c.gridy = 9;
        this.add(lblPaymentMethod, c);
        
        
        
        
        
        
        
        int txtSize = 20;
        txtFirstName = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 0;
        this.add(txtFirstName, c);
        
        txtLastName = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 1;
        this.add(txtLastName, c);
        
        txtNumOfOccupants = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 2;
        this.add(txtNumOfOccupants, c);
        
        txtOccupationDate = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 3;
        this.add(txtOccupationDate, c);
        
        txtAddress = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 4;
        this.add(txtAddress, c);
        
        txtTab = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 5;
        this.add(txtTab, c);
        
        txtLastRoomNum = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 6;
        this.add(txtLastRoomNum, c);
        
        txtPhoneNum = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 7;
        this.add(txtPhoneNum, c);
        
        txtEmail = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 8;
        this.add(txtEmail, c);
        
        txtPaymentMethod = new JTextField(txtSize);
        c.gridx = 1;
        c.gridy = 9;
        this.add(txtPaymentMethod, c);
        
        
        
        
        
        
        
        btnSubmit = new JButton();
        btnSubmit.setText("Submit");
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 2;
        c.anchor = c.CENTER;
        this.add(btnSubmit, c);
    }

    /**
     * @return the lblFirstName
     */
    public JLabel getLblFirstName() {
        return lblFirstName;
    }

    /**
     * @param lblFirstName the lblFirstName to set
     */
    public void setLblFirstName(JLabel lblFirstName) {
        this.lblFirstName = lblFirstName;
    }

    /**
     * @return the lblLastName
     */
    public JLabel getLblLastName() {
        return lblLastName;
    }

    /**
     * @param lblLastName the lblLastName to set
     */
    public void setLblLastName(JLabel lblLastName) {
        this.lblLastName = lblLastName;
    }

    /**
     * @return the lblNumOfOccupants
     */
    public JLabel getLblNumOfOccupants() {
        return lblNumOfOccupants;
    }

    /**
     * @param lblNumOfOccupants the lblNumOfOccupants to set
     */
    public void setLblNumOfOccupants(JLabel lblNumOfOccupants) {
        this.lblNumOfOccupants = lblNumOfOccupants;
    }

    /**
     * @return the lblOccupationDate
     */
    public JLabel getLblOccupationDate() {
        return lblOccupationDate;
    }

    /**
     * @param lblOccupationDate the lblOccupationDate to set
     */
    public void setLblOccupationDate(JLabel lblOccupationDate) {
        this.lblOccupationDate = lblOccupationDate;
    }

    /**
     * @return the lblAddress
     */
    public JLabel getLblAddress() {
        return lblAddress;
    }

    /**
     * @param lblAddress the lblAddress to set
     */
    public void setLblAddress(JLabel lblAddress) {
        this.lblAddress = lblAddress;
    }

    /**
     * @return the lblTab
     */
    public JLabel getLblTab() {
        return lblTab;
    }

    /**
     * @param lblTab the lblTab to set
     */
    public void setLblTab(JLabel lblTab) {
        this.lblTab = lblTab;
    }

    /**
     * @return the lblLastRoomNum
     */
    public JLabel getLblLastRoomNum() {
        return lblLastRoomNum;
    }

    /**
     * @param lblLastRoomNum the lblLastRoomNum to set
     */
    public void setLblLastRoomNum(JLabel lblLastRoomNum) {
        this.lblLastRoomNum = lblLastRoomNum;
    }

    /**
     * @return the lblPhoneNum
     */
    public JLabel getLblPhoneNum() {
        return lblPhoneNum;
    }

    /**
     * @param lblPhoneNum the lblPhoneNum to set
     */
    public void setLblPhoneNum(JLabel lblPhoneNum) {
        this.lblPhoneNum = lblPhoneNum;
    }

    /**
     * @return the lblEmail
     */
    public JLabel getLblEmail() {
        return lblEmail;
    }

    /**
     * @param lblEmail the lblEmail to set
     */
    public void setLblEmail(JLabel lblEmail) {
        this.lblEmail = lblEmail;
    }

    /**
     * @return the lblPaymentMethod
     */
    public JLabel getLblPaymentMethod() {
        return lblPaymentMethod;
    }

    /**
     * @param lblPaymentMethod the lblPaymentMethod to set
     */
    public void setLblPaymentMethod(JLabel lblPaymentMethod) {
        this.lblPaymentMethod = lblPaymentMethod;
    }

    /**
     * @return the txtFirstName
     */
    public JTextField getTxtFirstName() {
        return txtFirstName;
    }

    /**
     * @param txtFirstName the txtFirstName to set
     */
    public void setTxtFirstName(JTextField txtFirstName) {
        this.txtFirstName = txtFirstName;
    }

    /**
     * @return the txtLastName
     */
    public JTextField getTxtLastName() {
        return txtLastName;
    }

    /**
     * @param txtLastName the txtLastName to set
     */
    public void setTxtLastName(JTextField txtLastName) {
        this.txtLastName = txtLastName;
    }

    /**
     * @return the txtNumOfOccupants
     */
    public JTextField getTxtNumOfOccupants() {
        return txtNumOfOccupants;
    }

    /**
     * @param txtNumOfOccupants the txtNumOfOccupants to set
     */
    public void setTxtNumOfOccupants(JTextField txtNumOfOccupants) {
        this.txtNumOfOccupants = txtNumOfOccupants;
    }

    /**
     * @return the txtOccupationDate
     */
    public JTextField getTxtOccupationDate() {
        return txtOccupationDate;
    }

    /**
     * @param txtOccupationDate the txtOccupationDate to set
     */
    public void setTxtOccupationDate(JTextField txtOccupationDate) {
        this.txtOccupationDate = txtOccupationDate;
    }

    /**
     * @return the txtAddress
     */
    public JTextField getTxtAddress() {
        return txtAddress;
    }

    /**
     * @param txtAddress the txtAddress to set
     */
    public void setTxtAddress(JTextField txtAddress) {
        this.txtAddress = txtAddress;
    }

    /**
     * @return the txtTab
     */
    public JTextField getTxtTab() {
        return txtTab;
    }

    /**
     * @param txtTab the txtTab to set
     */
    public void setTxtTab(JTextField txtTab) {
        this.txtTab = txtTab;
    }

    /**
     * @return the txtLastRoomNum
     */
    public JTextField getTxtLastRoomNum() {
        return txtLastRoomNum;
    }

    /**
     * @param txtLastRoomNum the txtLastRoomNum to set
     */
    public void setTxtLastRoomNum(JTextField txtLastRoomNum) {
        this.txtLastRoomNum = txtLastRoomNum;
    }

    /**
     * @return the txtPhoneNum
     */
    public JTextField getTxtPhoneNum() {
        return txtPhoneNum;
    }

    /**
     * @param txtPhoneNum the txtPhoneNum to set
     */
    public void setTxtPhoneNum(JTextField txtPhoneNum) {
        this.txtPhoneNum = txtPhoneNum;
    }

    /**
     * @return the txtEmail
     */
    public JTextField getTxtEmail() {
        return txtEmail;
    }

    /**
     * @param txtEmail the txtEmail to set
     */
    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    /**
     * @return the txtPaymentMethod
     */
    public JTextField getTxtPaymentMethod() {
        return txtPaymentMethod;
    }

    /**
     * @param txtPaymentMethod the txtPaymentMethod to set
     */
    public void setTxtPaymentMethod(JTextField txtPaymentMethod) {
        this.txtPaymentMethod = txtPaymentMethod;
    }
    
    /**
     * @return the btnSubmit
     */
    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    /**
     * @param btnSubmit the btnSubmit to set
     */
    public void setBtnSubmit(JButton btnSubmit) {
        this.btnSubmit = btnSubmit;
    }
    
    public void resetFields() {
        
        txtFirstName.setText("");
        txtLastName.setText("");
        txtNumOfOccupants.setText("");
        txtOccupationDate.setText("");
        txtAddress.setText("");
        txtTab.setText("");
        txtLastRoomNum.setText("");
        txtPhoneNum.setText("");
        txtEmail.setText("");
        txtPaymentMethod.setText("");
        
    }
    
}
