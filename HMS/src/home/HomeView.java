
package home;

/**
 * 
 * @author Yeejkoob Thao
 */
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
public class HomeView extends javax.swing.JPanel {

    private JPanel allPanelContainer;
    /**
     * Creates new form HomeView
     */
    public HomeView(JPanel panelContainer) {
        this.allPanelContainer = panelContainer;
        initComponents();
    }

    public JLabel getUserLevelLabel() {
    
        return userLevelLabel;
            
    }
    
    public void setUserLevelLabel(String userLevel) {
        this.userLevelLabel.setText(userLevel);
    }
    
    public JButton getInventoryMngButton() {
    
        return inventoryMngButton;
    
    }
    
    public JButton getStaffMngButton() {
    
        return staffMngButton;
        
    }
    
    public JButton getFinanceMngButton() {
    
        return financeMngButton;
    
    }
    
    public JButton getUserMngButton() {
    
        return userMngButton;
    
    }
    
    public void goToLoginView() {
        CardLayout cardLayout = (CardLayout) allPanelContainer.getLayout();
        cardLayout.show(allPanelContainer, "Login View");
    }
    
    public void goToRoomManagemetView() {
        CardLayout cardLayout = (CardLayout) allPanelContainer.getLayout();
        cardLayout.show(allPanelContainer, "Room View");
    }
    
    public void goToUserManagementView() {
        CardLayout cardLayout = (CardLayout) allPanelContainer.getLayout();
        cardLayout.show(allPanelContainer, "User Management View");
    }
    
    public void goToStaffManagementView() {
        CardLayout cardLayout = (CardLayout) allPanelContainer.getLayout();
        cardLayout.show(allPanelContainer, "Staff Management View");
    }
    
    public void goToResCusManagementView() {
        CardLayout cardLayout = (CardLayout) allPanelContainer.getLayout();
        cardLayout.show(allPanelContainer, "Reservation Screen");
    }
    
    public void goToInventoryView() {
        CardLayout cardLayout = (CardLayout) allPanelContainer.getLayout();
        cardLayout.show(allPanelContainer, "Inventory View");
    }
    
    public void goToFinanceView() {
        CardLayout cardLayout = (CardLayout) allPanelContainer.getLayout();
        cardLayout.show(allPanelContainer, "Finance View");
    }
    
    void addLogoutButtonListener(ActionListener listenForLogout) {
        logoutButton.addActionListener(listenForLogout);
    }
    
    void addUserManagementButtonListener(ActionListener listenForUserManagement) {
        userMngButton.addActionListener(listenForUserManagement);
    }
    
    void addStaffManagementButtonListener(ActionListener listenForStaffManagement) {
        staffMngButton.addActionListener(listenForStaffManagement);
    }
    
    void addReservationCustomerManagementButtonListener(ActionListener listenForReservationCustomerManagement) {
        ResCustMngButton.addActionListener(listenForReservationCustomerManagement);
    }
    
    void addRoomManagementButtonListener(ActionListener listenForRoomManagement) {
        roomMngButton.addActionListener(listenForRoomManagement);
    }
    
    void addInventoryManagementButtonListener(ActionListener listenForInventoryManagment) {
        inventoryMngButton.addActionListener(listenForInventoryManagment);
    }
    
    void addFinanceManagementButtonListener(ActionListener listenForFinanceManagment) {
        financeMngButton.addActionListener(listenForFinanceManagment);
    }
    
    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton7 = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        roomMngButton = new javax.swing.JButton();
        ResCustMngButton = new javax.swing.JButton();
        inventoryMngButton = new javax.swing.JButton();
        staffMngButton = new javax.swing.JButton();
        financeMngButton = new javax.swing.JButton();
        userMngButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        userLevelLabel = new javax.swing.JLabel();

        jButton7.setText("jButton7");

        setLayout(new java.awt.GridBagLayout());

        title.setText("Hotel Management System: Home");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(title, gridBagConstraints);

        roomMngButton.setText("Room Management");
        roomMngButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomMngButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(roomMngButton, gridBagConstraints);

        ResCustMngButton.setText("Reservation/Customer Management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(ResCustMngButton, gridBagConstraints);

        inventoryMngButton.setText("Inventory Management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 88;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(inventoryMngButton, gridBagConstraints);

        staffMngButton.setText("Staff Management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(staffMngButton, gridBagConstraints);

        financeMngButton.setText("Finance Management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 102;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(financeMngButton, gridBagConstraints);

        userMngButton.setText("User Management");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(userMngButton, gridBagConstraints);

        logoutButton.setText("Logout");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        add(logoutButton, gridBagConstraints);

        userLevelLabel.setText("Userlevel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        add(userLevelLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void roomMngButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomMngButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomMngButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ResCustMngButton;
    private javax.swing.JButton financeMngButton;
    private javax.swing.JButton inventoryMngButton;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton roomMngButton;
    private javax.swing.JButton staffMngButton;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLevelLabel;
    private javax.swing.JButton userMngButton;
    // End of variables declaration//GEN-END:variables
}
