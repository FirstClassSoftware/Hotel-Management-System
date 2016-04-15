/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddNewEmployee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yeejkoob Thao
 */
public class AddNewEmployeeController {

    private AddNewEmployeeView addNewEmployeeView;
    private AddNewEmployeeModel addNewEmployeeModel;

    public AddNewEmployeeController(AddNewEmployeeView currentView, AddNewEmployeeModel currentModel) {
        addNewEmployeeView = currentView;
        addNewEmployeeModel = currentModel;
        addNewEmployeeView.addSubmitButtonListener(new SubmitListener());

    } // End of the AddNewEmployeeController constructor

    class SubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ///////////////////////////////////////////////////////////////////
            String successMessage;
            String employeeFirstName;
            String employeeLastName;
            String employeeStatus;
            String employeeHoursWorked; // Will eventually be double
            String employeeHourlyWage;  // Will eventually be double 
            String employeeTotalPay;    // Will eventually be double
            boolean isInputEmployeeFirstNameValid;
            boolean isInputEmployeeLastNameValid;
            boolean isInputEmployeeStatusValid;
            boolean isInputEmployeeHoursWorkedValid;
            boolean isInputEmployeeHourlyWageValid;
            boolean isInputEmployeeTotalPayValid;       
            ///////////////////////////////////////////////////////////////////
            successMessage = "Successfully added a new employee.";
            employeeFirstName = addNewEmployeeView.getInputEmployeeFirstName();
            employeeLastName = addNewEmployeeView.getInputEmployeeLastName();
            employeeStatus = addNewEmployeeView.getInputEmployeeStatus();
            employeeHoursWorked = addNewEmployeeView.getInputEmployeeHoursWorked();
            employeeHourlyWage = addNewEmployeeView.getInputEmployeeHourlyWage();
            employeeTotalPay = addNewEmployeeView.getInputEmployeeTotalPay();
            isInputEmployeeFirstNameValid = addNewEmployeeModel.validateEmployeeFirstName(employeeFirstName);
            isInputEmployeeLastNameValid = addNewEmployeeModel.validateEmployeeLastName(employeeLastName);
            isInputEmployeeStatusValid = addNewEmployeeModel.validateEmployeeStatus(employeeStatus);
            isInputEmployeeHoursWorkedValid = addNewEmployeeModel.validateEmployeeHoursWorked(employeeHoursWorked);
            isInputEmployeeHourlyWageValid = addNewEmployeeModel.validateEmployeeHourlyWage(employeeHourlyWage);
            isInputEmployeeTotalPayValid = addNewEmployeeModel.validateEmployeeTotalPay(employeeTotalPay);       
            ///////////////////////////////////////////////////////////////////
            if (isInputEmployeeFirstNameValid
                    && isInputEmployeeLastNameValid
                    && isInputEmployeeStatusValid
                    && isInputEmployeeHoursWorkedValid
                    && isInputEmployeeHourlyWageValid
                    && isInputEmployeeTotalPayValid) {
                addNewEmployeeModel.addNewEmployee(
                        employeeFirstName,
                        employeeLastName,
                        employeeStatus,
                        employeeHoursWorked,
                        employeeHourlyWage,
                        employeeTotalPay);
                // Update the table in the StaffView
                addNewEmployeeView.getAssociatedStaffController().updateEmployeeTable();
                addNewEmployeeView.displayErrorMessage(successMessage);
                addNewEmployeeView.dispose();
            }
                    
            
        }

    } // End of the SubmitListener class

} // End of the AddNewEmployeeController class
