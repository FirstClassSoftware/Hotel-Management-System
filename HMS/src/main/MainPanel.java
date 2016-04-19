package main;

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
import room.*;
import ReservationModule.*;
import CustomerModule.*;
import Inventory.*;
import Finance.*;
/**
 *
 * @author Yeejkoob Thao
 */
public class MainPanel extends JPanel {
    /////////////////////////////////////////////////////////////////////
    ReservationModel resModel;
    ReservationView resView;
    ReservationControl resControl;
    //////////////////////////////////////////////////////////////////////
    CustomerModel custModel;
    CustomerView custView;
    CustomerControl custControl;
    //////////////////////////////////////////////////////////////////////
    RoomModel roomModel;
    RoomView roomView;
    RoomController roomController;
    //////////////////////////////////////////////////////////////////////
    LoginView loginView;
    LoginModel loginModel;
    LoginController loginController;
    //////////////////////////////////////////////////////////////////////
    HomeView homeView;
    HomeModel homeModel;
    HomeController homeController;
    //////////////////////////////////////////////////////////////////////
    UserView userView;
    UserModel userModel;
    UserController userController;
    //////////////////////////////////////////////////////////////////////
    StaffView staffView;
    StaffModel staffModel;
    StaffController staffController;
    //////////////////////////////////////////////////////////////////////
    InventoryView inventoryView;
    InventoryModel inventoryModel;
    InventoryController inventoryController;
    //////////////////////////////////////////////////////////////////////
    FinanceView financeView;
    FinanceModel financeModel;
    FinanceController financeController;
    //////////////////////////////////////////////////////////////////////
    public MainPanel() {
        
        custModel = new CustomerModel();
        custView = new CustomerView(this, custModel);
        custControl = new CustomerControl(custModel, custView);
        custView.registerListener(custControl);
        //////////////////////////////////////////////////////////////////////
        resModel = new ReservationModel();
        resView = new ReservationView(this, resModel);
        resControl = new ReservationControl(resModel, resView, custModel);
        resView.registerListener(resControl);
        //////////////////////////////////////////////////////////////////////
        roomView = new RoomView(this);
        roomModel = new RoomModel();
        roomController = new RoomController(roomView, roomModel);
        //////////////////////////////////////////////////////////////////////
        homeView = new HomeView(this);
        homeModel = new HomeModel();
        homeController = new HomeController(homeView, homeModel);
        //////////////////////////////////////////////////////////////////////
        userView = new UserView(this);
        userModel = new UserModel();
        userController = new UserController(userView, userModel);
        //////////////////////////////////////////////////////////////////////
        loginView = new LoginView(this, homeView, homeController, userController);
        loginModel = new LoginModel();
        loginController = new LoginController(loginView, loginModel);
        //////////////////////////////////////////////////////////////////////
        staffView = new StaffView(this);
        staffModel = new StaffModel();
        staffController = new StaffController(staffView, staffModel);
        //////////////////////////////////////////////////////////////////////
        inventoryModel = new InventoryModel();
        inventoryView = new InventoryView(this, inventoryModel);
        inventoryController = new InventoryController(inventoryModel, inventoryView);
        inventoryView.registerListener(inventoryController);
        //////////////////////////////////////////////////////////////////////
        financeView = new FinanceView(this);
        financeModel = new FinanceModel();
        financeController = new FinanceController(financeView, financeModel);
        //////////////////////////////////////////////////////////////////////
        this.setLayout(new CardLayout());
        this.add(loginView, "Login View");
        this.add(roomView, "Room View");
        this.add(homeView, "Home View");
        this.add(userView, "User Management View");
        this.add(staffView, "Staff Management View");
        this.add(resView, "Reservation Screen");
        this.add(custView, "Customer Screen");
        this.add(inventoryView, "Inventory View");
        this.add(financeView, "Finance View");
    }
    
}