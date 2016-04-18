
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
    
    public void checkPermissions() {
        String userLevel = homeView.getUserLevelLabel().getText();
        System.out.println("This is the current user level " + userLevel);
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
