/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JPanel;
import java.awt.CardLayout;
/*import login.*;
import home.*;
import usermanagementview.*;
import staff.*;
import AddNewEmployee.*;
import AddNewUser.*;
import RoomModule.*;
import ReservationModule.*;
import CustomerModule.*;*/
import Inventory.*;

/**
 *
 * @author jessicaluu
 */
public class MainPanel extends JPanel {
    
    /*LoginModel loginModel;
    LoginView loginView;
    LoginController loginController;
    
    HomeModel homeModel;
    HomeView homeView;
    HomeController homeController;
    
    ReservationModel resModel;
    ReservationView resView;
    ReservationControl resControl;
    
    CustomerModel custModel;
    CustomerView custView;
    CustomerControl custControl;
    
    RoomsModel hotelModel;*/
    
    InventoryModel invModel;
    InventoryView invView;
    InventoryController invController;
    
    /*StaffModel staffModel;
    StaffView staffView;
    StaffController staffController;
    
    UserModel userModel;
    UserView userView;
    UserController userController;*/
    
    public MainPanel() {
        
        /*loginModel = new LoginModel();        
        loginView = new LoginView(this);
        loginController = new LoginController(loginView, loginModel);
        
        homeModel = new HomeModel();        
        homeView = new HomeView(this);
        homeController = new HomeController(homeView, homeModel);
        
        custModel = new CustomerModel();
        custView = new CustomerView(this, custModel);
        custControl = new CustomerControl(custModel, custView);
        custView.registerListener(custControl);
        
        resModel = new ReservationModel();
        resView = new ReservationView(this, resModel);
        resControl = new ReservationControl(resModel, resView, custModel);
        resView.registerListener(resControl);
        
        hotelModel = new RoomsModel();*/
        
        invModel = new InventoryModel();
        invView = new InventoryView(this, invModel);
        invController = new InventoryController(invModel, invView);
        invView.registerListener(invController);
        
        /*userView = new UserView(this);
        userModel = new UserModel();
        userController = new UserController(userView, userModel);
        
        staffView = new StaffView(this);
        staffModel = new StaffModel();
        staffController = new StaffController(staffView, staffModel);*/
        
        this.setLayout(new CardLayout());
        /*this.add(loginView, "Login View");
        this.add(homeView, "Home View");
        this.add(resView, "Reservation Screen");
        this.add(custView, "Customer Screen");*/
        this.add(invView, "Inventory View");
        /*this.add(userView, "User Management View");
        this.add(staffView, "Staff Management View");*/
    }
    
    
}
