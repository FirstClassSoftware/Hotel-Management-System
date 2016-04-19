/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoreEmployeeInformationComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import staff.Employee;
import staff.PayrollInformation;
/**
 *
 * @author Yeejkoob Thao
 */
public class MoreEmployeeInformationController {
    private MoreEmployeeInformationView moreEmployeeInfoView;
    private MoreEmployeeInformationModel moreEmployeeInfoModel;
    private int selectedEmployeeId;
    private Employee selectedEmployee;
    public MoreEmployeeInformationController(MoreEmployeeInformationView view, MoreEmployeeInformationModel model) {
        this.moreEmployeeInfoView = view;
        this.moreEmployeeInfoModel = model;
        this.selectedEmployeeId = moreEmployeeInfoView.getSelectedEmployeeId();
        this.selectedEmployee = moreEmployeeInfoModel.deserializeEmployee(selectedEmployeeId);
        System.out.println(selectedEmployee.getFirstName());
        this.moreEmployeeInfoView.addGoBackButtonListener(new GoBackListener());
        this.updateMoreEmployeeInfoTable();
    }
    
    class GoBackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moreEmployeeInfoView.dispose();
        }
        
    }
    
     class MyTableModel extends DefaultTableModel {
         
        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 0) {
                // The first column will be uneditable.
                return false;
            } else {
                return true;
            }
        }
    } // End of the MyTableModel class

    public void updateMoreEmployeeInfoTable() {
        JTable moreEmployeeInfoTable = moreEmployeeInfoView.getMoreEmployeeInfoTable();
        MyTableModel moreEmployeeInfoTableModel = new MyTableModel();
        
        ArrayList <PayrollInformation> payrollList = selectedEmployee.getPayroll();
        String payPeriod;
        String clockIn;
        String clockOut;
        int hoursWorked;
        double hourlyWage;
        double dailyPay;
        PayrollInformation currentPayrollInformation;
        
        moreEmployeeInfoTableModel.addColumn("Pay Period");
        moreEmployeeInfoTableModel.addColumn("Clocked In");
        moreEmployeeInfoTableModel.addColumn("Clocked Out");
        moreEmployeeInfoTableModel.addColumn("Hours Worked");
        moreEmployeeInfoTableModel.addColumn("Hourly Wage");
        moreEmployeeInfoTableModel.addColumn("Daily Pay");
        
        for(int index = 0; index < payrollList.size(); index++) {
            currentPayrollInformation = payrollList.get(index);
            payPeriod = currentPayrollInformation.getPayPeriod();
            clockIn = currentPayrollInformation.getClockIn();
            clockOut = currentPayrollInformation.getClockOut();
            hoursWorked = currentPayrollInformation.getHoursWorked();
            hourlyWage = currentPayrollInformation.getHourlyWage();
            dailyPay = currentPayrollInformation.getDailyPay();
            
            moreEmployeeInfoTableModel.addRow(new Object[]{
                payPeriod,
                clockIn,
                clockOut,
                hoursWorked,
                hourlyWage,
                dailyPay});
        } // End of the for loop traversing through the payrollList
        moreEmployeeInfoTable.setModel(moreEmployeeInfoTableModel);
    } // End of the updateMoreEmployeeInfoTable method
}
