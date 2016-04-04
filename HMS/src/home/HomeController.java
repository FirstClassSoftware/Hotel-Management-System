
package home;

/**
 *
 * @author Yeejkoob Thao
 */
import java.sql.*;
import javax.swing.*;
public class HomeController {
    
    private HomeView homeView;
    private HomeModel homeModel;
    private ResultSet allUsers;
    
    public HomeController(HomeView theView, HomeModel theModel) {
    
        this.homeView = theView;
        this.homeModel = theModel;
                    
    }
    
    public void checkPermissions(String userLevel) {
    
        if(userLevel == "Receptionist") {
        
            homeView.getInventoryMngButton().setEnabled(false);
            homeView.getStaffMngButton().setEnabled(false);
            homeView.getFinanceMngButton().setEnabled(false);
            homeView.getUserMngButton().setEnabled(false);
        
        }
            
    }
    
    public void updateUserLevelLabel(String userLevel) {
    
        homeView.getUserLevelLabel().setText(userLevel);
        //allUsers = homeModel.getAllUsers();
        
    }
    
   
    
}
