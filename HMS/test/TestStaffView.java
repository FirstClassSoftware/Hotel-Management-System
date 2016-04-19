
import javax.swing.JFrame;
import staff.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yeejkoob Thao
 */
public class TestStaffView {
    public static void main(String[]args) {
    JFrame newFrame = new JFrame();
        newFrame.setSize(600, 600);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        StaffView theView = new StaffView();
        StaffModel theModel = new StaffModel();
        //theModel.addNewEmployee("admin", "admin", "Vacation", 10, 10, 10);
        StaffController theController = new StaffController(theView, theModel);   
        newFrame.getContentPane().add(theView);
        newFrame.setVisible(true);
    
    }
}
