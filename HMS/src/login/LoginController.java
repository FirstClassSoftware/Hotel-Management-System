package login;

/**
 *
 * @author Yeejkoob Thao
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import home.*;

public class LoginController {

    private LoginView currentLoginView;
    private LoginModel currentLoginModel;
    private String SQL;
    private String effectiveUserLevel;
    private String effectiveUsername;
    private String effectivePassword;

    public LoginController(LoginView newLoginView, LoginModel newLoginModel) {

        this.currentLoginView = newLoginView;
        this.currentLoginModel = newLoginModel;

        // Add in action handlers here and define a new class for each of them
        // Validate username and password here.
        this.currentLoginView.addLoginButtonListener(new LoginListener());
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String inputUsername = currentLoginView.getInputUsername();
            String inputPassword = currentLoginView.getInputPassword();
            boolean isUserValid = currentLoginModel.validateUser(inputUsername, inputPassword);
            if (isUserValid) {

                effectiveUsername = currentLoginView.getInputUsername();
                effectivePassword = currentLoginView.getInputPassword();
                effectiveUserLevel = currentLoginModel.getEffectiveUserLevel(inputUsername);
                
                // Update the login date in the USER table in the database
                currentLoginModel.recordUserLoginTime(effectiveUsername);
                currentLoginView.getAssociatedUserController().updateUserTable();
                ////////////////////////////////////////////////////////////////
                // Generate the HomeView.
                HomeView associatedHomeView = currentLoginView.getAssociatedHomeView();
                HomeController associatedHomeController = currentLoginView.getAssociatedHomeController();
                associatedHomeView.setUserLevelLabel(effectiveUserLevel);
                associatedHomeController.checkPermissions();
                currentLoginView.goToHomeView();
                

            } else {

                currentLoginView.displayErrorMessage("Invalid username or "
                        + "password");

            }
        } // end of the actionPerformed method

    }

} // End of the LoginController class
