package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yeejkoob Thao
 */
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.UIManager.*;
public class HotelMain {
    public static void main(String[]args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        MainPanel mainPanel = new MainPanel();
        JFrame j = new JFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        //int xSize = ((int) tk.getScreenSize().getWidth());
        //int ySize = ((int) tk.getScreenSize().getHeight());
        //j.setSize(xSize,ySize);
        j.setSize(1500,917);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
        j.add(mainPanel);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setResizable(false);
    
    }
}
