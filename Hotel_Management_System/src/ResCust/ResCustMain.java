/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResCust;

// When finished, plan is to add the ReservationView panel to the already created
// mainFrame, but for testing, I will add it to a new Jframe in this main method
import javax.swing.JFrame;
import java.awt.Toolkit;

/**
 *
 * @author Whelan
 */
public class ResCustMain {
    
    public static void main(String[] args) {
        ReservationView v = new ReservationView();
        ReservationModel m = new ReservationModel();
        
        ReservationControl c = new ReservationControl(v,m);
        
        JFrame j = new JFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        j.setSize(xSize,ySize);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
        j.add(v);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        v.registerListener();
        v.setVisible(true);
    }
    
}
