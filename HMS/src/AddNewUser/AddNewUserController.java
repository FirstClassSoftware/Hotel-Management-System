/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddNewUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

/**
 *
 * @author Yeejkoob Thao
 */
import usermanagementview.*;

public class AddNewUserController {

    private AddNewUserView addNewUserView;
    private AddNewUserModel addNewUserModel;
    private String effectiveUsername;
    private String effectivePassword;
    private String effectiveUserLevel;
    private UserView associatedUserView;

    public AddNewUserController(AddNewUserView currentForm, AddNewUserModel currentModel) {

        this.addNewUserView = currentForm;
        this.addNewUserModel = currentModel;
        this.associatedUserView = this.addNewUserView.getAssociatedUserView();
        this.addNewUserView.getInvalidUsernameLabel().setVisible(false);
        this.addNewUserView.getInvalidPasswordLabel().setVisible(false);
        this.addNewUserView.getInvalidRetypePasswordLabel().setVisible(false);
        this.addNewUserView.addSubmitButtonListener(new SubmitListener());

    } // End of AddNewUserController constructor

    class SubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // Validate the username and password fields
            String inputUsername = addNewUserView.getUsernameField();
            String inputPassword = addNewUserView.getPasswordField();
            String inputRetypePassword = addNewUserView.getRetypePasswordField();
            ButtonGroup userLevelOptions = addNewUserView.getUserLevelButtonGroup();
            JRadioButton receptionistChoice = addNewUserView.getReceptionistChoice();
            JRadioButton managerChoice = addNewUserView.getManagerChoice();
            JRadioButton ownerChoice = addNewUserView.getOwnerChoice();
            String inputUserLevel = addNewUserModel.getUserLevelSelection(userLevelOptions, receptionistChoice, managerChoice, ownerChoice);
            String retypeInputPassword = addNewUserView.getRetypePasswordField();
            boolean isInputUsernameValid = addNewUserModel.validateUsername(inputUsername);
            boolean isInputPasswordValid = addNewUserModel.validatePassword(inputPassword);
            boolean isInputRetypePasswordValid = addNewUserModel.validateRetypePassword(inputPassword, inputRetypePassword);
            boolean isInputUserLevelValid = addNewUserModel.validateUserLevel(inputUserLevel);
            boolean isInvalidUsernameLabelVisible = addNewUserView.getInvalidUsernameLabel().isVisible();
            boolean isInvalidPasswordLabelVisible = addNewUserView.getInvalidPasswordLabel().isVisible();
            boolean isInvalidRetypePasswordLabelVisible = addNewUserView.getInvalidRetypePasswordLabel().isVisible();

            // Set the error displays
            ////////////////////////////////////////////////////////////////////
            if (isInputUsernameValid == true) {
                if (isInvalidUsernameLabelVisible == true) {
                    addNewUserView.getInvalidUsernameLabel().setVisible(false);
                }
            } else {
                addNewUserView.getInvalidUsernameLabel().setVisible(true);
                addNewUserView.displayErrorMessage(addNewUserView.getInvalidUsernameLabel().getText());
            }
            ////////////////////////////////////////////////////////////////////
            if (isInputPasswordValid == true) {
                if (isInvalidPasswordLabelVisible == true) {
                    addNewUserView.getInvalidPasswordLabel().setVisible(false);
                }
            } else {
                addNewUserView.getInvalidPasswordLabel().setVisible(true);
                addNewUserView.displayErrorMessage(addNewUserView.getInvalidPasswordLabel().getText());
            }
            ////////////////////////////////////////////////////////////////////
            if (isInputRetypePasswordValid == true) {
                if (isInvalidRetypePasswordLabelVisible == true) {
                    addNewUserView.getInvalidRetypePasswordLabel().setVisible(false);
                }
            } else {
                addNewUserView.getInvalidRetypePasswordLabel().setVisible(true);
                addNewUserView.displayErrorMessage(addNewUserView.getInvalidRetypePasswordLabel().getText());
            }
            ////////////////////////////////////////////////////////////////////
            if (isInputUserLevelValid == false) {
                addNewUserView.displayErrorMessage("Please select a user level.");
            }
            ////////////////////////////////////////////////////////////////////
            // Add a new user when user information is valid
            if (isInputUsernameValid == true) {

                if (isInputPasswordValid == true) {

                    if (retypeInputPassword.equals(inputPassword)) {

                        addNewUserModel.addNewUser(
                                inputUsername,
                                inputPassword,
                                inputUserLevel);
                        // Update the table in the UserView
                        addNewUserView.getAssociatedUserController().updateUserTable();
                        addNewUserView.dispose();
                    }
                }
            } // End of checking InputUsernameValid if-statement

        } // End of the actionPerformed method

    } // End of the SubmitListener class

} // End of the AddNewUserController class
