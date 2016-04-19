/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Main
 */
import login.*;
import javax.swing.*;
public class LoginTestDriver {
    
    public static void main(String[]args) {
        
        LoginModel model = new LoginModel();
        LoginView view = new LoginView();
        LoginController controller = new LoginController(view, model);
        JFrame newFrame = new JFrame();
        newFrame.setSize(500, 300);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.getContentPane().add(view);
        newFrame.setVisible(true);
        
    }
    
}
