/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
import ReservationModule.ReservationModel;
import ReservationModule.ReservationControl;
import ReservationModule.ReservationView;
import CustomerModule.CustomerControl;
import CustomerModule.CustomerModel;
import CustomerModule.CustomerView;
import RoomModule.RoomsModel;
*/
import javax.swing.JPanel;
import java.awt.CardLayout;
import login.*;
import home.*;
import usermanagementview.*;
import staff.*;
import AddNewEmployee.*;
import AddNewUser.*;

/**
 *
 * @author Yeejkoob Thao
 */
public class MainPanel extends JPanel {
    /*
    ReservationModel resModel;
    ReservationView resView;
    ReservationControl resControl;
    
    CustomerModel custModel;
    CustomerView custView;
    CustomerControl custControl;
    
    RoomsModel hotelModel;
    */
    
    LoginView loginView;
    LoginModel loginModel;
    LoginController loginController;
    
    HomeView homeView;
    HomeModel homeModel;
    HomeController homeController;
    
    UserView userView;
    UserModel userModel;
    UserController userController;
    
    StaffView staffView;
    StaffModel staffModel;
    StaffController staffController;
    
    public MainPanel() {
        /*
        custModel = new CustomerModel();
        custView = new CustomerView(this, custModel);
        custControl = new CustomerControl(custModel, custView);
        custView.registerListener(custControl);
        
        resModel = new ReservationModel();
        resView = new ReservationView(this, resModel);
        resControl = new ReservationControl(resModel, resView, custModel);
        resView.registerListener(resControl);
        
        hotelModel = new RoomsModel();
        
        this.setLayout(new CardLayout());
        this.add(resView, "Reservation Screen");
        this.add(custView, "Customer Screen");
        */
        loginView = new LoginView(this);
        loginModel = new LoginModel();
        loginController = new LoginController(loginView, loginModel);
        
        homeView = new HomeView(this);
        homeModel = new HomeModel();
        homeController = new HomeController(homeView, homeModel);
        
        userView = new UserView(this);
        userModel = new UserModel();
        userController = new UserController(userView, userModel);
        
        staffView = new StaffView(this);
        staffModel = new StaffModel();
        staffController = new StaffController(staffView, staffModel);
        
        this.setLayout(new CardLayout());
        this.add(loginView, "Login View");
        this.add(homeView, "Home View");
        this.add(userView, "User Management View");
        this.add(staffView, "Staff Management View");
        
    }
    
}