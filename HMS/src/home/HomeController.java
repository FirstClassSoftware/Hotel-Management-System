
package home;

/**
 *
 * @author Yeejkoob Thao
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class HomeController {
    
    private HomeView homeView;
    private HomeModel homeModel;
    private ResultSet allUsers;
    
    public HomeController(HomeView theView, HomeModel theModel) {
    
        this.homeView = theView;
        this.homeModel = theModel;
        this.homeView.addLogoutButtonListener(new LogoutListener());
        this.homeView.addUserManagementButtonListener(new UserManagementListener());
        this.homeView.addStaffManagementButtonListener(new StaffManagementListener());
        this.homeView.addReservationCustomerManagementButtonListener(new ResCusManagementListener());
        this.homeView.addRoomManagementButtonListener(new RoomManagementListener());
        this.homeView.addInventoryManagementButtonListener(new InventoryManagementListener());
        this.homeView.addFinanceManagementButtonListener(new FinanceManagementListener());
    }
    
    class RoomManagementListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.goToRoomManagemetView();
        }
        
    }

    class ResCusManagementListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.goToResCusManagementView();
        }
    
    
    }
    
    class LogoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.goToLoginView();
        }
    
    }
    
    class UserManagementListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.goToUserManagementView();
        }
    
    }
    
    class StaffManagementListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.goToStaffManagementView();
        }
    
    }
    
    class InventoryManagementListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.goToInventoryView();
        }
        
    }
    
    class FinanceManagementListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            homeView.goToFinanceView();
        }
        
    }
    
    public void checkPermissions() {
        String userLevel = homeView.getUserLevelLabel().getText();
       
        if(userLevel.equals("Receptionist")) {
        
            homeView.getInventoryMngButton().setEnabled(false);
            homeView.getStaffMngButton().setEnabled(false);
            homeView.getFinanceMngButton().setEnabled(false);
            homeView.getUserMngButton().setEnabled(false);
        
        }
        else {
            homeView.getInventoryMngButton().setEnabled(true);
            homeView.getStaffMngButton().setEnabled(true);
            homeView.getFinanceMngButton().setEnabled(true);
            homeView.getUserMngButton().setEnabled(true);
        }
            
    }
    
    public void updateUserLevelLabel(String userLevel) {
    
        homeView.getUserLevelLabel().setText(userLevel);
        //allUsers = homeModel.getAllUsers();
        
    }
    
   
    
}
