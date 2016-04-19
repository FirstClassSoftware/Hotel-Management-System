/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class tests to see if the all three components: the view, model, and
 * controller can be used to produce a valid frame.
 * @author Yeejkoob Thao
 */
import usermanagementview.*;
import javax.swing.*;
public class TestUserView {
    
    public static void main(String[]args) {
    
        JFrame newFrame = new JFrame();
        newFrame.setSize(600, 600);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        UserView theView = new UserView();
        UserModel theModel = new UserModel();
        //theModel.addNewUser("admin", "admin", "Owner");
        UserController theController = new UserController(theView, theModel);   
        newFrame.getContentPane().add(theView);
        newFrame.setVisible(true);
        
        
    }
    
}
